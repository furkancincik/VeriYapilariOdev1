public class Main {
    public static void main(String[] args) {
        // Önce gerekli nesneleri oluşturalım
        ProductManager productManager = new ProductManager();
        CashierOperations cashier = new CashierOperations(productManager);
        Queue customerQueue = new Queue();

        // Panel nesnesini oluştururken gerekli nesneleri parametre olarak geçirelim
        Panel panel = new Panel(cashier, customerQueue);

        // Panel üzerinden işlemleri gerçekleştirebiliriz
        panel.addCustomerToQueue(1); // Örnek olarak bir müşteriyi kuyruğa ekleyelim
        panel.addCustomerToQueue(2); // Örnek olarak bir müşteriyi kuyruğa ekleyelim
        panel.addCustomerToQueue(3); // Örnek olarak bir müşteriyi kuyruğa ekleyelim
        panel.performCashierOperations();
    }
}
