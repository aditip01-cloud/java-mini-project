// Creating a Fixed deposit class
public class FixedDeposit {
    private double principal;
    private int durationMonths;
    private Client client;

    public FixedDeposit(double principal, int durationMonths, Client client) {
        this.principal = principal;
        this.durationMonths = durationMonths;
        this.client = client;
    }

    public double getInterestRate() // deciding rate according to age
    {
        int age = client.getAge();
        if (age >= 60) return 8.5;       // senior citizen rate
        else if (age >= 40) return 7.0;
        else return 6.0;                  // standard rate 
    }

    public double calculateInterest() // calculate interest according to rate
    {
        double rate = getInterestRate();
        return principal * rate / 100 * durationMonths / 12.0;
    }
}
