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

    private Vendor vendor;
    private Customer customer;
    private int ticketID;

    public TicketPool(int ticketID,Vendor vendor){
        this.ticketID = ticketID;
        this.vendor=vendor;
    }
    public TicketPool(int ticketID,Customer customer){
        this.ticketID = ticketID;
        this.customer = customer;
    }

    static List<TicketPool> tickets = Collections.synchronizedList(new ArrayList<TicketPool>(5000));

    public static synchronized void addTicket(Vendor vendor){
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
                    }else{
                        lastTicketID++;
                        TicketPool addTickets = new TicketPool(lastTicketID,vendor);
                        tickets.add(addTickets);
                        currentTicket++;
                    }
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
                TicketPool removeTickets = new TicketPool(removeTicketID, customer);
                tickets.remove(removeTickets);
            }

        }
    }
    @Override
    public String toString(){
        if (customer==null){
            return "Ticket ID - "+ticketID+" , add by vendor - "+vendor.getVendorName()+"\n";
        }else {
            return "Ticket ID - "+ticketID+" , bought by customer - "+customer.getCustomerName()+"\n";
        }

    }

}
