import java.util.Scanner;
import java.util.HashMap;
import java.util.Objects;

public class Customer implements Runnable{
    private int customerID;
    private String customerName;
    private String customerEmail;
    private String customerPassword;
    private String customerConfirmPassword;

    public Customer(int customerID,String customerName,String customerEmail, String customerPassword,String customerConfirmPassword) {
        this.customerID = customerID;
        this.customerName = customerName;
        this.customerEmail = customerEmail;
        this.customerPassword = customerPassword;
        this.customerConfirmPassword = customerPassword;
    }

    public int getCustomerID() {
        return customerID;
    }
    public String getCustomerName() {
        return customerName;
    }
    public String getCustomerEmail() {
        return customerEmail;
    }
    public String getCustomerPassword() {
        return customerPassword;
    }
    public String getCustomerConfirmPassword() {
        return customerConfirmPassword;
    }

    private static String cName;
    private static String cEmail;
    private static String cPassword;
    private static String cConfirmPassword;
    private static int cID;
    private static Boolean customerOptionValidate;

    static Scanner input = new Scanner(System.in);

    public static HashMap<String,Customer> customers = new HashMap<String,Customer>();
    public static HashMap<String,String> customerDetails = new HashMap<String,String>();

    public static void customerRegister(){
        try{
            System.out.println(" ");
            System.out.println("💻💻💻💻💻💻💻💻💻💻💻💻💻💻💻");
            System.out.println("🚀🚀🚀 Customer Registration 🚀🚀🚀");
            System.out.println(" ");
            while(true){
                System.out.print("Name: ");
                cName = input.nextLine();
                if(cName.trim().isEmpty()){
                    System.out.println("Name can not be empty");
                }else if(!cName.matches("[a-zA-z\\s]+")){
                    System.out.println("Name can only contains letters");
                }else if(cName.length()<3){
                    System.out.println("Not a valid name");
                } else if (customers.containsKey(cName)) {
                    System.out.println("Customer already exists");
                    System.out.println("Use another Customer name");
                }else{
                    break;
                }
            }
            while(true){
                System.out.print("Email: ");
                cEmail = input.nextLine();
                if(cName.trim().isEmpty()){
                    System.out.println("Email can not be empty");
                }else if(cEmail.length()<13){
                    System.out.println("Not a valid email");
                }else if(customerDetails.containsKey(cEmail)){
                    System.out.println("Customer already has an Account ");
                    System.out.println("Use another email");
                }else{
                    break;
                }
            }
            while(true){
                System.out.print("Password: ");
                cPassword = input.nextLine();
                if(cPassword.trim().isEmpty()){
                    System.out.println("Password can not be empty");
                }else if (cPassword.length()<6){
                    System.out.println("Password must be at least 6 characters");
                }else if(customerDetails.containsKey(cPassword)){
                    System.out.println("Use another password");
                }else{
                    break;
                }
            }
            while(true){
                System.out.print("Confirm Password: ");
                cConfirmPassword = input.nextLine();
                if(cConfirmPassword.trim().isEmpty()){
                    System.out.println("Confirm Password can not be empty");
                }else if(cConfirmPassword.length()<6){
                    System.out.println("Confirm Password must be at least 6 characters");
                }else if(!Objects.equals(cPassword, cConfirmPassword)){
                    System.out.println("Confirm Password does not match");
                }else{
                    break;
                }
            }
        }catch(Exception e){
            System.out.println("Please enter valid details");
        }
        cID = cID+1;
        Customer customer = new Customer(cID,cName,cEmail,cPassword,cConfirmPassword);
        System.out.println("Customer ID: "+customer.getCustomerID());
        customers.put(cName,customer);
        customerDetails.put(cEmail,cPassword);
        System.out.println(customer.getCustomerName()+" is registered successfully as a Customer ");
    }

    public static Customer customerLogin(){
        System.out.println(" ");
        System.out.println("💻💻💻💻💻💻💻💻💻💻💻💻💻💻💻");
        System.out.println("🚀🚀🚀 Customer Login 🚀🚀🚀");
        System.out.println(" ");
        while(true){
            System.out.print("Customer Name: ");
            cName = input.nextLine();
            if(cName.trim().isEmpty()) {
                System.out.println("Name can not be empty");
            }else if(cName.length()<3){
                System.out.println("Not a valid name");
            }else if(!customers.containsKey(cName)){
                System.out.println("Customer name not found");
            }else{
                break;
            }
        }
        Customer customer = customers.get(cName);
        while(true){
            System.out.print("Customer Password: ");
            cPassword = input.nextLine();
            if(cPassword.trim().isEmpty()){
                System.out.println("Password can not be empty");
            }else if (cPassword.length()<6){
                System.out.println("Password must be at least 6 characters");
            }else if(!customer.getCustomerPassword().equals(cPassword)){
                System.out.println("Password does not match");
                System.out.println("Password incorrect");
            }else{
                System.out.println("Customer Login Successful");
                break;
            }
        }
        return customer;
    }

    public static void setupCustomerConfiguration(Customer customer){
        customerOptionValidate = false;
        while(!customerOptionValidate){
            System.out.println(" ");
            System.out.println("1.Buy Ticket");
            System.out.println("2.Exit");
            System.out.println(" ");
            int customerOption = input.nextInt();
            if(customerOption == 1){
                TicketPool.removeTicket(customer);
            }else if(customerOption == 2){
                customerOptionValidate = true;
                Main.controlMenu();
                break;
            }
        }
    }



    @Override
    public void run() {

    }


}
