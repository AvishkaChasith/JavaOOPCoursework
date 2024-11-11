import java.util.HashMap;
import java.util.Objects;
import java.util.Scanner;

public class Vendor extends UserConfiguration implements Runnable {
    private static String vendorName;
    private static String vendorEmail;
    private static String vendorPassword;
    private static String vendorConfirmPassword;
    private static int vendorAddTicket;
    
    private String name;
    private String email;
    private String password;

    public Vendor(String name, String email, String password, String confirmPassword) {
        this.name = name;
        this.email = email;
        this.password = password;
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
        Vendor vendor = new Vendor(vendorName, vendorEmail, vendorPassword, vendorConfirmPassword);
        vendors.put(vendorName,vendor);
        vendorsDetails.put(vendorEmail,vendorPassword);
        System.out.println(vendor.getName()+" is registered successfully as a Vendor");
    }
    public static Vendor vendorLogin() {
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
        return vendor;

    }
    public static void addTicket(Vendor vendor) {
        System.out.println("/// TICKET ADDING ///");
        System.out.println("Now System has Total Tickets: "+UserConfiguration.userTotalTickets);
        while (true){
            Scanner input = new Scanner(System.in);
            System.out.println("Maximum Ticket Amount: "+UserConfiguration.userMaxTicketCapacity);
            System.out.print(vendor.getName()+" Tickets amount that you want to add to the Ticket Pool:  ");
            vendorAddTicket = input.nextInt();
            if (UserConfiguration.userMaxTicketCapacity<vendorAddTicket+UserConfiguration.userTotalTickets) {
                System.out.println("Maximum Ticket Capacity exceeded");
                System.out.println("Please try again");
            } else if (vendorAddTicket + UserConfiguration.userTotalTickets == UserConfiguration.userMaxTicketCapacity) {
                System.out.println("Add Tickets Level Reached");
                vendorAddTicket+=vendorAddTicket;
                UserConfiguration.userTotalTickets=vendorAddTicket;
                break;
            } else {
                vendorAddTicket+=vendorAddTicket;
                UserConfiguration.userTotalTickets = vendorAddTicket;
                System.out.println("Complete");
                break;
            }
        }

    }

    @Override
    public void run() {
        addTicket(vendorLogin());
        try { Thread.sleep(1000000000);
        }catch (InterruptedException e)
        { Thread.currentThread().interrupt();}
    }
}

