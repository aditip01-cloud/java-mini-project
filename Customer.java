public abstract class Customer {

    protected String customerId;
    protected String name;
    protected String email;
    protected String phoneNumber;

    public Customer(String customerId, String name, String email, String phoneNumber) {
        this.customerId = customerId;
        this.name = name;
        this.email = email;
        this.phoneNumber = phoneNumber;
    }

    public abstract void getDetails();

    public void displayCustomerInfo() {
        System.out.println("Customer ID : " + customerId);
        System.out.println("Name        : " + name);
        System.out.println("Email       : " + email);
        System.out.println("Phone       : " + phoneNumber);
    }
}