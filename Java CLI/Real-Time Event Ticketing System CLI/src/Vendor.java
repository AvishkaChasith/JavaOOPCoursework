import java.util.HashMap;
import java.util.Objects;
import java.util.Scanner;

public class Vendor extends UserConfiguration implements Runnable {
    private static String vendorName;
    private static String vendorEmail;
    private static String vendorPassword;
    private static String vendorConfirmPassword;
    private static int vendorId;


    private final int vendorID;
    private final String name;
    private final String email;
    private final String password;
    private final String confirmPassword;


    public Vendor(int vendorID,String name, String email, String password, String confirmPassword) {
        this.vendorID = vendorID;
        this.name = name;
        this.email = email;
        this.password = password;
        this.confirmPassword = confirmPassword;
    }
    public int getVendorID() {
        return vendorID;
    }
    public String getName() {
        return name;
    }
    public String getPassword() {
        return password;
    }
    public static HashMap<String,Vendor> vendors = new HashMap<String,Vendor>();
    public static HashMap<String,String> vendorsDetails = new HashMap<String,String>();

    public static void  vendorRegister(){
        try{
            Scanner input = new Scanner(System.in);
            System.out.println(" ");
            System.out.println("////////////////======================/////////////////");
            System.out.println("//////////////// Vendor Registration  /////////////////");
            System.out.println(" ");
            while (true){
                System.out.print("Name: ");
                vendorName = input.nextLine();
                if(vendorName.trim().isEmpty()){
                    System.out.println("Name cannot be empty");
                } else if (!vendorName.matches("[a-zA-Z\\s]+")) {
                    System.out.println("Name contains a letter");
                }else if(vendorName.length()<3){
                    System.out.println("Not a Valid Vendor Name");
                }else if(vendors.containsKey(vendorName)){
                    System.out.println("Vendor Already Exists");
                    System.out.println("Use another Vendor Name");
                }else{
                    break;
                }
            }
            while(true){
                System.out.print("Email: ");
                vendorEmail = input.nextLine();
                if(vendorEmail.trim().isEmpty()){
                    System.out.println("Email cannot be empty");
                }else if(vendorEmail.length()<13){
                    System.out.println("Not a Valid Vendor Email");
                }else if(vendorsDetails.containsKey(vendorEmail)){
                    System.out.println("Gmail has already an account. Please use another Vendor Email for creating a new one.");
                }else {
                    break;
                }
            }
            while(true){
                System.out.print("Password: ");
                vendorPassword = input.nextLine();
                if(vendorPassword.trim().isEmpty()){
                    System.out.println("Password cannot be empty");
                }
                else if(vendorPassword.length()<6) {
                    System.out.println("Not a Valid Vendor Password");

                }else if (vendorsDetails.containsValue(vendorPassword)){
                   System.out.println("Use another password");
                }else {
                    break;
                }
            }
            while(true){
                System.out.print("Confirm Password: ");
                vendorConfirmPassword = input.nextLine();

                if(vendorConfirmPassword.trim().isEmpty()){
                    System.out.println("Confirm Password cannot be empty");
                }else if(vendorConfirmPassword.length()<6){
                    System.out.println("Not a Valid Vendor Confirm Password");
                }else if (!Objects.equals(vendorPassword, vendorConfirmPassword)) {
                    System.out.println("Passwords do not match");
                }else {
                    break;
                }

            }
        }catch(Exception e){
            System.out.println("Please enter a valid details");
        }
        vendorId= vendorId+1;
        Vendor vendor = new Vendor(vendorId,vendorName, vendorEmail, vendorPassword, vendorConfirmPassword);
        System.out.println("Vendor ID: "+vendorId);
        vendors.put(vendorName,vendor);
        vendorsDetails.put(vendorEmail,vendorPassword);
        System.out.println(vendor.getName()+" is registered successfully as a Vendor");
    }
    public static void vendorLogin() {
        Scanner input = new Scanner(System.in);
        System.out.println("////////////////////=========================////////////////////");
        System.out.println("///////////////////====== Vendor Login ======////////////////////");
        System.out.println(" ");
        while (true) {
            System.out.print("Vendor Name: ");
            vendorName = input.nextLine();
            if (vendorName.trim().isEmpty()) {
                System.out.println("Name cannot be empty");
            } else if (vendorName.length() < 3) {
                System.out.println("Not a Valid Vendor Name");
            } else if (!vendors.containsKey(vendorName)) {
                System.out.println("User name not found");
            } else {
                break;
            }
        }
        Vendor vendor = vendors.get(vendorName);
        while (true) {
            System.out.print("Vendor Password: ");
            vendorPassword = input.nextLine();
            if (vendorPassword.trim().isEmpty()) {
                System.out.println("Password cannot be empty");
            } else if (vendorPassword.length() < 6) {
                System.out.println("Not a Valid Vendor Password");
            } else if (!vendor.getPassword().equals(vendorPassword)) {
                System.out.println("Passwords do not match");
                System.out.println("Password incorrect. Please try again");
            } else {
                System.out.println("Vendor login successful");
                break;
            }
        }

        TicketPool.addTicket(vendor);
    }


    @Override
    public void run() {

        try { Thread.sleep(1000000000);
        }catch (InterruptedException e)
        { Thread.currentThread().interrupt();}
    }
}

