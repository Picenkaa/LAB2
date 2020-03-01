/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ds;

import java.util.Date;

public class MoneyTrans {
    protected double sum;
    private Category category;
    private String description;
    private Date data;
    private String comment; 
    
    //Konstruktorius(Category cat,...)
    
    public double getSum(){
        return sum;
    }
    
 /*   public Category getCategory(){
        return category;
    }
    */
    public String getDescription(){
        return description;
    }

    public Date getData() {
        return data;
    }

    public String getComment() {
        return comment;
    }
    
    //override to string
    
    
    
    
    
}
