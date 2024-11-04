import java.util.InputMismatchException;
import java.util.Scanner;

public class UserConfiguration {

    private int totalTickets;
    private int ticketReleaseRate;
    private int customerRetrievalRate;
    private int maxTicketCapacity;
    private static boolean validInput;

    public static int userTotalTickets;
    public static int userTicketReleaseRate;
    public static int userCustomerRetrievalRate;
    public static int userMaxTicketCapacity;


    UserConfiguration(int totalTickets, int ticketReleaseRate, int customerRetrievalRate, int maxTicketCapacity) {
        this.totalTickets = totalTickets;
        this.ticketReleaseRate = ticketReleaseRate;
        this.customerRetrievalRate = customerRetrievalRate;
        this.maxTicketCapacity = maxTicketCapacity;
        validInput = true;
    }
    public int getTotalTickets() {
        return totalTickets;
    }
    public int getTicketReleaseRate() {
        return ticketReleaseRate;
    }
    public int getCustomerRetrievalRate() {
        return customerRetrievalRate;
    }
    public int getMaxTicketCapacity() {
        return maxTicketCapacity;
    }



    public static void UserConfigurationMenu(){
        Scanner input = new Scanner(System.in);
        validInput=false;
        while (!validInput){
            try{
                System.out.println("////////////////======================/////////////////");
                System.out.println("=============== Configuration Menu ====================");
                System.out.print("Enter Total Tickets: ");
                userTotalTickets=input.nextInt();
                validInput=true;
            }catch (InputMismatchException e) {
                System.out.println("Please enter a valid number for Total Tickets: .");
                input.nextLine();
                validInput = false;
            }
        }
        validInput=false;
        while(!validInput) {
            try {
                System.out.print("Enter Ticket Release Rate: ");
                userTicketReleaseRate = input.nextInt();
                validInput=true;
            } catch (InputMismatchException e) {
                System.out.println("Please enter a valid number for Ticket Release Rate: .");
                input.nextLine();
                validInput = false;
            }
        }
        validInput=false;
        while (!validInput) {
            try {
                System.out.print("Enter Customer Retrieval Rate: ");
                userCustomerRetrievalRate = input.nextInt();
                validInput=true;
            } catch (InputMismatchException e) {
                System.out.println("Please enter a valid number for Customer Retrieval Rate: .");
                input.nextLine();
                validInput = false;
            }
        }
        validInput=false;
        while (!validInput) {
            try {
                System.out.print("Enter Max Ticket Capacity: ");
                int maxTicketCapacity = input.nextInt();
                if(userMaxTicketCapacity< userTotalTickets) {
                    System.out.println("Wrong value for Max Ticket Capacity.Total Tickets Value is more than Max Ticket Capacity Value.");
                    validInput = false;
                }else
                    validInput=true;
            } catch (InputMismatchException e) {
                    System.out.println("Please enter a valid number for Max Ticket Capacity: .");
                    input.nextLine();
                    validInput = false;
            }
        }
        UserConfiguration user = new UserConfiguration(userTotalTickets,userTicketReleaseRate,userCustomerRetrievalRate,userMaxTicketCapacity);
        System.out.println("////////////////======================/////////////////");
        System.out.println("=============== Configuration Details =================");
        System.out.println("Total Tickets: "+user.getTotalTickets());
        System.out.println("Ticket Release Rate: "+user.getTicketReleaseRate());
        System.out.println("Customer Retrieval Rate: "+user.getCustomerRetrievalRate());
        System.out.println("Max Ticket Capacity: "+user.getMaxTicketCapacity());
    }
}
