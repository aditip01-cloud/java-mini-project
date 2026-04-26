// File 7 — BankStaff.java
// Person 4: Polymorphism
// Cashier and Manager both override processTransaction()

public abstract class BankStaff {
    protected String name;
    protected int employeeId;

    public BankStaff(String name, int employeeId) {
        this.name = name;
        this.employeeId = employeeId;
    }

    // Overridden by Cashier and Manager — runtime polymorphism
    public void processTransaction(double amount) {
        System.out.println(name + " is processing a transaction of Rs." + amount);
    }

    public void displayInfo() {
        System.out.println("Staff Name : " + name);
        System.out.println("Employee ID: " + employeeId);
    }
}

class Cashier extends BankStaff {
    private String counterNumber;

    public Cashier(String name, int employeeId, String counterNumber) {
        super(name, employeeId);
        this.counterNumber = counterNumber;
    }

    @Override
    public void processTransaction(double amount) {
        System.out.println("  [Cashier] " + name + " at Counter " + counterNumber
                + " → Processing cash transaction of Rs." + amount);
        if (amount > 50000) {
            System.out.println("  ⚠  High-value cash transaction — flagged for review.");
        }
    }
}

class Manager extends BankStaff {
    private String department;

    public Manager(String name, int employeeId, String department) {
        super(name, employeeId);
        this.department = department;
    }

    @Override
    public void processTransaction(double amount) {
        System.out.println("  [Manager] " + name + " (" + department + " Dept)"
                + " → Authorizing transaction of Rs." + amount);
        System.out.println("  ✔  Manager approval granted.");
    }
}