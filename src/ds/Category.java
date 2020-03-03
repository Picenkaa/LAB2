/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ds;

import java.util.ArrayList;

/**
 *
 * @author 50556
 */
public class Category {

    String name, description;
    
      private ArrayList<Expense> expenses = new ArrayList();
   

    public Category(String name, String description) {
        this.name = name;
        this.description = description;
    }

    
    public Expense addExpence(String islaidos, String checkqueNo) {
  Expense ex = new Expense(islaidos, checkqueNo, this);
      expenses.add(ex);
      return ex;
    }

        public ArrayList<Expense> getExpenses() {
        return expenses;
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
    

    @Override
    public String toString() {
        return "Kategorija: " + "name = " + this.name
                + ", aprasas = " + this.description + " ";
    }

  
    
    
    
}
