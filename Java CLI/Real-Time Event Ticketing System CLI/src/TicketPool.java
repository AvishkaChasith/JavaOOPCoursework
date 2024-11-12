import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class TicketPool{
    private static int lastTicketID=UserConfiguration.userTotalTickets;
    private static int vendorTicketsPerRelease;
    static Scanner input = new Scanner(System.in);



    static List<TicketPool> tickets = Collections.synchronizedList(new ArrayList<>());

    public static void addTicket(Vendor vendor){
        synchronized (tickets){
            System.out.println("💻☆*: .｡. o(≧▽≦)o .｡.:*☆💻 "+vendor.getVendorName()+" Profile 💻☆*: .｡. o(≧▽≦)o .｡.:*☆💻");
            System.out.print("Tickets per release amount: ");
            vendorTicketsPerRelease=input.nextInt();
            for (int i = 0; i < vendorTicketsPerRelease; i++){
                lastTicketID++;
                tickets.add(lastTicketID,new TicketPool());
            }
            System.out.println(tickets);

        }



    }



}
