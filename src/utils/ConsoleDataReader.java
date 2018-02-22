package utils;

import data.Expense;
import exceptions.FieldUndefinedException;
import exceptions.IncorrectMenuInputException;
import exceptions.IncorrectPriceException;

import java.util.InputMismatchException;
import java.util.Scanner;

public class ConsoleDataReader {
    private Scanner sc;

    public ConsoleDataReader() {
        sc = new Scanner(System.in);
    }

    public void close() {
        sc.close();
    }

    public int getInt() throws InputMismatchException {
        int number;
        number = sc.nextInt();
        sc.nextLine();
        return number;
    }

    public Expense createExpense() throws FieldUndefinedException, IncorrectPriceException {
        System.out.println("Give an expense details:");
        System.out.println("Name of product or service:");
        String nameOfProductOrService = sc.nextLine();
        System.out.println("Description:");
        String description = sc.nextLine();
        System.out.println("Category:");
        String category = sc.nextLine();
        System.out.println("Price:");
        double price = Double.parseDouble(sc.nextLine());

        return new Expense(nameOfProductOrService, description, category, price);
    }
}
