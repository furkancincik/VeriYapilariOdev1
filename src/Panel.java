import java.util.Scanner;

public class Panel {
    CashierOperations cashier;
    Customer customer;
    private Scanner inp=new Scanner(System.in);




    public void run(){

        System.out.println("ürün güncelleme sayfasına hoşgeldiniz \n");

        System.out.println("Barkod:");
        int barcode= inp.nextInt();
        inp.nextLine();

        System.out.println("İsim:");
        String name=inp.nextLine();

        System.out.println("Fiyat:");
        double
        cashier.updateProduct();


    }

















}
