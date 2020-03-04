
package ds;

import java.util.ArrayList;

public class Income {
    private String pajamos;
    private ArrayList<Category> categoryList = new ArrayList();

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

}
