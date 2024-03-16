import java.util.LinkedList;
import java.util.Scanner;

public class ProductManager {
    private LinkedList<Product> productList;
    private Scanner inp = new Scanner(System.in);



    public LinkedList<Product> getProductList(){
        productList.add(new Product(1,"Ekmek",8.0));
        productList.add(new Product(2,"Su",5.50));
        productList.add(new Product(3,"Pirinç",55.35));
        productList.add(new Product(4,"Domates",34.95));
        productList.add(new Product(5,"Sabun",13.50));
        productList.add(new Product(6,"Şampuan",55.00));
        productList.add(new Product(7,"Çamaşır Suyu",79.95));
        productList.add(new Product(8,"Yüzey Temizleyici",88.90));
        productList.add(new Product(9,"Pil",64.00));
        productList.add(new Product(10,"Ampul",43.90));
        productList.add(new Product(11,"USB",170.00));
        return productList;
    }


    //Ürün listesini yazdırma
    public void getPrintProductList(){
        System.out.println("Ürün Listesi:");
        for (Product product : productList){
            System.out.println("Barkod: "+product.getBarcode()+"\t Ürün Adı: "+product.getName()+"\t ÜrünFiyatı: "+product.getPrice());
        }
    }



    //Ürün ekleme
    public void getAddProduct(int barcode, String name, Double price) {
        Product newProduct = new Product(barcode, name, price);
        productList.add(newProduct);
    }


    //Ürün silme
    public void getRemoveProduct(int barcode) {
        for (Product product : productList) {
            if (product.getBarcode() == barcode) {
                productList.remove(product);
                break;
            }
        }
    }


    //Barkod güncelleme
    public void getUpdateBarcode(int barcode, int newBarcode) {
        // Barkod numarasına göre ürünü bul ve barkod numarasını güncelle
        for (Product product : productList) {
            if (product.getBarcode() == barcode) {
                product.setBarcode(newBarcode);
                System.out.println("Barkod başarıyla güncellendi.");
                return;
            }
        }
        System.out.println("Ürün bulunamadı!");
    }


    //Fiyat Güncelleme
    public void getUpdatePrice(int barcode, double newPrice) {
        // Barkod numarasına göre ürünü bul ve fiyatı güncelle
        for (Product product : productList) {
            if (product.getBarcode() == barcode) {
                product.setPrice(newPrice);
                System.out.println("Fiyat başarıyla güncellendi.");
                return;
            }
        }
        System.out.println("Ürün bulunamadı!");
    }


    //İsim Güncelleme
    public void getUpdateName(int barcode, String newName){
        // Barkod numarasına göre ürünü bul ve ismini güncelle
        for (Product product:productList){
            if (product.getBarcode() == barcode){
                product.setName(newName);
                System.out.println("Ürün ismi başarıyla güncellendi.");
                return;
            }
        }
        System.out.println("Ürün bulunamadı!");
    }






}
