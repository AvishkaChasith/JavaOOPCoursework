import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class TicketPool{
    private static int lastTicketID;
    private static int vendorTicketsPerRelease;
    private static int vendorAddTicket;
    private static int removeTicketID;

    private static int customerBuyTicket;
    static Scanner input = new Scanner(System.in);
    private String vendorName;
    private  String customerName;

    private int ticketID;
    private Vendor vendor;
    private Customer customer;

    public TicketPool(int ticketID,Vendor vendor){
        this.ticketID=ticketID;
        this.vendor=vendor;
    }

    public TicketPool(int lastTicketID, Customer customer) {
        this.lastTicketID=lastTicketID;
        this.customer=customer;
    }
    public TicketPool(int lastTicketID) {
        this.lastTicketID=lastTicketID;
    }


    static List<Integer> tickets = Collections.synchronizedList(new ArrayList<>(5000));





    public static void addTicket(Vendor vendor){
        synchronized (tickets){
            System.out.println("💻☆*: .｡. o(≧▽≦)o .｡.:*☆💻 "+vendor.getVendorName()+" Profile 💻☆*: .｡. o(≧▽≦)o .｡.:*☆💻");
            System.out.print("Tickets amount to add: ");
            vendorAddTicket=input.nextInt();
            System.out.print("Tickets per release amount: ");
            vendorTicketsPerRelease=input.nextInt();
            int currentTicket=0;

            while(currentTicket < vendorAddTicket){
                for(int i = 0; i < vendorTicketsPerRelease;i++){
                    if (currentTicket==vendorAddTicket){
                        break;
                    }
                    lastTicketID++;
                    tickets.add(lastTicketID);
                    currentTicket++;
                }
            }
        }
    }

    public static void removeTicket(Customer customer){
        synchronized (tickets){
            System.out.println("💻☆*: .｡. o(≧▽≦)o .｡.:*☆💻"+customer.getCustomerName()+" 💻☆*: .｡. o(≧▽≦)o .｡.:*☆💻");
            System.out.print("Tickets amount to buy: ");
            customerBuyTicket= input.nextInt();
            removeTicketID=customerBuyTicket;
            for (int i = 0;i < customerBuyTicket;i++){
                removeTicketID--;
                tickets.remove(removeTicketID);
            }

        }
    }
    @Override
    public String toString(){
        return "ticketID: "+ticketID+",add by vendor: "+vendor.getVendorName()+"\n ";

    }
//    @Override
//    public String toString(){
//        return "ticketID: "+ticketID+", buy by customer:"+customer.getCustomerName()+"\n";
//    }
}
