import java.util.ArrayList;
import java.util.Scanner;

public class BankMain {

    // Concrete Customer class
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

        Scanner sc = new Scanner(System.in);

        // ArrayLists
        ArrayList<Customer> customers = new ArrayList<>();
        ArrayList<BankStaff> staffList = new ArrayList<>();

        int choice;

        do {
            System.out.println("\n===== BANK MANAGEMENT SYSTEM =====");
            System.out.println("1. Add Customer");
            System.out.println("2. View Customers");
            System.out.println("3. Add Staff");
            System.out.println("4. View Staff");
            System.out.println("5. Savings Account Demo");
            System.out.println("6. Current Account Demo");
            System.out.println("0. Exit");
            System.out.print("Enter choice: ");
            choice = sc.nextInt();
            sc.nextLine(); // clear buffer

            switch (choice) {

                // ✅ ADD CUSTOMER
                case 1:
                    System.out.print("Enter Customer ID: ");
                    String id = sc.nextLine();

                    System.out.print("Enter Name: ");
                    String name = sc.nextLine();

                    System.out.print("Enter Email: ");
                    String email = sc.nextLine();

                    System.out.print("Enter Phone: ");
                    String phone = sc.nextLine();

                    Customer c = new RegularCustomer(id, name, email, phone);
                    customers.add(c);

                    System.out.println("✅ Customer added successfully!");
                    break;

                // ✅ VIEW CUSTOMERS
                case 2:
                    if (customers.isEmpty()) {
                        System.out.println("No customers found.");
                    } else {
                        for (Customer cust : customers) {
                            System.out.println("\n--- Customer ---");
                            cust.getDetails();
                        }
                    }
                    break;

                // ✅ ADD STAFF
                case 3:
                    System.out.print("Enter Staff Name: ");
                    String sName = sc.nextLine();

                    System.out.print("Enter Employee ID: ");
                    int empId = sc.nextInt();
                    sc.nextLine();

                    System.out.print("1. Cashier | 2. Manager: ");
                    int type = sc.nextInt();
                    sc.nextLine();

                    if (type == 1) {
                        System.out.print("Enter Counter Number: ");
                        String counter = sc.nextLine();
                        staffList.add(new Cashier(sName, empId, counter));
                    } else {
                        System.out.print("Enter Department: ");
                        String dept = sc.nextLine();
                        staffList.add(new Manager(sName, empId, dept));
                    }

                    System.out.println("✅ Staff added successfully!");
                    break;

                // ✅ VIEW STAFF
                case 4:
                    if (staffList.isEmpty()) {
                        System.out.println("No staff found.");
                    } else {
                        for (BankStaff staff : staffList) {
                            System.out.println("\n--- Staff ---");
                            staff.displayInfo();
                            staff.processTransaction(5000); // demo
                        }
                    }
                    break;

                // ✅ SAVINGS ACCOUNT DEMO
                case 5:
                    SavingsAccount savings = new SavingsAccount(
                            "SA-101", "Demo User", 10000, 0.04);

                    savings.deposit(2000);
                    savings.withdraw(1000);
                    savings.applyInterest();
                    savings.getBalance();
                    break;

                // ✅ CURRENT ACCOUNT DEMO
                case 6:
                    CurrentAccount current = new CurrentAccount(
                            "CA-201", "Demo User", 5000, 3000);

                    current.deposit(2000);
                    current.withdraw(7000); // overdraft
                    current.getBalance();
                    break;

                case 0:
                    System.out.println("Exiting... Thank you!");
                    break;

                default:
                    System.out.println("Invalid choice!");
            }

        } while (choice != 0);

        sc.close();
    }
}