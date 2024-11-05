import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.Objects;
import java.util.Scanner;

public class Vendor implements Runnable {
    private static String vendorName;
    private static String vendorEmail;
    private static String vendorPassword;
    private static String vendorConfirmPassword;

    private String name;
    private String email;
    private String password;
    private String confirmPassword;

    public Vendor(String name, String email, String password, String confirmPassword) {
        this.name = name;
        this.email = email;
        this.password = password;
        this.confirmPassword = confirmPassword;
    }
    public String getName() {
        return name;
    }
    public String getEmail() {
        return email;
    }
    public String getPassword() {
        return password;
    }
    public String getConfirmPassword() {
        return confirmPassword;
    }

    public Vendor(String name, String password){
        this.name = name;
        this.password = password;
    }


    public static HashMap<String,String> vendors = new HashMap<String,String>();

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
                }else if(vendors.containsKey(vendorEmail)){
                    System.out.println("Vendor already exists");
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

                }else if (vendors.containsValue(vendorPassword)){
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
        }catch(InputMismatchException e){
            System.out.println("Please enter a valid details");
        }
        vendors.put(vendorName,vendorPassword);
        System.out.println(vendors);
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
        while (true) {
            System.out.print("Vendor Password: ");
            vendorPassword = input.nextLine();
            if (vendorPassword.trim().isEmpty()) {
                System.out.println("Password cannot be empty");
            } else if (vendorPassword.length() < 6) {
                System.out.println("Not a Valid Vendor Password");
            } else if (!vendors.containsValue(vendorPassword)) {
                System.out.println("Passwords do not match");
                System.out.println("Password incorrect. Please try again");
            } else {
                System.out.println("Vendor login successful");
                break;
            }
        }
        Vendor vendor = new Vendor(vendorName, vendorPassword);
        System.out.println("////////////////////========================////////////////////");
        System.out.println("/////////////// " + vendor.getName() + " Profile ///////////////");


    }


    @Override
    public void run() {
        vendorRegister();
        vendorLogin();
        try { Thread.sleep(1000000000);
        }catch (InterruptedException e)
        { Thread.currentThread().interrupt();}
    }
}

