import java.io.*;
import java.time.LocalDate;
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

    public void deleteExpense(int index){
        if(index>0 && index<=expenses.size()){
            expenses.remove(index);
            System.out.println("Expense deleted");
        }
        else{
            System.out.println("Invalid index number");
        }
    }
    public void updateExpenses(int index,double amount,String category,String description){
        if(index>0 && index<=expenses.size()){
            Expense old = expenses.get(index);
            expenses.set(index,new Expense(amount,category,old.getdate(),description));
            System.out.println("Expense updated");
        }
        else{
            System.out.println("Invalid index number");
        }
    }
    public void filterByDate(LocalDate start,LocalDate end){
        for(Expense expense:expenses){
            if((expense.getdate().isEqual(start) || expense.getdate().isAfter(start))
               && (expense.getdate().isEqual(end)|| expense.getdate().isBefore(end))){
                System.out.println(expense);
            }
        }
    }
    public void viewExpenseWithIndex(){
        if(expenses.isEmpty()){
            System.out.println("No expenses found.");
            return;
        }
        for (int i=1;i<expenses.size();i++){
            System.out.println(i+". "+expenses.get(i));
        }
    }
}
