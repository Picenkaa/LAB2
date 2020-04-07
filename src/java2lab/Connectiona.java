/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package java2lab;


import java.sql.Connection;
import java.sql.*;


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

  public int update(String query){
    try{
      Statement statement = connection.createStatement();
      return statement.executeUpdate(query);
    }catch(SQLException e){
      System.out.println("ERROR while executing update query");
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
   
   
  

  public int delete(String query){
    try{
      Statement statement = connection.createStatement();
      return statement.executeUpdate(query);
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
