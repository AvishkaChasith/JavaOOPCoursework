import java.util.HashMap;
import java.util.Objects;
import java.util.Scanner;

public class Vendor implements Runnable {
    private static String vName;
    private static String vEmail;
    private static String vPassword;
    private static String vConfirmPassword;
    private static int vId;
    public static boolean vendorOptionValidate;

    private  int vendorID;
    private  String vendorName;
    private  String vendorEmail;
    private  String vendorPassword;
    private  String vendorConfirmPassword;
    private int VendorTicketPerRelease;
    private int vendorReleaseInterval;

    static Scanner input = new Scanner(System.in);
    public Vendor(int vendorID,String vendorName, String vendorEmail, String vendorPassword, String vendorConfirmPassword) {
        this.vendorID = vendorID;
        this.vendorName = vendorName;
        this.vendorEmail = vendorEmail;
        this.vendorPassword = vendorPassword;
        this.vendorConfirmPassword = vendorConfirmPassword;
    }


    public int getVendorID() {
        return vendorID;
    }
    public String getVendorName() {
        return vendorName;
    }
    public String getVendorPassword() {
        return vendorPassword;
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
                vName = input.nextLine();
                if(vName.trim().isEmpty()){
                    System.out.println("Name cannot be empty");
                } else if (!vName.matches("[a-zA-Z\\s]+")) {
                    System.out.println("Name contains a letter");
                }else if(vName.length()<3){
                    System.out.println("Not a Valid Vendor Name");
                }else if(vendors.containsKey(vName)){
                    System.out.println("Vendor Already Exists");
                    System.out.println("Use another Vendor Name");
                }else{
                    break;
                }
            }
            while(true){
                System.out.print("Email: ");
                vEmail = input.nextLine();
                if(vEmail.trim().isEmpty()){
                    System.out.println("Email cannot be empty");
                }else if(vEmail.length()<13){
                    System.out.println("Not a Valid Vendor Email");
                }else if(vendorsDetails.containsKey(vEmail)){
                    System.out.println("Gmail has already an account. Please use another Vendor Email for creating a new one.");
                }else {
                    break;
                }
            }
            while(true){
                System.out.print("Password: ");
                vPassword = input.nextLine();
                if(vPassword.trim().isEmpty()){
                    System.out.println("Password cannot be empty");
                }
                else if(vPassword.length()<6) {
                    System.out.println("Not a Valid Vendor Password");

                }else if (vendorsDetails.containsValue(vPassword)){
                   System.out.println("Use another password");
                }else {
                    break;
                }
            }
            while(true){
                System.out.print("Confirm Password: ");
                vConfirmPassword = input.nextLine();

                if(vConfirmPassword.trim().isEmpty()){
                    System.out.println("Confirm Password cannot be empty");
                }else if(vConfirmPassword.length()<6){
                    System.out.println("Not a Valid Vendor Confirm Password");
                }else if (!Objects.equals(vPassword, vConfirmPassword)) {
                    System.out.println("Passwords do not match");
                }else {
                    break;
                }

            }
        }catch(Exception e){
            System.out.println("Please enter a valid details");
        }
        vId= vId+1;
        Vendor vendor = new Vendor(vId,vName, vEmail, vPassword, vConfirmPassword);
        System.out.println("Vendor ID: "+vId);
        vendors.put(vName,vendor);
        vendorsDetails.put(vEmail,vPassword);
        System.out.println(vendor.getVendorName()+" is registered successfully as a Vendor");
    }

    public static Vendor vendorLogin() {
        Scanner input = new Scanner(System.in);
        System.out.println("////////////////////=========================////////////////////");
        System.out.println("///////////////////====== Vendor Login ======////////////////////");
        System.out.println(" ");
        while (true) {
            System.out.print("Vendor Name: ");
            vName = input.nextLine();
            if (vName.trim().isEmpty()) {
                System.out.println("Name cannot be empty");
            } else if (vName.length() < 3) {
                System.out.println("Not a Valid Vendor Name");
            } else if (!vendors.containsKey(vName)) {
                System.out.println("User name not found");
            } else {
                break;
            }
        }
        Vendor vendor = vendors.get(vName);
        while (true) {
            System.out.print("Vendor Password: ");
            vPassword = input.nextLine();
            if (vPassword.trim().isEmpty()) {
                System.out.println("Password cannot be empty");
            } else if (vPassword.length() < 6) {
                System.out.println("Not a Valid Vendor Password");
            } else if (!vendor.getVendorPassword().equals(vPassword)) {
                System.out.println("Passwords do not match");
                System.out.println("Password incorrect. Please try again");
            } else {
                System.out.println("Vendor login successful");
                break;
            }
        }
        Vendor.setupVendorConfiguration(vendor);

        return vendor;
    }

    public static void setupVendorConfiguration(Vendor vendor) {
        vendorOptionValidate=false;
        while(!vendorOptionValidate){
            System.out.println("Configuration Menu for "+vendor.getVendorName());
            System.out.println("1.Add tickets to the Ticket Pool: ");
            System.out.println("2.Show all tickets: ");
            System.out.println("3.Your Ticket History: ");
            System.out.println("4.Logout: ");
            System.out.println("Choose your option: ");
            int vendorOption = input.nextInt();
            if(vendorOption == 1){
                TicketPool.addTicket(vendor);
            } else if (vendorOption==2) {
                System.out.println(TicketPool.tickets);
            } else if (vendorOption==4) {
                vendorOptionValidate = true;
                Main.controlMenu();
                break;
            }
        }
    }



    @Override
    public void run() {
            setupVendorConfiguration(vendorLogin());
        try { Thread.sleep(1000000000);
        }catch (InterruptedException e)
        { Thread.currentThread().interrupt();}
    }
}

