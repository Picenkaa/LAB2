package ds;

import java.util.ArrayList;
import java.util.Date;

public class Expense extends  Moneytrans {

    private String checkqueNo = "-";
    private Double islaidos;
  

    public Expense(Double islaidos, String checkqueNo, Category cat) {
        categoryList.add(cat);
        this.islaidos = islaidos;
        this.checkqueNo = checkqueNo;

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

    public void setIslaidos(String Double) {
        this.islaidos = islaidos;
    }

    @Override
    public String toString() {
        return "Expense " + "checkqueNo= " + checkqueNo + ", islaidos= " + islaidos ;
    }
    
    @Override
     public Double GetSuma(){
         islaidos*=-1;
        return islaidos;
    }
   
}
