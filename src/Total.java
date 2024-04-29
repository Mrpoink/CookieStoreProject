import java.util.*;

public class Total{
    Double totality = 0.0;
    public Total(Customer customer, String name1){
        for (String name: customer.customerList.keySet()){
            LinkedList<Register> reg = customer.customerList.get(name);
            for(int i = 0; i<reg.size(); i++){
                Register reg1 = reg.get(i);
                Double temp = Double.parseDouble(reg1.price);
                totality = totality + temp;
            }

            }
        customer.getCustomerReceipt(name1);
        System.out.println("Total: $" + totality);

    }
}
