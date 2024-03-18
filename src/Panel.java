import java.util.Scanner;

public class Panel {
    CashierOperations cashier;
    private Queue customerQueue;
    private Scanner inp = new Scanner(System.in);



    public Panel(CashierOperations cashier, Queue customerQueue) {
        this.cashier = cashier;
        this.customerQueue = customerQueue;
    }



    //müşteri ekleme
    public void addCustomerToQueue(int customerID) {
        customerQueue.addQueue(customerID);
        System.out.println("Müşteri kuyruğa eklendi. Müşteri ID: " + customerID);
    }

    //kuyruk durumu kontrol print
    public void checkQueueStatus() {
        customerQueue.printQueue();
    }


    public void run(Customer customer) {
        boolean isRunning = true;
        while (isRunning) {
            System.out.println("""
                1 - Müşteri İşlemleri
                2 - Kasiyer İşlemleri
                0 - Çıkış
                """);

            int choice = inp.nextInt();
            inp.nextLine();
            switch (choice) {
                case 0:
                    System.out.println("Çıkış yapılıyor...");
                    isRunning = false;
                    break;
                case 1:
                    performCustomerOperations(customer);
                    break;
                case 2:
                    performCashierOperations();
                    break;
                default:
                    System.out.println("Geçersiz bir seçenek girdiniz !");
            }
        }
    }


    //Müşteri işlemleri
    public void performCustomerOperations(Customer currentCustomer) {
        boolean runnning = true;

        while (runnning) {
            System.out.println("""
                    Müşteri İşlemleri:
                    1 - Sepete Ürün Ekle
                    2 - Sepetten Ürün Çıkar
                    3 - Kuyruğa Katıl
                    4 - Kuyruk Durumunu Kontrol Et
                    0 - Çıkış
                    """);

            int choice = inp.nextInt();
            inp.nextLine();
            switch (choice) {
                case 0:
                    runnning = false;
                    break;
                case 1:
                    System.out.println("Ürün barkod numarasını giriniz:");
                    int barcode = inp.nextInt();
                    inp.nextLine();
                    Product product = cashier.productManager.getProductByBarcode(barcode);
                    if (product != null) {
                        currentCustomer.addToCart(product);
                    } else {
                        System.out.println("Ürün bulunamadı.");
                    }
                    break;
                case 2:
                    System.out.println("Ürünün barkod numarasını giriniz:");
                    int removeByBarcode = inp.nextInt();
                    inp.nextLine();
                    Product removeProduct = cashier.productManager.getProductByBarcode(removeByBarcode);
                    if (removeProduct != null){
                        currentCustomer.removeFromCart(removeProduct);
                    }else {
                        System.out.println("Ürün bulunamadı.");
                    }
                    break;
                case 3:
                    addCustomerToQueue(currentCustomer.getCustomerID());
                    break;
                case 4:
                    checkQueueStatus();
                    break;
                default:
                    System.out.println("Geçersiz bir seçenek girdiniz !");

            }
        }

    }


    // Kasiyer işlemleri
    public void performCashierOperations() {
        if (!customerQueue.isEmpty()) { // Kuyruk boş değilse işlem yap
            int currentCustomerID = customerQueue.peek(); // Kuyruktaki ilk müşterinin ID'sini al
            System.out.println("Şu anda işlem yapılan müşteri ID: " + currentCustomerID);

            cashier.processCustomer(currentCustomerID);

            customerQueue.deleteQueue(currentCustomerID);
            System.out.println("Müşteri işlemi tamamlandı. Müşteri ID: " + currentCustomerID + " kuyruktan çıkarıldı.");
        } else {
            System.out.println("Kuyruk boş, işlem yapılabilecek müşteri yok.");
        }

        checkQueueStatus();
    }


}
