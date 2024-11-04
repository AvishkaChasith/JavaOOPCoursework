import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.Objects;
import java.util.Scanner;

public class Vendor {
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

    public static HashMap<String,String> vendors = new HashMap<String,String>();

    public static void venderRegister(){
        try{
            Scanner input = new Scanner(System.in);
            System.out.println("////////////////======================/////////////////");
            System.out.println("//////////////// Vendor Registration  /////////////////");
            System.out.println("");
            while (true){
                System.out.print("Name: ");
                vendorName = input.nextLine();
                if(vendorName.trim().isEmpty()){
                    System.out.println("Name cannot be empty");
                } else if (!vendorName.matches("[a-zA-Z\\s]+")) {
                    System.out.println("Name contains a letter");
                }else if(vendorName.length()<3){
                    System.out.println("Not a Valid Vendor Name");
                }else if(vendors.containsValue(vendorName)){
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

        }
        Vendor vendor = new Vendor(vendorName,vendorEmail,vendorPassword,vendorConfirmPassword);
        vendors.put(vendorName,vendorPassword);
        System.out.println(vendors);
    }
    public static void venderLogin(){
        Scanner input = new Scanner(System.in);
        System.out.println("////////////////////=========================////////////////////");
        System.out.println("///////////////////====== Vendor Login ======////////////////////");
        System.out.println("");


    }
}
clear