public class CurrentAccount extends BankAccount {

    private double overdraftLimit;

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
        if (amount > balance + overdraftLimit) {
            System.out.println("Exceeds overdraft limit!");
            return;
        }
        balance -= amount;
        System.out.println("Withdrawn Rs." + amount + " | Remaining Balance: Rs." + balance);
    }

    @Override
    public String getAccountType() {
        return "Current Account";
    }

    // ✅ MUST BE INSIDE CLASS
    @Override
    public void getBalance() {
        System.out.println("Current Balance: Rs." + balance);
    }
}