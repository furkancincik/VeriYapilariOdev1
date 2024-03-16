import java.util.Stack;

public class ShoppingCart {
    private Stack<Product> stack;


    public ShoppingCart(){
        this.stack=new Stack<>();
    }


    //ekleme
    public void addToCart(Product product) {
        stack.push(product);
        System.out.println(product.getName() + " sepete eklendi.");
    }

    //cikarma
    public void removeFromCart(){
        if (!stack.isEmpty()){
            Product removedProduct=stack.pop();
            System.out.println(removedProduct.getName() + " sepetten çıkarıldı.");
        }else{
            System.out.println("Sepet boş.");
        }
    }


    //sepeti yazdirma
    public void printCart(){
        if (!stack.isEmpty()){
            System.out.println("Sepetinizdeki ürünler:");
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
