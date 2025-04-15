import java.io.*;
import java.util.ArrayList;

public class ExpenseManager {
    private ArrayList<Expense> expenses;

    public ExpenseManager(){
        expenses = new ArrayList<>();
    }
    public void addExpense(Expense expense){
        expenses.add(expense);
    }
    public void viewExpense(){
        for(Expense expense:expenses){
            System.out.println(expense);
        }
    }
    public double getTotalSpent(){
        double total =0;
        for(Expense expense:expenses){
            total+=expense.getamount();
        }
        return total;
    }
    public void filterByCategory(String category){
        for (Expense expense:expenses){
            if(expense.getcategory().equalsIgnoreCase(category)){
                System.out.println(category);
            }
        }
    }
    public void saveToFile(String filename){
        try(ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(filename))) {
            out.writeObject(expenses);
        }catch (IOException e){
            System.out.println("Error saving to file: "+e.getMessage());
        }
    }
    public void loadfromFile(String filename){
        try(ObjectInputStream in = new ObjectInputStream(new FileInputStream(filename))){
            expenses = (ArrayList<Expense>) in.readObject();
        }catch (IOException | ClassNotFoundException e){
            System.out.println("Error loading from file: "+e.getMessage());
        }
    }
}
