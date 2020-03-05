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
 
    
public Double GetSuma(){
    Double expen=0.0;
     Double incom=0.0;
        for(Expense ex : cat.getExpenses()){
   expen+=Double.parseDouble(ex.getIslaidos());
       }
        for(Income in : cat.getIncomes()){
   incom+=Double.parseDouble(in.getPajamos());
       }
        expen=0-expen;
        suma=expen+incom;
        return suma;
    }

    @Override
    public String toString() {
        return "Moneytrans " + "suma=" + suma + ' ';
    }

}
