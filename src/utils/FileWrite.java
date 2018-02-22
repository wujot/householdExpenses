package utils;

import data.Expense;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class FileWrite {
    private String fileName = "expenses.csv";

    public FileWrite() {
    }

    public void writeFile(ArrayList<Expense> expenses) {

        FileWriter fileWrite = null;

        try {
            fileWrite = new FileWriter(fileName);

            // write expense objects into csv file
            for (int i = 0; i < expenses.size(); i++) {
                fileWrite.append(expenses.get(i).getNameOfProductOrService());
                fileWrite.append(";");
                fileWrite.append(expenses.get(i).getDescription());
                fileWrite.append(";");
                fileWrite.append(expenses.get(i).getCategory());
                fileWrite.append(";");
                fileWrite.append(String.valueOf(expenses.get(i).getPrice()));
                fileWrite.append(";");
                fileWrite.append("\n");
            }
            System.out.println("Expenses were saved into file successfully.");
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                fileWrite.flush();
                fileWrite.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
