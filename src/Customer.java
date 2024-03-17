public class Customer {
    private ShoppingCart shoppingCart;
    private int customerID; // Müşteriye özgü bir ID


    public Customer(int customerID) {
        this.shoppingCart = new ShoppingCart();
        this.customerID = customerID;
    }

    // sepete ürün ekleme
    public void addToCart(Product product) {
        shoppingCart.addToCart(product);
        System.out.println("Ürün sepete eklendi: " + product.getName());
    }


    //sepetten ürün cıkartma
    public void removeFromCart(Product product) {
        boolean removed;
        removed = shoppingCart.removeFromCart(product);
        if (removed) {
            System.out.println("Ürün sepetten çıkarıldı: " + product.getName());
        } else {
            System.out.println("Ürün sepetinizde bulunamadı: " + product.getName());
        }
    }


    public void joinQueue(Queue customerQueue) {
        customerQueue.addQueue(customerID);
        System.out.println("Müşteri kuyruğa eklendi. Müşteri ID: " + customerID);
    }





    public int getCustomerID() {
        return customerID;
    }



}
