public class SavingsAccount extends BankAccount {

    private double interestRate;

    public SavingsAccount(String accountNumber, String accountHolder,
                          double initialBalance, double interestRate) {
        super(accountNumber, accountHolder, initialBalance);
        this.interestRate = interestRate;
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
        if (amount > balance) {
            System.out.println("Insufficient funds! Balance: Rs." + balance);
            return;
        }
        balance -= amount;
        System.out.println("Withdrawn Rs." + amount + " | Remaining Balance: Rs." + balance);
    }

    @Override
    public String getAccountType() {
        return "Savings Account";
    }

    // ✅ MUST BE INSIDE CLASS
    @Override
    public void getBalance() {
        System.out.println("Current Balance: Rs." + balance);
    }

    public void applyInterest() {
        double interest = balance * interestRate;
        balance += interest;
        System.out.println("Interest of Rs." + interest + " applied. New Balance: Rs." + balance);
    }
}