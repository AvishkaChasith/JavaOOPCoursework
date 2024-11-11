public class Customer implements Runnable{
    private int customerID;
    private String customerName;
    private String customerEmail;
    private String customerPassword;

    public Customer(int customerID,String customerName,String customerEmail, String customerPassword) {
        this.customerID = customerID;
        this.customerName = customerName;
        this.customerEmail = customerEmail;
        this.customerPassword = customerPassword;
    }

    public int getCustomerID() {
        return customerID;
    }
    public String getCustomerName() {
        return customerName;
    }
    public String getCustomerEmail() {
        return customerEmail;
    }
    public String getCustomerPassword() {
        return customerPassword;
    }

    @Override
    public void run() {

    }

}
