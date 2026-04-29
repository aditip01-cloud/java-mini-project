import java.util.*;

// SavingsAccount (inherits BankAccount + implements Loanable)
public class SavingsAccount extends BankAccount implements Loanable {

    private boolean hasLoan = false;
    private double loanAmount, totalPayable;
    private int years;

    public SavingsAccount(String accNo, String holder, double bal, double rate) {
        super(accNo, holder, bal);
    }

    // Deposit implementation
    @Override
    public void deposit(double amt) {
        balance += amt;
        System.out.println("Deposited Rs." + amt);
    }

    // Withdraw implementation
    @Override
    public void withdraw(double amt) {
        if (amt > balance)
            System.out.println("Insufficient balance!");
        else {
            balance -= amt;
            System.out.println("Withdrawn Rs." + amt);
        }
    }

    // Apply loan
    @Override
    public void applyLoan() {

        Scanner sc = new Scanner(System.in);

        // Eligibility check
        if (balance < 5000) {
            System.out.println("Not eligible for loan!");
            return;
        }

        System.out.print("Loan Amount: ");
        loanAmount = sc.nextDouble();

        System.out.print("Years: ");
        years = sc.nextInt();

        double rate = 0.1;

        // Simple interest calculation
        totalPayable = loanAmount * (1 + rate * years);

        hasLoan = true;

        System.out.println("Loan Approved! Total Payable: Rs." + totalPayable);
    }

    // Repay loan
    @Override
    public void repayLoan() {

        if (!hasLoan) {
            System.out.println("No active loan!");
            return;
        }

        if (balance >= totalPayable) {
            balance -= totalPayable;
            hasLoan = false;
            System.out.println("Loan repaid!");
        } else {
            System.out.println("Not enough balance!");
        }
    }

    // Loan status
    @Override
    public void getLoanStatus() {
        if (!hasLoan)
            System.out.println("No active loan.");
        else
            System.out.println("Loan: Rs." + loanAmount + " | Payable: Rs." + totalPayable);
    }
}