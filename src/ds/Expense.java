package ds;

import java.util.ArrayList;
import java.util.Date;


public class Expense extends  Moneytrans implements Comparable <Expense>   {

    private String checkqueNo = "-";
    private Double islaidos;
  

    public Expense(Double islaidos, String checkqueNo, Category cat, String komentaras, Date data) {
        super(cat, komentaras, data);
        this.islaidos = islaidos;
        this.checkqueNo = checkqueNo;
         categoryList.add(cat);
    }


    @Override
     public Double getSuma() {
          
        return -1*islaidos;
    }

    public String getCheckqueNo() {
        return checkqueNo;
    }

    public void setCheckqueNo(String checkqueNo) {
        this.checkqueNo = checkqueNo;
    }

    public Double getIslaidos() {
        return islaidos;
    }

    public void setIslaidos(Double islaidos) {
        this.islaidos = islaidos;
    }

  

    @Override
    public String toString() {
        return "Expense " + "checkqueNo= " + checkqueNo + ", islaidos= " + islaidos ;
    }
    
     @Override
    public int compareTo(Expense t) {
     return data.compareTo(t.data);
    }
   
}
