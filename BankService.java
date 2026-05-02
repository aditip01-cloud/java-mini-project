import java.util.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

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

        System.out.println("\nAccount Created!");
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

    public void fd()
    {
        

        System.out.println("=== Fixed Deposit Registration ===");

        // Name
        System.out.print("Enter client name: ");
        String name = sc.nextLine();

        //age 
        System.out.println("Enter age");
        int age = sc.nextInt();

        // Principal amount with validation
        double principal = 0;
        while (principal <= 0) {
            System.out.print("Enter principal amount (₹): ");
            try {
                principal = Double.parseDouble(sc.nextLine());
                if (principal <= 0) System.out.println("  Amount must be greater than 0.");
            } catch (NumberFormatException e) {
                System.out.println("  Please enter a valid number.");
            }
        }

        // Duration with validation
        int duration = 0;
        while (duration <= 0) {
            System.out.print("Enter duration (in months): ");
            try {
                duration = Integer.parseInt(sc.nextLine());
                if (duration <= 0) System.out.println("  Duration must be at least 1 month.");
            } catch (NumberFormatException e) {
                System.out.println("  Please enter a whole number.");
            }
        }

        // Create objects
        //Client client = new Client(name,  age);
        FixedDeposit fd = new FixedDeposit(principal, duration, age);

        // Display summary
        System.out.println("\n=== Fixed Deposit Summary ===");
        System.out.println("Client Name   : " + name);
        System.out.println("Age           : " + age + " years");
        System.out.println("Principal     : ₹" + principal);
        System.out.println("Duration      : " + duration + " months");
        System.out.println("Interest Rate : " + fd.getInterestRate() + "%");
        System.out.printf("Interest Earned: ₹%.2f%n", fd.calculateInterest());
        System.out.printf("Maturity Amount: ₹%.2f%n", principal + fd.calculateInterest());


        
    }
}
    
    
