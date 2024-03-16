import java.util.Scanner;

public class Panel {
    CashierOperations cashier;
    private Queue customerQueue;
    private Scanner inp=new Scanner(System.in);


    public Panel(CashierOperations cashier, Queue customerQueue) {
        this.cashier = cashier;
        this.customerQueue=customerQueue;
    }



    //müşteri ekleme
    public void addCustomerToQueue(int customerID){
        customerQueue.addQueue(customerID);
        System.out.println("Müşteri kuyruğa eklendi. Müşteri ID: " + customerID);
    }

    //kuyruk durumu kontrol print
    public void checkQueueStatus(){
        customerQueue.printQueue();
    }

    // Kasiyer işlemleri
    public void performCashierOperations() {
        if (!customerQueue.isEmpty()) { // Kuyruk boş değilse işlem yap
            int currentCustomerID = customerQueue.peek(); // Kuyruktaki ilk müşterinin ID'sini al
            System.out.println("Şu anda işlem yapılan müşteri ID: " + currentCustomerID);

            // Kasiyerin işlem yapması için gerekli metodlar çağrılır
            cashier.processCustomer(currentCustomerID);

            // İşlem tamamlandıktan sonra müşteri kuyruktan çıkarılır
            customerQueue.deleteQueue();
            System.out.println("Müşteri işlemi tamamlandı. Müşteri ID: " + currentCustomerID + " kuyruktan çıkarıldı.");
        } else {
            System.out.println("Kuyruk boş, işlem yapılabilecek müşteri yok.");
        }
    }











}
