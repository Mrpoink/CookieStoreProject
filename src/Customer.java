import java.util.*;

public class Customer extends Register{
    LinkedList<Register> receipt = new LinkedList<Register>();
    HashMap<String, LinkedList<Register>> customerList = new HashMap<>();
    Scanner scan = new Scanner(System.in);
    String name;

    public Customer(String name) {
        this.name = name;
        while (true){
            System.out.print("Enter Item to Add or q to quit: ");
            String input = scan.nextLine();
            if (input.equals("q")){
                if(receipt.isEmpty()){
                    break;
                }else{
                    customerList.put(input,receipt);
                }
                break;
            }
            Register register = new Register();
            Register reg = register.getRegister(input);
            receipt.add(reg);
        }
    }
    public void getCustomerReceipt(String name){
        int i = 0;
        for (Register reg : receipt){
            i = i + 1;
            System.out.println(String.format("Item %d: %s | Price: $%s", i, reg.name, reg.price));
        }
    }
    public void getAllInfo(){
        for (int i = 0; i < customerList.size(); i++){
            for (String key : customerList.keySet()){
                System.out.println(customerList.get(key));
                System.out.println(customerList.get(key).get(i));
            }
        }
    }
}
