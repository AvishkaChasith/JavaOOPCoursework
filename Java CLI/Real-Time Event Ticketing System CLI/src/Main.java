import java.util.InputMismatchException;
import java.util.Scanner;

public class Main{
    public static int userOption;
    public static boolean userOptionValidity;

    public static void main(String[] args){
        //UserConfiguration.UserConfigurationMenu();

        while(true){
            applicationMenu();
            switch(userOption){
                case 1:
                    Vendor.venderRegister();
                    break;
                case 3:
                    Vendor.venderLogin();
                    break;
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
            System.out.println("");
            System.out.println("               1) Vendor Register: Enter 1"  );
            System.out.println("               2) Customer Register: Enter 2"  );
            System.out.println("               3) Vendor Login: Enter 3"  );
            System.out.println("               2) Customer Login: Enter 4"  );
            System.out.println("");
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
                }
                else {
                    System.out.println("Invalid option");
                    userOptionValidity=false;
                }
            }catch (InputMismatchException e){
                System.out.println("Please enter a valid option!");
            }
            System.out.println("////////////////======================/////////////////");
            System.out.println("");
        }






    }

}