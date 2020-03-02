
package ds;

import java.util.ArrayList;
import java.util.Date;

public class Expense {
    private String checkqueNo = "-";
   private Double islaidos;
          private ArrayList<Category> categoryList = new ArrayList();
   

    public Expense(Double islaidos, String checkqueNo,Category cat) {
        categoryList.add(cat);
        this.islaidos = islaidos;
        this.checkqueNo= checkqueNo;
        
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

  

  
}
