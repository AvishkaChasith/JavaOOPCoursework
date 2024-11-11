import java.util.ArrayList;

public class TicketPool{
    private final int ticketId;
    private static String ticketPrice="Rs.200.00";

    public static int ticketID;

    public static ArrayList tickets=new ArrayList();

    public static void generateTicketId(){
        for (int i =1;i<=UserConfiguration.userTotalTickets;i++){
            ticketID=ticketID+1;
            tickets.add(new TicketPool(ticketID,ticketPrice));
        }
    }

    public TicketPool(int ticketId, String ticketPrice){
        this.ticketId = ticketId;
        TicketPool.ticketPrice = ticketPrice;
    }
    public int getTicketId(){
        return ticketId;
    }
    public String getTicketPrice(){
        return ticketPrice;
    }

    @Override
    public String toString(){
        return "Ticket ID: "+ticketId+" Ticket Price: "+ticketPrice+"\n";
    }
    public static void addTicket(Vendor vendor){

        System.out.println("adding new ticket"+vendor.getName());
    }

}
