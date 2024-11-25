import java.util.InputMismatchException;
import java.util.Scanner;

public class Main{
    public static int userOption;
    public static boolean userOptionValidity;

    public static void main(String[] args){
        UserConfiguration.userConfigurationMenu();

        while(true){
            try {
                applicationMenu();
                switch (userOption) {
                    case 1:
                        Vendor.vendorRegister();
                        break;
                    case 2:
                        Customer.customerRegister();
                        break;
                    case 3:
                        Vendor.setupVendorConfiguration(Vendor.vendorLogin());
                        break;
                    case 4:
                        Customer.setupCustomerConfiguration(Customer.customerLogin());
                        break;
                    case 5:
                        System.out.println(TicketPool.tickets);
                    case 6:
                        System.out.println("Exit: ");

                }
            }catch (InputMismatchException e){
                System.out.println("Please enter a valid option!");
            }
        }
    }
    public static void applicationMenu(){
        userOptionValidity = false;
        while (!userOptionValidity){
            Scanner input = new Scanner(System.in);
            System.out.println();
            System.out.println();
            System.out.println("////////////////======================/////////////////");
            System.out.println("///////// Real-Time Ticket Management System //////////");
            System.out.println(" ");
            System.out.println("               1) Vendor Register: Enter 1"  );
            System.out.println("               2) Customer Register: Enter 2"  );
            System.out.println("               3) Vendor Login: Enter 3"  );
            System.out.println("               4) Customer Login: Enter 4"  );
            System.out.println("               5) Show Ticket Status: Enter 5"  );
            System.out.println("               6) Exit: " );
            System.out.println(" ");
            System.out.print("Enter your option: ");
            try{
                userOption = input.nextInt();
                if(userOption==1){
                    userOptionValidity = true;
                }
                else if(userOption==2){
                    userOptionValidity = true;
                }
                else if(userOption==3){
                    userOptionValidity = true;
                }
                else if(userOption==4){
                    userOptionValidity = true;
                } else if (userOption==5) {
                    userOptionValidity = true;
                } else if (userOption==6) {
                    userOptionValidity = true;
                }else{
                    System.out.println("Invalid option");
                    userOptionValidity=false;
                }
            }catch (InputMismatchException e){
                System.out.println("Please enter a valid option!");
            }
            System.out.println(" ");
        }






    }

    public static void controlMenu(){
        while(true){
            try {
                applicationMenu();
                switch (userOption) {
                    case 1:
                        Vendor.vendorRegister();
                        break;
                    case 2:
                        Customer.customerRegister();
                        break;
                    case 3:
                        Vendor.setupVendorConfiguration(Vendor.vendorLogin());
                        break;
                    case 4:
                        Customer.setupCustomerConfiguration(Customer.customerLogin());
                        break;
                    case 5:
                        System.out.println("Exit: ");

                }
            }catch (InputMismatchException e) {
                System.out.println("Please enter a valid option!");
            }
        }

    }



}