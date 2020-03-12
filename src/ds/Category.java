
package ds;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.Objects;

public class Category {

    private String name, description;

    private ArrayList<Expense> expenses = new ArrayList();
    private ArrayList<Income> incomes = new ArrayList();
     private ArrayList<Moneytrans> mt = new ArrayList();

    public Category(String name, String description) {
        this.name = name;
        this.description = description;
    }

    public Expense addExpence(Double islaidos, String checkqueNo, String komentaras, Date data) {
        Expense ex = new Expense(islaidos, checkqueNo, this, komentaras , data);
        expenses.add(ex);
       Moneytrans mts = new Moneytrans(this,komentaras,data);
      mt.add(ex);
      Collections.sort(expenses);
        return ex;
    }

    public Income addIncome(Double pajamos, String komentaras, Date data) {
        Income in = new Income(pajamos, this, komentaras ,data);
        incomes.add(in);
        Moneytrans mts = new Moneytrans(this,komentaras,data);
      mt.add(in);
        Collections.sort(incomes);
        return in;
    }

    public ArrayList<Moneytrans> getMt() {
        return mt;
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
