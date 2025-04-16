import java.time.LocalDate;
import java.io.Serializable;
public class Expense implements Serializable {
    private static final long serialVersionUID = 1L;
    private double amount;
    private String category;
    private LocalDate date;
    private String description;

    public Expense(double amount, String category, LocalDate date,
                   String description) {
        this.amount = amount;
        this.category = category;
        this.date = date;
        this.description = description;
    }

    public double getamount() {
        return amount;
    }

    public String getcategory() {
        return category;

    }

    public LocalDate getdate() {
        return date;
    }

    public String getdescription() {
        return description;
    }

    @Override
    public String toString() {
        return "Expense {"+
                "amount: "+amount+
                ", date: "+date+
                ", description: "+description+ '\''+
                '}';

    }
}
