/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ds;

import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author 50556
 */
public class PersonalFinance {

    private ArrayList<Category> categoryList = new ArrayList();
     private ArrayList<Expense> expenses = new ArrayList();

    public void addCategory(String name, String description) {
        Category cat = new Category(name, description);
        if (!categoryList.contains(cat)) {
            categoryList.add(cat);
        }
    }

    public void removeCategory(String categoryName) {
        Category cat = new Category(categoryName, null);
        for (Category c : this.categoryList) {
            if (c.getName().equals(categoryName)) {
                cat = c;
            }
        }
        this.categoryList.remove(cat);

    }

    public void updateCategoryName(String categoryOld/*Maistas*/, String categoryNew) {
        for (Category c : this.categoryList) {
            if (/*"Maistas".equals(c.getName())*/categoryOld.equals(c.getName())) {
                c.setName(categoryNew);
            }
        }
    }

    public ArrayList<Category> getCategory() {
        return this.categoryList;
    }
    
  

    public void addExpence(Double islaidos,String category, String checkqueNo) {
Expense naujas = new Expense(islaidos,category,checkqueNo);
       if (!categoryList.contains(category)) {
            expenses.add(naujas);
    }
    }


    public ArrayList<Expense> getExpenses() {
        return this.expenses;
    }


 

  

}
