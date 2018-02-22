package data;

import exceptions.*;

public class Expense implements Comparable<Expense>{
    private String nameOfProductOrService;
    private String description;
    private String category;
    private double price;

    public Expense() {}

    public Expense(String nameOfProductOrService, String description, String category, double price) throws IncorrectPriceException, FieldUndefinedException{
        this.setNameOfProductOrService(nameOfProductOrService);
        this.setDescription(description);
        this.setCategory(category);
        this.setPrice(price);
    }

    public String getNameOfProductOrService() {
        return nameOfProductOrService;
    }

    public void setNameOfProductOrService(String nameOfProductOrService) throws FieldUndefinedException {
        this.nameOfProductOrService = nameOfProductOrService;
        if (this.nameOfProductOrService == null || this.nameOfProductOrService.length() < 2) {
            throw new FieldUndefinedException();
        }
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) throws FieldUndefinedException{
        this.description = description;
        if (this.description == null || this.description.length() < 2) {
            throw new FieldUndefinedException();
        }
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) throws FieldUndefinedException{
        this.category = category;
        if (this.category == null || this.category.length() < 2) {
            throw new FieldUndefinedException();
        }
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) throws IncorrectPriceException {
        this.price = price;
        if (this.price <= 0) {
            throw new IncorrectPriceException();
        }
    }


    @Override
    public String toString() {
        return "Expense:\n" +
                "Name of product or service: " + nameOfProductOrService + "\n" +
                "Description: " + description + "\n" +
                "Category: " + category + "\n" +
                "Price: " + price + "\n";
    }

    @Override
    public int compareTo(Expense e) {
        return this.nameOfProductOrService.compareTo(e.nameOfProductOrService);
    }
}
