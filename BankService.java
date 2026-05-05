import java.util.*;

public class BankService {

    private Scanner sc = new Scanner(System.in);
    private ArrayList<BankAccount> accounts = new ArrayList<>();

    public void createAccount() {

        sc.nextLine(); // clear buffer

        System.out.print("Enter Account Number: ");
        String accNo = sc.nextLine();

        System.out.print("Enter Name: ");
        String name = sc.nextLine();

        System.out.print("Initial Balance: ");
        double balance = sc.nextDouble();

        System.out.println("1. Savings  2. Current");
        int type = sc.nextInt();

        if (type == 1) {
            accounts.add(new SavingsAccount(accNo, name, balance, 0.05));
        } else {
            accounts.add(new CurrentAccount(accNo, name, balance, 2000));
        }

        System.out.println("Account Created!");
    }

    public void performTransaction() {

        System.out.print("Enter Account Number: ");
        String accNo = sc.next();

        BankAccount acc = findAccount(accNo);

        if (acc == null) {
            System.out.println("Account not found!");
            return;
        }

        System.out.println("1. Deposit  2. Withdraw");
        int ch = sc.nextInt();

        System.out.print("Enter amount: ");
        double amt = sc.nextDouble();

        if (ch == 1)
            acc.deposit(amt);
        else
            acc.withdraw(amt);
    }

    public void viewAccounts() {
        for (BankAccount acc : accounts) {
            acc.displayAccountInfo();
            System.out.println("----------------------");
        }
    }

    public void loanMenu() {

        System.out.print("Enter Account Number: ");
        String accNo = sc.next();

        BankAccount acc = findAccount(accNo);

        if (acc == null) {
            System.out.println("Account not found!");
            return;
        }

        if (!(acc instanceof Loanable)) {
            System.out.println("Loan not supported!");
            return;
        }

        Loanable loanAcc = (Loanable) acc;

        System.out.println("1. Apply Loan");
        System.out.println("2. Repay Loan");
        System.out.println("3. Loan Status");

        int ch = sc.nextInt();

        switch (ch) {
            case 1:
                loanAcc.applyLoan();
                break;
            case 2:
                loanAcc.repayLoan();
                break;
            case 3:
                loanAcc.getLoanStatus();
                break;
            default:
                System.out.println("Invalid choice");
        }
    }

    private BankAccount findAccount(String accNo) {
        for (BankAccount acc : accounts) {
            if (acc.accountNumber.equals(accNo)) {
                return acc;
            }
        }
        return null;
    }
    

   public void fd() {

    System.out.println("=== Fixed Deposit ===");

    System.out.print("Enter name: ");
    sc.next();
    String name = sc.nextLine();

    System.out.print("Enter age: ");
    int age = sc.nextInt();

    double principal;
    System.out.print("Enter amount: ");
    principal = sc.nextDouble();

    while (principal <= 0) {
        System.out.println("Enter valid amount:");
        principal = sc.nextDouble();
    }

    int duration;
    System.out.print("Enter duration (months): ");
    duration = sc.nextInt();

    while (duration <= 0) {
        System.out.println("Enter valid duration:");
        duration = sc.nextInt();
    }

    FixedDeposit fd = new FixedDeposit(principal, duration, age);

    System.out.println("Interest Rate: " + fd.getInterestRate());
    System.out.println("Interest: " + fd.calculateInterest());
    System.out.println("Total: " + (principal + fd.calculateInterest()));
}
}