import java.util.Stack;

public class ShoppingCart {
    private Stack<Product> stack;


    public ShoppingCart() {
        this.stack = new Stack<>();
    }



    // Sepeti temizle
    public void clearCart() {
        stack.clear();
    }


    //ekleme
    public void addToCart(Product product) {
        stack.push(product);
        System.out.println(product.getName() + " sepete eklendi.");
    }

    //cikarma
    public boolean removeFromCart(Product product) {
        if (!stack.isEmpty()) {
            Product removedProduct = stack.pop();
            System.out.println(removedProduct.getName() + " sepetten çıkarıldı.");
            return true;
        } else {
            System.out.println("Sepet boş.");
            return false;
        }
    }

    //ürünün sepette olup olmadıgını kontrol ettim
    public boolean isProductInCart(int barcode){
        for (Product product : stack){
            if (product.getBarcode() == barcode){
                return true;
            }
        }
        return false;
    }



    //sepeti yazdirma müsteri icin
    public void printCart(){
        if (!stack.isEmpty()){
            System.out.println("Sepetteki ürünler:");
            for (Product product : stack){
                System.out.println("Barkod: " + product.getBarcode() + "\t Ürün Adı: " + product.getName() + "\t Fiyat: " + product.getPrice());
            }
        }else {
            System.out.println("Sepetiniz boş.");
        }
    }


    // Sepetin toplam tutarı hesap
    public double calculateTotalPrice() {
        double totalPrice = 0;
        for (Product product : stack) {
            totalPrice += product.getPrice();
        }
        return totalPrice;
    }

}
