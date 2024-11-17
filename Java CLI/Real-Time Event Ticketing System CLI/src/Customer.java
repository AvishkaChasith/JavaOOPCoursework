public class Customer implements Runnable{
    private int customerID;
    private String customerName;
    private String customerEmail;
    private String customerPassword;
    private String customerConfirmPassword;

    public Customer(int customerID,String customerName,String customerEmail, String customerPassword) {
        this.customerID = customerID;
        this.customerName = customerName;
        this.customerEmail = customerEmail;
        this.customerPassword = customerPassword;
        this.customerConfirmPassword = customerPassword;
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
    public String getCustomerConfirmPassword() {
        return customerConfirmPassword;
    }

    @Override
    public void run() {

    }

}
