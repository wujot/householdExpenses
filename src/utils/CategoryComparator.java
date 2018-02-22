package utils;

import data.Expense;

import java.util.Comparator;

public class CategoryComparator implements Comparator<Expense>{
    @Override
    public int compare(Expense e1, Expense e2) {
        return e1.getCategory().compareTo(e2.getCategory());
    }
}
