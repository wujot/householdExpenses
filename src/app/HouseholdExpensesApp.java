package app;

import exceptions.FieldUndefinedException;
import exceptions.IncorrectMenuInputException;
import exceptions.IncorrectPriceException;

import java.util.InputMismatchException;

public class HouseholdExpensesApp {

    public static void main(String[] args) {

        final String appName = "Household Expenses v0.1";
        System.out.println(appName);
        AppController appControl = new AppController();

        try {
            appControl.mainLoop();
        }catch (FieldUndefinedException | IncorrectPriceException | InputMismatchException e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        } catch (IncorrectMenuInputException e) {
            e.printStackTrace();
        }
    }
}
