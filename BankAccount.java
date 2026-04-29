// Abstract class (common structure for all accounts (Abstraction))
public abstract class BankAccount implements Transactional {

    protected String accountNumber;
    protected String accountHolder;
    protected double balance;

    // Constructor
    public BankAccount(String accNo, String holder, double balance) {
        this.accountNumber = accNo;
        this.accountHolder = holder;
        this.balance = balance;
    }

    // Common method for all accounts
    public void displayAccountInfo() {
        System.out.println("Account No: " + accountNumber);
        System.out.println("Name: " + accountHolder);
        System.out.println("Balance: Rs." + balance);
    }
}