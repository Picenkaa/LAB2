
package ds;

import java.util.ArrayList;

public class Category {

    private String name, description;

    private ArrayList<Expense> expenses = new ArrayList();
    private ArrayList<Income> incomes = new ArrayList();

    public Category(String name, String description) {
        this.name = name;
        this.description = description;
    }

    public Expense addExpence(String islaidos, String checkqueNo) {
        Expense ex = new Expense(islaidos, checkqueNo, this);
        expenses.add(ex);
        return ex;
    }

    public Income addIncome(String pajamos) {
        Income in = new Income(pajamos, this);
        incomes.add(in);
        return in;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public ArrayList<Expense> getExpenses() {
        return this.expenses;
    }

    public ArrayList<Income> getIncomes() {
        return incomes;
    }

    @Override
    public String toString() {
        return "Kategorija: " + "name = " + this.name
                + ", aprasas = " + this.description + " ";
    }

}
