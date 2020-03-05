package ds;

import java.util.ArrayList;
import java.util.Date;

public class Expense extends  Moneytrans {

    private String checkqueNo = "-";
    private String islaidos;
    private ArrayList<Category> categoryList = new ArrayList();

    public Expense(String islaidos, String checkqueNo, Category cat) {
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

    public String getIslaidos() {
        return islaidos;
    }

    public void setIslaidos(String islaidos) {
        this.islaidos = islaidos;
    }

    @Override
    public String toString() {
        return "Expense " + "checkqueNo= " + checkqueNo + ", islaidos= " + islaidos ;
    }

}
