public class Client {
    private String name;
    private LocalDate dateOfBirth;

    public Client(String name, LocalDate dateOfBirth) {
        this.name = name;
        this.dateOfBirth = dateOfBirth;
    }

    public int getAge() {
        return Period.between(dateOfBirth, LocalDate.now()).getYears(); // calculating age from date of birth
    }

   
}
