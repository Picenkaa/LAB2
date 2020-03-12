/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ds;

import java.util.ArrayList;
import java.util.Date;
import java.util.Objects;

public class Moneytrans  {

    public ArrayList<Category> categoryList = new ArrayList();
    private Category cat;
    private String komentaras;
    protected Date data;
    private Double suma=0.0;
    
   
 //ArrayList<Category> list = fin.

    public Moneytrans(Category cat, String komentaras, Date data) {
        this.komentaras = komentaras;
        this.data = data;
    }


    public Category getCat() {
        return cat;
    }

    public void setCat(Category cat) {
        this.cat = cat;
    }

    public String getKomentaras() {
        return komentaras;
    }

    public void setKomentaras(String komentaras) {
        this.komentaras = komentaras;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public Double getSuma() {
        return suma;
    }

    public void setSuma(Double suma) {
        this.suma = suma;
    }




    @Override
    public String toString() {
        return "Moneytrans " + "suma=" + suma + ' ';
    }

   
    
    

}
