import java.util.Scanner;

public class CashierOperations {
    ProductManager productManager;
    private Scanner inp = new Scanner(System.in);

    public CashierOperations(ProductManager productManager) {
        this.productManager = productManager;
    }


    public void updateProduct(int barcode, String name, Double price) {

        System.out.println("""
                                
                ----------  Ürün Güncelleme  ---------
                1-Barkod Güncelleme
                2-Fiyat Güncelleme
                3-İsim Güncelleme
                0-Çıkış Yap
                --------------------------------------
                Enter:\\s""\");
                    
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


}
