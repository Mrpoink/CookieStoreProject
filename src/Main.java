import java.util.Scanner;


public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        Register register = new Register();

        System.out.println("Menu:");
        register.getAllInfo();
        System.out.println("Enter Customer name: ");
        String name = scan.nextLine();
        Customer c = new Customer(name);
        System.out.println("Would you like to view receipt?");
        String choice = scan.nextLine();
        if (choice.equals("yes")) {
            Total tot = new Total(c, name);
        }

    }
}