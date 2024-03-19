import java.util.Stack;

public class ShoppingCart {
    private Stack<Product> stack;


    public ShoppingCart() {
        this.stack = new Stack<>();
    }



    public void clearCart() {
        stack.clear();
    }


    public void addToCart(Product product) {
        stack.push(product);
        System.out.println(product.getName() + " sepete eklendi.");
    }


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

    public boolean isProductInCart(int barcode){
        for (Product product : stack){
            if (product.getBarcode() == barcode){
                return true;
            }
        }
        return false;
    }



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


    public double calculateTotalPriceToCart() {
        double totalPrice = 0;
        for (Product product : stack) {
            totalPrice += product.getPrice();
        }
        return totalPrice;
    }

}
