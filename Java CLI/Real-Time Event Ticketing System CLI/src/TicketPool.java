import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class TicketPool{
    private static int lastTicketID=UserConfiguration.userTotalTickets;
    private static int vendorTicketsPerRelease;
    static Scanner input = new Scanner(System.in);

    private int ticketID;
    private Vendor vendor;
    public TicketPool(int ticketID,Vendor vendor){
        this.ticketID=ticketID;
        this.vendor=vendor;
    }


    static List<TicketPool> tickets = Collections.synchronizedList(new ArrayList<TicketPool>(5000));


    public static void addTicket(Vendor vendor){
        synchronized (tickets){
            System.out.println("💻☆*: .｡. o(≧▽≦)o .｡.:*☆💻 "+vendor.getVendorName()+" Profile 💻☆*: .｡. o(≧▽≦)o .｡.:*☆💻");
            System.out.print("Tickets per release amount: ");
            vendorTicketsPerRelease=input.nextInt();
            for (int i = 0; i < vendorTicketsPerRelease; i++){
                lastTicketID++;
                TicketPool addTicket = new TicketPool(lastTicketID,vendor);
                tickets.add(addTicket);
            }
        }
    }
    @Override
    public String toString(){
        return "ticketID: "+ticketID+",add by vendor: "+vendor.getVendorName()+"\n";
    }
}
