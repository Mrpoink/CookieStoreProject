import java.io.*;
import java.util.ArrayList;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.*;
import java.util.*;

public class Register {
    ArrayList<String> names = new ArrayList <String>();
    ArrayList<String> allergies = new ArrayList<String>();
    ArrayList<String> prices = new ArrayList<String>();
    ArrayList<String> sizes = new ArrayList<String>();
    ArrayList<Register> usableList = new ArrayList<Register>();
    String name;
    String allergy;
    String price;
    String size;

    public Register(){
        try{
            File input = new File("/home/mrpoink/CookieStore/src/Cookies.xml");
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(input);

            NodeList nl1 = doc.getElementsByTagName("Cookie");
            for(int i=0; i<nl1.getLength(); i++){
                Node nNode = nl1.item(i);
                Element eElement = (Element) nNode;
                String name = eElement.getAttribute("id");
                String allergy = eElement.getElementsByTagName("Allergy")
                        .item(0).getTextContent();
                String price = eElement.getElementsByTagName("Price")
                        .item(0).getTextContent();
                String size = eElement.getElementsByTagName("Size")
                        .item(0).getTextContent();
                names.add(name);
                allergies.add(allergy);
                prices.add(price);
                sizes.add(size);
                Register register = new Register(name, allergy, price, size);
                usableList.add(register);

            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    private Register(String name, String allergy, String price, String size){
        this.name = name;
        this.allergy = allergy;
        this.price = price;
        this.size = size;
    }
    public Register getRegister(String name){
        for (Register register : usableList){
            if (register.name.equals(name)){
                return register;
            }
        }
        return null;
    }
    public void getAllInfo(){
        for(Register register : usableList){
            System.out.println("Name: " + register.name);
            System.out.println("Allergy: " + register.allergy);
            System.out.println("Price: " + register.price);
            System.out.println("Size: " + register.size);
            System.out.println("-----------------------");
        }
    }

    public void GetNames(){
        for(String name : names){
            System.out.println(name);

        }
    }
    public void GetAllergy(){
        for(String name : allergies){
            System.out.println(name);
        }
    }
    public void GetPrice(){
        for(String name : prices){
            System.out.println(name);
        }
    }
    public void GetSize(){
        for(String name : sizes){
            System.out.println(name);
        }
    }
    public String toString(String name){
        for(int i = 0; i<names.size(); i++){
            if(names.get(i).equals(name)){
                return String.format("Name: %s\nAllergy %s\nPrice %s\nSize %s",name,allergies.get(i),prices.get(i),sizes.get(i));
            }
        }
        return "";
    }

}