public class Customer {
    private ShoppingCart shoppingCart;

    public Customer(){
        this.shoppingCart=new ShoppingCart();
    }

    // sepete ürün ekleme
    public void addToCart(Product product){
        shoppingCart.addToCart(product);
    }


    //sepetten ürün cıkartma
    public void removeFromCart(Product product){
        shoppingCart.addToCart(product);
    }





}
