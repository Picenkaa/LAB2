
package ds;

import java.util.ArrayList;
import java.util.Objects;

public class Category {

    private String name, description;

    private ArrayList<Expense> expenses = new ArrayList();
    private ArrayList<Income> incomes = new ArrayList();

    public Category(String name, String description) {
        this.name = name;
        this.description = description;
    }

    public Expense addExpence(Double islaidos, String checkqueNo) {
        Expense ex = new Expense(islaidos, checkqueNo, this);
        expenses.add(ex);
        return ex;
    }

    public Income addIncome(Double pajamos) {
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

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 71 * hash + Objects.hashCode(this.name);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Category other = (Category) obj;
        if (!Objects.equals(this.name, other.name)) {
            return false;
        }
        return true;
    }

}
