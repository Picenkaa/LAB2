package ds;

import java.util.ArrayList;
import java.util.Date;

public class Expense extends  Moneytrans {

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
          
         islaidos*=-1;
        return islaidos;
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
    
    
   
}
