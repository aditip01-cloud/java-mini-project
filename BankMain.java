import java.util.*;

// Main class (Only handles menu)
public class BankMain {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        //creating object of BankService class 
        BankService service = new BankService();

        int choice;
        // Menu driven Program 
        do {
            System.out.println("\n===== BANK MANAGEMENT SYSTEM =====");
            System.out.println("1. Create Account");
            System.out.println("2. Perform Transaction");
            System.out.println("3. View Accounts");
            System.out.println("4. Loan Services");
            System.out.println("5. Create a Fixed Deposit");
            System.out.println("6. Exit");
            System.out.print("Enter choice: ");

            choice = sc.nextInt();

            switch (choice) {
                case 1:
                    service.createAccount(); // create new account
                    break;

                case 2:
                    service.performTransaction(); // deposit/withdraw
                    break;

                case 3:
                    service.viewAccounts(); // display all accounts
                    break;

                case 4:
                    service.loanMenu(); // loan related operations
                    break;

                case 5:
                    service.fd(); // fixed deposit creation
                    break;

                case 6:
                    System.out.println("Thank you!"); // exit case
                    break;

                default:
                    System.out.println("Invalid choice!");
            }

        } while (choice != 6);
    }
}