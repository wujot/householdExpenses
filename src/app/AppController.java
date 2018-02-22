package app;

import data.AppDatabase;
import data.Expense;
import utils.ConsoleDataReader;
import utils.FileWrite;
import utils.SortDatabase;
import exceptions.*;

import java.util.ArrayList;

public class AppController {

    // variables to control app
    public final int exit = 0;
    public final int addExpense = 1;
    public final int showExpenses = 2;
    public final int saveExpensesIntoFile = 3;
    public final int sortByName = 4;
    public final int sortByCategory = 5;
    public final int sortByPriceAscending = 6;
    public final int sortByPriceDescending = 7;
    public final int backToMainMenu = 8;

    // variable to communicate with the user
    private ConsoleDataReader consoleDataReader;

    // variable with database to holds all expense records
    private AppDatabase appDatabase;

    // variable to write all expense records into file
    private FileWrite fileWrite;

    // variable to sort database
    private SortDatabase sortDatabase;

    public AppController() {
        consoleDataReader = new ConsoleDataReader();
        appDatabase = new AppDatabase();
        fileWrite = new FileWrite();
        sortDatabase = new SortDatabase();
    }

    /*
     * Main loop of the app to control flow of the program
     */
    public void mainLoop() throws FieldUndefinedException, IncorrectPriceException, IncorrectMenuInputException {
        int option;
        printOptions();
        while ((option = consoleDataReader.getInt()) != exit) {
            switch (option) {
                case addExpense:
                    addExpense();
                    break;
                case showExpenses:
                    showExpenses();
                    break;
                case saveExpensesIntoFile:
                    saveExpensesIntoFile();
                    break;
                default:
                    System.out.println("Wrong choice. Let's try again:");
            }
            printOptions();
        }
        System.out.println("You quit from the app. Hope to see you soon.");
        // close input
        consoleDataReader.close();
    }

    private void printOptions() {
        System.out.println();
        System.out.println("     ****************************************");
        System.out.println("     *     MENU OF HOUSEHOLD EXPENSES APP   *");
        System.out.println("     ****************************************");
        System.out.println("     1. Add Expense");
        System.out.println("     2. Show all expenses");
        System.out.println("     3. Save expenses into file");
        System.out.println("     0. Quit");
        System.out.println();
    }

    private void printSortOptions() {
        System.out.println();
        System.out.println("     How would you like to sort expenses:");
        System.out.println();
        System.out.println("     4. Sort by name");
        System.out.println("     5. Sort by category");
        System.out.println("     6. Sort by price ascending");
        System.out.println("     7. Sort by price descending");
        System.out.println("     8. Back to main menu");
        System.out.println();
    }

    private void addExpense() throws FieldUndefinedException, IncorrectPriceException {
        Expense expense = consoleDataReader.createExpense();
        appDatabase.addRecord(expense);
    }

    private void showExpenses() throws IncorrectMenuInputException {
        int option;
        printSortOptions();
        while ((option = consoleDataReader.getInt()) != backToMainMenu) {
            switch (option) {
                case sortByName:
                    sortDatabase.sortByName(appDatabase.getExpenses());
                    appDatabase.printExpenses();
                    break;
                case sortByCategory:
                    sortDatabase.sortByCategory(appDatabase.getExpenses());
                    appDatabase.printExpenses();
                    break;
                case sortByPriceAscending:
                    sortDatabase.sortByPriceAscending(appDatabase.getExpenses());
                    appDatabase.printExpenses();
                    break;
                case sortByPriceDescending:
                    sortDatabase.sortByPriceDescending(appDatabase.getExpenses());
                    appDatabase.printExpenses();
                    break;
                default:
                    System.out.println("Wrong choice. Let's try again:");
            }
            printSortOptions();
        }
    }

    private void saveExpensesIntoFile() {
        fileWrite.writeFile((ArrayList<Expense>) appDatabase.getExpenses());
    }
}
