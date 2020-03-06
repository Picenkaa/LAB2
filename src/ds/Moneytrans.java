/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ds;

import java.util.ArrayList;
import java.util.Date;

public class Moneytrans  {

    public ArrayList<Category> categoryList = new ArrayList();
    private String pavadinimas;
    private Category cat;
    private String komentaras;
    private Date data;
    private Double suma=0.0;
    private ArrayList<Moneytrans> mt = new ArrayList();
 
    
public Double GetSuma(){
    Double expen=0.0;
     Double incom=0.0;
        for(Expense ex : cat.getExpenses()){
   expen+=ex.getIslaidos();
        }
  
      
      for(Income in : cat.getIncomes()){
  incom+=in.getPajamos();
      }
      suma=(-1*expen)+incom;
      
   return suma;
    }

    @Override
    public String toString() {
        return "Moneytrans " + "suma=" + suma + ' ';
    }

}
