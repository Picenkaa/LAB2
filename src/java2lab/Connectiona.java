/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package java2lab;


import java.sql.Connection;
import java.sql.*;

/*
!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
Klase skirta prisijungimui prie derby apache embeeded to netbeans local serverio ir duonbazes
Nuotraukos . png formato yra is locla serverio ir Table yra  JAVA2LAB\FOTOGRAFIJOS DUONBAZE faile
Daugiau nuotrauku(be db dar_) info update ir commits https://github.com/Picenkaa/Personal-Finance-System
!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
*/

public class Connectiona {

  static final String DB_URL = "jdbc:derby://localhost:1527/database";
  static final String DB_USER = "root";
  static final String DB_PASSWORD = "pass";
  Connection connection;

  public Connectiona(){
    connect();
  }

  public void connect(){
    try{
      connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
      System.out.println("Connected to data base ");
    }  catch(Exception ex){
          ex.printStackTrace();
      }
  }

  public ResultSet select(String query){
    try{
      Statement statement = connection.createStatement();
      ResultSet result = statement.executeQuery(query);
      return result;
    }catch(SQLException e){
      System.out.println("ERROR while executing select query!");
      System.out.println(e.toString());
      return null;
    }
  }

  public int update(String query,String old,String newa ){
    try{
      PreparedStatement pstmt = connection.prepareStatement(query);
      pstmt.setString(1, old);
       pstmt.setString(2, newa);
    return pstmt.executeUpdate();
    }catch(SQLException e){
      System.out.println("ERROR while updating line!");
      System.out.println(e.toString());
      return -1;
    }
  }
  
   public int add(String query,String pav, String des){
    try{
     // Statement statement = connection.createStatement();
      PreparedStatement pstmt = connection.prepareStatement(query);
      pstmt.setString(1, pav);
      pstmt.setString(2, des);
      return pstmt.executeUpdate();
    }catch(SQLException e){
      System.out.println("ERROR while executing add query");
      System.out.println(e.toString());
      return -1;
    }
  }
   public int addexp (String query,double isl, String chekq, String com, Date datele,String cat){
    try{
     // Statement statement = connection.createStatement();
      PreparedStatement pstmt = connection.prepareStatement(query);
      pstmt.setDouble(1, isl);
      pstmt.setString(2,chekq);
       pstmt.setString(3,com);
        pstmt.setDate(4, datele);
    pstmt.setString(5,cat);
      return pstmt.executeUpdate();
    }catch(SQLException e){
      System.out.println("ERROR while executing add expense query");
      System.out.println(e.toString());
      return -1;
    }
  }
   
    public int addinc (String query,double paj, String com, Date datele,String cat){
    try{
     // Statement statement = connection.createStatement();
      PreparedStatement pstmt = connection.prepareStatement(query);
      pstmt.setDouble(1, paj);
      pstmt.setString(2,com);
        pstmt.setDate(3, datele);
         pstmt.setString(4,cat);
       
      return pstmt.executeUpdate();
    }catch(SQLException e){
      System.out.println("ERROR while executing add inc query");
      System.out.println(e.toString());
      return -1;
    }
  }
   
      public ResultSet check(String query,String pava){
    try{
     // Statement statement = connection.createStatement();
      PreparedStatement pstmt = connection.prepareStatement(query);
      pstmt.setString(1, pava);
       ResultSet result = pstmt.executeQuery();
      return result;
    }catch(SQLException e){
      System.out.println("ERROR while executing check query");
      System.out.println(e.toString());
      return null;
    }
  }
      
          public ResultSet getback(String query){
    try{
     // Statement statement = connection.createStatement();
      PreparedStatement pstmt = connection.prepareStatement(query);
       ResultSet result = pstmt.executeQuery();
      return result;
    }catch(SQLException e){
      System.out.println("ERROR while executing check query");
      System.out.println(e.toString());
      return null;
    }
  }
   
   
  

  public int  delete(String query,String vard){
    try{
    //  Statement statement = connection.createStatement();
     PreparedStatement pstmt = connection.prepareStatement(query);
      pstmt.setString(1, vard);
    return pstmt.executeUpdate();
    }catch(SQLException e){
      System.out.println("ERROR while deleting line!");
      System.out.println(e.toString());
      return -1;
    }
  }

  public void close(){
    try{
      connection.close();
    }catch(SQLException e){
      System.out.println("ERROR while closing connections!");
      System.out.println(e.toString());
    }
  }
    
}
