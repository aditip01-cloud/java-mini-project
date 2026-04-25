// CurrentAccount extends BankAccount (supports overdraft)

public class CurrentAccount extends BankAccount {

    private double overdraftLimit; // extra amount when the bank balance is insufficient

    // Constructor
    public CurrentAccount(String accountNumber, String accountHolder,
                          double initialBalance, double overdraftLimit) {
        super(accountNumber, accountHolder, initialBalance);
        this.overdraftLimit = overdraftLimit;
    }

    @Override
    public void deposit(double amount) {
        if (amount <= 0) {
            System.out.println("Deposit amount must be positive.");
            return;
        }
        balance += amount;
        System.out.println("Deposited Rs." + amount + " | New Balance: Rs." + balance);
    }

    @Override
    public void withdraw(double amount) {
        if (amount <= 0) {
            System.out.println("Withdrawal amount must be positive.");
            return;
        }
        // Allow withdrawal up to (balance + overdraftLimit)
        if (amount > balance + overdraftLimit) {
            System.out.println("Exceeds overdraft limit! Available: Rs." + (balance + overdraftLimit));
            return;
        }
        balance -= amount;
        System.out.println("Withdrawn Rs." + amount + " | Remaining Balance: Rs." + balance);
        if (balance < 0) {
            System.out.println("Warning: Account is in overdraft by Rs." + Math.abs(balance));
        }
    }

    @Override
    public String getAccountType() {
        return "Current Account";
    }

    public double getOverdraftLimit() {
        return overdraftLimit;
    }
}