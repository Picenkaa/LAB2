
package ds;

import java.util.Date;

public class Expense {
    private String checkqueNo = "-";
    private String category;
   private Double islaidos;
   

    public Expense(Double islaidos, String category, String checkqueNo) {
        this.category = category;
        this.islaidos = islaidos;
        this.checkqueNo= checkqueNo;
        
    }

    public String getCheckqueNo() {
        return checkqueNo;
    }

    public void setCheckqueNo(String checkqueNo) {
        this.checkqueNo = checkqueNo;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public Double getIslaidos() {
        return islaidos;
    }

    public void setIslaidos(Double islaidos) {
        this.islaidos = islaidos;
    }

    @Override
    public String toString() {
        return "Expense{" + "checkqueNo=" + checkqueNo + ", category=" + category + ", islaidos=" + islaidos + '}';
    }

  
}
