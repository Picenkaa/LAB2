
package ds;

import java.util.ArrayList;
import java.util.Date;

public class Income extends Moneytrans implements Comparable <Income>{
    private Double pajamos;
  

    public Income(Double pajamos, Category cat, String komentaras, Date data) {
        super( cat, komentaras, data);
        this.pajamos = pajamos;
         categoryList.add(cat);
    }
    

    public Double getPajamos() {
        return pajamos;
    }

    public void setPajamos(Double pajamos) {
        this.pajamos = pajamos;
    }
    
    @Override
     public Double getSuma() {
        return pajamos;
    }
    

    @Override
    public String toString() {
        return "Income " + " pajamos= " + pajamos;
    }

      @Override
    public int compareTo(Income t) {
     return data.compareTo(t.data);
    }
}
