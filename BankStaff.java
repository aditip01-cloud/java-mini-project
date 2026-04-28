public abstract class BankStaff {
    protected String name;
    protected int employeeId;

    public BankStaff(String name, int employeeId) {
        this.name = name;
        this.employeeId = employeeId;
    }

    public void processTransaction(double amount) {
        System.out.println(name + " is processing a transaction of Rs." + amount);
    }

    public void displayInfo() {
        System.out.println("Staff Name : " + name);
        System.out.println("Employee ID: " + employeeId);
    }
}

// ✅ REMOVE "public" from these (IMPORTANT)
class Cashier extends BankStaff {
    private String counterNumber;

    public Cashier(String name, int employeeId, String counterNumber) {
        super(name, employeeId);
        this.counterNumber = counterNumber;
    }

    @Override
    public void processTransaction(double amount) {
        System.out.println("[Cashier] " + name + " at Counter " + counterNumber +
                " → Processing Rs." + amount);
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
        System.out.println("[Manager] " + name + " (" + department +
                ") → Approving Rs." + amount);
    }
}