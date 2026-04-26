// File 8 — BankMain.java

public class BankMain {

    // Concrete subclass of abstract Customer (Person 1 — Customer.java)
    static class RegularCustomer extends Customer {
        public RegularCustomer(String customerId, String name,
                               String email, String phoneNumber) {
            super(customerId, name, email, phoneNumber);
        }

        @Override
        public void getDetails() {
            System.out.println("Customer ID : " + customerId);
            System.out.println("Name        : " + name);
            System.out.println("Email       : " + email);
            System.out.println("Phone       : " + phoneNumber);
        }
    }

    public static void main(String[] args) {

        System.out.println("  Bank Management System — OOP Demo   ");
      

     
        // SECTION 1: Customer (Person 1 — Customer.java)
      
        System.out.println("\nCustomer Details");

        Customer cust1 = new RegularCustomer("C1", "Priya ",
                                              "priya@email.com", "9876543210");
        Customer cust2 = new RegularCustomer("C2", "Ronak",
                                              "ronak@email.com", "9123456780");

        System.out.println("\n-- Customer 1 --");
        cust1.getDetails();

        System.out.println("\n-- Customer 2 --");
        cust2.getDetails();

       
        // SECTION 2: BankAccount — SavingsAccount
        //            (Person 1 — BankAccount.java)
        //            (Person 2 — SavingsAccount.java)
        
        System.out.println("\n══ Savings Account Operations ════════════════════");

        SavingsAccount savings = new SavingsAccount(
                "SA-1001", cust1.name, 10000.00, 0.04);

        System.out.println("\n-- Account Info --");
        savings.displayAccountInfo();
        System.out.println("Account Type : " + savings.getAccountType());

        System.out.println("\n-- Deposit --");
        savings.deposit(5000.00);

        System.out.println("\n-- Withdraw --");
        savings.withdraw(3000.00);

        System.out.println("\n-- Apply Annual Interest (4%) --");
        savings.applyInterest();

        System.out.println("\n-- Final Balance --");
        savings.getBalance();

       
        // SECTION 3: BankAccount — CurrentAccount
        //            (Person 1 — BankAccount.java)
        //            (Person 2 — CurrentAccount.java)
       
        System.out.println("\n Current Account Operations");

        CurrentAccount current = new CurrentAccount(
                "CA-2001", cust2.name, 8000.00, 3000.00);

        System.out.println("\n-- Account Info --");
        current.displayAccountInfo();
        System.out.println("Account Type   : " + current.getAccountType());
        System.out.println("Overdraft Limit: Rs." + current.getOverdraftLimit());

        System.out.println("\n-- Deposit --");
        current.deposit(2000.00);

        System.out.println("\n-- Normal Withdrawal --");
        current.withdraw(4000.00);

        System.out.println("\n-- Overdraft Withdrawal --");
        current.withdraw(9000.00); // exceeds balance, uses overdraft

        System.out.println("\n-- Final Balance --");
        current.getBalance();

       
        // SECTION 4: Transaction Interface (Person 3 — Transaction.java)
        //            Demonstrated via anonymous class
      
        System.out.println("\n Transaction Interface Demo");

        Transaction txn = new Transaction() {
            @Override
            public void deposit() {
                System.out.println("  [Transaction] deposit() called → Rs.2000 deposited.");
                savings.deposit(2000);
            }

            @Override
            public void withdraw() {
                System.out.println("  [Transaction] withdraw() called → Rs.1000 withdrawn.");
                savings.withdraw(1000);
            }

            @Override
            public void transfer() {
                System.out.println("  [Transaction] transfer() called → Rs.500 transferred.");
                savings.withdraw(500);
                current.deposit(500);
                System.out.println("  Transfer complete: Rs.500 moved from Savings → Current.");
            }
        };

        txn.deposit();
        txn.withdraw();
        txn.transfer();

       
        // SECTION 5: Loan Interface (Person 3 — Loan.java)
        //            Demonstrated via anonymous class
       
        System.out.println("\n Loan Interface Demo ");

        Loan loan = new Loan() {
            private double loanAmount  = 50000.00;
            private double amountPaid  = 0.00;
            private boolean active     = false;

            @Override
            public void applyLoan() {
                active = true;
                System.out.println("  [Loan] Loan of Rs." + loanAmount
                        + " applied for " + cust1.name + ".");
                System.out.println("  Loan Status: ACTIVE");
            }

            @Override
            public void repayLoan() {
                double repayment = 20000.00;
                amountPaid += repayment;
                System.out.println("  [Loan] Repayment of Rs." + repayment + " made.");
                System.out.println("  Remaining  : Rs." + (loanAmount - amountPaid));
                if (amountPaid >= loanAmount) {
                    active = false;
                    System.out.println("  Loan fully repaid!");
                }
            }

            @Override
            public void getLoanStatus() {
                System.out.println("  [Loan Status]");
                System.out.println("  Total Loan : Rs." + loanAmount);
                System.out.println("  Paid So Far: Rs." + amountPaid);
                System.out.println("  Remaining  : Rs." + (loanAmount - amountPaid));
                System.out.println("  Active     : " + (active ? "YES" : "NO"));
            }
        };

        loan.applyLoan();
        loan.repayLoan();
        loan.getLoanStatus();

      
        // SECTION 6: Runtime Polymorphism — BankStaff
        //            (Person 4 — BankStaff.java)
      
        System.out.println("\n Staff Transactions — Runtime Polymorphism ");

        // BankStaff[] holds both Cashier and Manager --- polymorphism
        BankStaff[] staffMembers = {
            new Cashier("Anita Desai",  301, "C-1"),
            new Cashier("Vijay Kumar",  302, "C-3"),
            new Manager("Sneha Patil",  401, "Operations"),
            new Manager("Arjun Nair",   402, "Compliance")
        };

        double[] transactionAmounts = { 8000.00, 75000.00, 120000.00, 500000.00 };

        for (int i = 0; i < staffMembers.length; i++) {
            System.out.println();
            staffMembers[i].displayInfo();
            // Same method call → different behaviour based on actual object type
            staffMembers[i].processTransaction(transactionAmounts[i]);
        }

       
        // SECTION 7: Polymorphic BankAccount reference
        //            (shows upcasting — Person 1 + 2)
      
        System.out.println("\n Polymorphic BankAccount Reference ");

        // BankAccount reference holds different subclass objects
        BankAccount[] accounts = {
            new SavingsAccount("SA-3001", "Meera Joshi",  15000.00, 0.05),
            new CurrentAccount("CA-4001", "Suresh Gupta", 20000.00, 5000.00)
        };

        for (BankAccount acc : accounts) {
            System.out.println("\n-- " + acc.getAccountType() + " --");
            acc.displayAccountInfo();
            acc.deposit(3000.00);
            acc.withdraw(1500.00);
            acc.getBalance();
        }

            }
}
