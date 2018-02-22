package utils;

import data.Expense;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class SortDatabase {
    private List<Expense> expenses;
    private Comparator comparator;

    public SortDatabase() {
        expenses = new ArrayList<>();
        comparator = null;
    }

    public void sortByName(List<Expense> expenses) {
        Collections.sort(expenses);
    }

    public void sortByCategory(List<Expense> expenses) {
        comparator = new CategoryComparator();
        Collections.sort(expenses, comparator);
    }

    public void sortByPriceAscending(List<Expense> expenses) {
        comparator = new PriceComparator();
        Collections.sort(expenses, comparator);
    }

    public void sortByPriceDescending(List<Expense> expenses) {
        comparator = new PriceComparator();
        Collections.sort(expenses, Collections.reverseOrder(comparator));
    }
}
