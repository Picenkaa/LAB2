/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ds;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;

public class PersonalFinance {

    private ArrayList<Category> categoryList = new ArrayList();
    

    public Category addCategory(String name, String description) {
        Category cat = new Category(name, description);
        if (!categoryList.contains(cat)) {
            categoryList.add(cat);
          
        }
        return cat;
    }

    public Category gautikategorija(String vardas) {
        for (Category e : categoryList) {
            if (e.getName().equals(vardas)) {
                return e;
            }
        }
        return null;
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

}
