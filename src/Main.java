public class Main {
    public static void main(String[] args) {
        ProductManager productManager = new ProductManager();
        CashierOperations cashierOperations = new CashierOperations(productManager);
        Queue customerQueue = new Queue();
        Panel panel = new Panel(cashierOperations, customerQueue);

        Customer customer1 = new Customer(1,new ShoppingCart());


        panel.run(customer1);
    }
}
