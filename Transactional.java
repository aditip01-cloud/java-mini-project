// Interface (defines transaction operations)
public interface Transactional {

    void deposit(double amount);   // deposit money
    void withdraw(double amount);  // withdraw money
}