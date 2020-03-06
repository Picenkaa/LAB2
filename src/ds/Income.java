
package ds;

import java.util.ArrayList;

public class Income extends Moneytrans {
    private Double pajamos;
   // private ArrayList<Category> categoryList = new ArrayList();

    public Income(Double pajamos, Category cat) {
        
         categoryList.add(cat);
        this.pajamos = pajamos;
    }

    public Double getPajamos() {
        return pajamos;
    }

    public void setPajamos(Double pajamos) {
        this.pajamos = pajamos;
    }

    @Override
    public String toString() {
        return "Income " + " pajamos= " + pajamos;
    }

   @Override
     public Double GetSuma(){
        
        return pajamos;
    }

}
