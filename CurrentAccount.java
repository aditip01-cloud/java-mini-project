// CurrentAccount → supports overdraft
public class CurrentAccount extends BankAccount {

    private double overdraftLimit;

    public CurrentAccount(String accNo, String holder, double bal, double limit) {
        super(accNo, holder, bal);
        this.overdraftLimit = limit;
    }

    // Deposit method
    @Override
    public void deposit(double amt) {
        balance += amt;
        System.out.println("Deposited Rs." + amt);
    }

    // Withdraw with overdraft logic
    @Override
    public void withdraw(double amt) {

        // Allow withdrawal beyond balance within limit
        if (amt > balance + overdraftLimit) {
            System.out.println("Overdraft exceeded!");
        } else {
            balance -= amt;
            System.out.println("Withdrawn Rs." + amt);
        }
    }
}