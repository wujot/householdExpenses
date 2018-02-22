package data;

import java.util.ArrayList;
import java.util.List;

public class AppDatabase {
    private List<Expense> expenses;
    private int expensesNumber;

    public AppDatabase() {
    expenses = new ArrayList<>();
    }

    public int getExpensesNumber() {
    return expensesNumber;
    }

    public List<Expense> getExpenses() {
        return expenses;
    }

    public void addRecord(Expense expense) {
        expenses.add(expense);
        expensesNumber++;
    }

    public void printExpenses() {
        if (expensesNumber == 0) {
            System.out.println("There is no record in database.");
        }
            for (int i = 0; i < expensesNumber; i++) {
                System.out.println(expenses.get(i).toString());
            }
    }
}
