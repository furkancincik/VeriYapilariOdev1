public class Main {
    public static void main(String[] args) {
        // ProductManager oluştur
        ProductManager productManager = new ProductManager();

        // CashierOperations oluştur ve ProductManager nesnesini geçir
        CashierOperations cashierOperations = new CashierOperations(productManager);

        // Queue ve Panel nesnelerini oluştur
        Queue customerQueue = new Queue();
        Panel panel = new Panel(cashierOperations, customerQueue);

        // Panel'in performCustomerOperations metodu için müşteri oluştur
        Customer customer1 = new Customer(1);
        Customer customer2 = new Customer(2);
        Customer customer3 = new Customer(3);
        Customer customer4 = new Customer(4);

        // Panel'i çalıştır
        panel.run(customer1);
    }
}
