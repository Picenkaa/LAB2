/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UI;

import static UI.JAVA3LAB.con;
import ds.Category;
import ds.PersonalFinance;
import static java.awt.image.ImageObserver.WIDTH;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Lenovo
 */
public class Islaidusar extends javax.swing.JFrame {
PersonalFinance a = null;
    /**
     * Creates new form Islaidusar
     */
    public Islaidusar(PersonalFinance b) {
         a=b;
        initComponents();
         atnaujintilentele5();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane2 = new javax.swing.JScrollPane();
        jList1 = new javax.swing.JList<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jList1.setToolTipText("");
        jList1.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jScrollPane2.setViewportView(jList1);
        jList1.getAccessibleContext().setAccessibleName("");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(39, 39, 39)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 454, Short.MAX_VALUE)
                .addGap(65, 65, 65))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 199, Short.MAX_VALUE)
                .addGap(70, 70, 70))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

   public void atnaujintilentele5(){
    try {
        String sql = "SELECT ISLAIDOS FROM APP.PS";
        ResultSet rsl = con.getback(sql);
        ResultSetMetaData rsmd = rsl.getMetaData();
        int columnsNumber = rsmd.getPrecision(WIDTH);
        String [] mas = new String [columnsNumber];
        
        int i = 0;
        while(rsl.next()) {
            mas[i] = rsl.getString("ISLAIDOS"); 
      
            i++;
        }
        jList1.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = mas;
            
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
    } catch (SQLException ex) {
        Logger.getLogger(Islaidusar.class.getName()).log(Level.SEVERE, null, ex);
    }
   }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JList<String> jList1;
    private javax.swing.JScrollPane jScrollPane2;
    // End of variables declaration//GEN-END:variables
}
