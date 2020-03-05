
package ds;

import java.util.ArrayList;

public class Income extends Moneytrans {
    private String pajamos;
   // private ArrayList<Category> categoryList = new ArrayList();

    public Income(String pajamos, Category cat) {
         categoryList.add(cat);
        this.pajamos = pajamos;
    }

    public String getPajamos() {
        return pajamos;
    }

    public void setPajamos(String pajamos) {
        this.pajamos = pajamos;
    }

    @Override
    public String toString() {
        return "Income " + " pajamos= " + pajamos;
    }

   

  

}
