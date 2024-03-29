import java.util.Scanner;

public class CashierOperations {
    ProductManager productManager;
    private Scanner inp = new Scanner(System.in);
    private int total;

    public CashierOperations(ProductManager productManager) {
        this.productManager = productManager;
        this.total=0;
    }


    public void updateProduct(int barcode) {
        System.out.println("""
                ----------  Ürün Güncelleme  ---------
                1 - Barkod Güncelleme
                2 - Fiyat Güncelleme
                3 - İsim Güncelleme
                0 - Çıkış Yap
                --------------------------------------                    
                """);

        int choice = inp.nextInt();
        inp.nextLine();

        switch (choice) {
            case 0:
                System.out.println("Çıkış yapılıyor..");
                break;
            case 1:
                System.out.println("Lütfen 'Yeni' ürün barkod numarasını giriniz:");
                int newBarcodeNum = inp.nextInt();
                inp.nextLine();
                productManager.getUpdateBarcode(barcode, newBarcodeNum);
                break;
            case 2:
                System.out.println("Lütfen 'Yeni' ürün fiyatını giriniz:");
                double newPrice = inp.nextDouble();
                inp.nextLine();
                productManager.getUpdatePrice(barcode, newPrice);
                break;
            case 3:
                System.out.println("Lütfen 'Yeni' ürün adını giriniz:'");
                String newName = inp.nextLine();
                productManager.getUpdateName(barcode, newName);
                break;
            default:
                System.out.println("Geçersiz bir deger girdiniz !");
        }
    }


    public void processCustomer(Customer currentCustomer) {
        System.out.println("Müşteri işlemi başlatıldı. Müşteri ID: " + currentCustomer.getCustomerID());

        System.out.println("Müşterinin Sepeti:");
        boolean inProcess = true;
        while (inProcess){

            System.out.println("""
                -------- Lütfen İşlem Seçiniz --------
                1 - Ürün Okut
                0 - Çıkış Yap
                --------------------------------------                    
                """);

            currentCustomer.printCustomerCart();
            int choice = inp.nextInt();
            inp.nextLine();
            switch (choice){
                case 0:
                    System.out.println("Müşteri işlemi sonlandırılıyor...");
                    System.out.println("Toplam Tutar: " + total);
                    clearCustomerCart(currentCustomer);
                    inProcess=false;
                    break;
                case 1:
                    System.out.println("Lütfen ürünün barkod numarasını okutun:");
                    int barcode = inp.nextInt();
                    inp.nextLine();

                    boolean isInCart=currentCustomer.getShoppingCart().isProductInCart(barcode);

                    if (isInCart){
                        double price = getProductPriceByBarcode(barcode);
                        total += price;
                        System.out.println("Ürün fiyatı: " + price);
                        currentCustomer.removeFromCart(productManager.getProductByBarcode(barcode));
                    }else {
                        System.out.println("Ürün bulunamadı.");
                    }

                    break;
                default:
                    System.out.println("Geçersiz bir seçenek girdiniz.");

            }
        }
        clearCustomerCart(currentCustomer);

    }


    private void clearCustomerCart(Customer customer) {
        customer.getShoppingCart().clearCart();
    }


    private double getProductPriceByBarcode(int barcode) {
        Product product = productManager.getProductByBarcode(barcode);
        if (product != null) {
            return product.getPrice();
        } else {
            return -1; //urun bulunamadı durumu
        }
    }



}
