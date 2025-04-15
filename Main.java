import java.time.LocalDate;
import java.util.Locale;
import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        ExpenseManager manager = new ExpenseManager();
        Scanner sc = new Scanner(System.in);
        String filename = "expenses.txt";
        manager.loadfromFile(filename);

        while (true){
            System.out.println(" Expense tracker ");
            System.out.println("1.Add Expense");
            System.out.println("2.View Expense");
            System.out.println("3.View Total Amount Spent");
            System.out.println("4.Filter By Category");
            System.out.println("5.Save to file");
            System.out.println("6.Exit");
            System.out.print("Enter your choice: ");

            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice){
                case 1:
                    System.out.println("Enter amount: ");
                    double amount = sc.nextDouble();
                    sc.nextLine();

                    System.out.print("Enter category: ");
                    String category = sc.nextLine();

                    System.out.print("Enter description: ");
                    String description = sc.nextLine();

                    LocalDate date = LocalDate.now();
                    Expense expense = new Expense(amount,category,date,description);
                    manager.addExpense(expense);
                    System.out.println("Expenses added!");
                case 2:
                    manager.viewExpense();
                    break;
                case 3:
                    double total = manager.getTotalSpent();
                    System.out.println("Total spent: "+total);
                    break;
                case 4:
                    System.out.println("Enter category to filter: ");
                    String filterCategory = sc.nextLine();
                    manager.filterByCategory(filterCategory);
                    break;
                case 5:
                    manager.saveToFile(filename);
                    System.out.println("Expenses saved to file");
                    break;
                case 6:
                    manager.saveToFile(filename);
                    System.out.println("GoodBye!");
                    sc.close();
                    return;
                default:
                    System.out.println("Invalid choice try again");
            }

        }
    }
}