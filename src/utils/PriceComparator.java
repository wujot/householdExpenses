package utils;

import data.Expense;

import java.util.Comparator;

public class PriceComparator implements Comparator<Expense> {
    @Override
    public int compare(Expense e1, Expense e2) {
        if (e1.getPrice() > e2.getPrice()) {
            return 1;
        }else if (e1.getPrice() == e2.getPrice()) {
            return 0;
        }
        return -1;
    }
}
