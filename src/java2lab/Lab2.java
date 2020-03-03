package java2lab;

import ds.Category;
import ds.Expense;
import ds.PersonalFinance;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.util.Scanner;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
public class Lab2 {
 static Category cat;
    public static void main(String[] args) {
        PersonalFinance pf = new PersonalFinance();
      
      
       
         
   
   
       


        try {
            ObjectInputStream inSt = new ObjectInputStream(new FileInputStream("data.txt"));
            pf = (PersonalFinance) inSt.readObject();
        } catch (Exception e) {

        }
        Scanner scr = new Scanner(System.in);
        String command = "";

        while (!command.equals("f")) {
            System.out.println("Choose from list: \n"
                    + "\tc - category \n"
                    + "\te - expense\n"
                    + "\ti - income\n"
                    + "\tb - balance\n"
                    + "\tf - finish");

            command = scr.next();
            System.out.println("You have chosen option: " + command);

            switch (command) {
                case "c":
                    categoryControl(scr, pf);
                    break;
                case "e":
                    expenseControl(scr, pf);
                    break;
                case "i":
                    break;
                case "b":
                    break;
                case "f":
                    break;
            }
        }

    }

    public static void categoryControl(Scanner scan, PersonalFinance fin) {
        String line = "";

        System.out.println("Choose from category option list: \n"
                + "\tprint - Print \n"
                + "\tadd - Add\n"
                + "\tdel - Delete\n"
                + "\tedit - Edit\n"
                + "\tsave - save to file"
                + "\tload -load from file"
                + "\tquit - Quit");

        line = scan.next().trim();
        switch (line.toLowerCase()) {
            case "print":
                ArrayList<Category> list = fin.getCategory();
                int no = 1;
                for (Category k : list) {
                    System.out.printf("%3d. %s\n", no, k.toString());
                    no++;
                }
                break;
            case "add":
                System.out.println("Add category name");
                String catName = scan.next();
                System.out.println("Add category description");
                String catDesc = scan.next();
       //  Category ex = 
         cat = fin.addCategory(catName, catDesc);
         
                break;
            case "del":
                
                System.out.println("Remove category name");
                String catNameRem = scan.next();
                fin.removeCategory(catNameRem);
                break;
            case "edit":
                System.out.println("To edit category enter old category name ");
                String catold = scan.next();
                System.out.println("Now enter new category name ");
                String catnew = scan.next();
                fin.updateCategoryName(catold, catnew);
                break;
            case "save":
                ArrayList<Category> listToSave = fin.getCategory();
                try {
                    FileWriter file = new FileWriter(new File("data.txt"));
                    for (Category k : listToSave) {
                        file.write(k.toString());
                    }
                    file.close();
                } catch (Exception e) {
                    System.out.println("Unable to perform operation");
                }
                break;
            case "quit":
                break;
            case "load":

                break;
            default:
                System.out.println("Invalid value");
                break;
                
        }
        
    }
     public static void expenseControl(Scanner scan, PersonalFinance fin) {
        String line = "";
        System.out.println("Choose from expense option list: \n"
                + "\tadd - add expenses to chosen category \n"
                + "\tprint - print expenses from chosen category\n"
                + "\tallprint - print all expenses from all categories\n"
                + "\tsave - save category expenses to file\n"
                + "\tload -load category expenses from file\n"
                + "\tquit - Quit\n");

        line = scan.next().trim();
        switch (line.toLowerCase()) {
            case "allprint": 
                 ArrayList<Expense> list = cat.getExpenses();
                int no = 1;
                for (Expense k : list) {
                    System.out.printf("%3d. %s\n", no, k.toString());
                    no++;
                }
                
                break;
            case "add":
                System.out.println("write category name");
                String eName = scan.next();
                 System.out.println("write cheque nr");
                    String ec = scan.next();
                  System.out.println("expenses");
                 String islaidos =scan.next();
             Expense ex = fin.gautikategorija(eName).addExpence(islaidos, ec);
              // new Category(); 
                break;
            case "del":
                  /*
                System.out.println("Remove category name");
                String catNameRem = scan.next();
                fin.removeCategory(catNameRem);
*/
                break;
            case "edit":
                /*
                System.out.println("To edit category enter old category name ");
                String catold = scan.next();
                System.out.println("Now enter new category name ");
                String catnew = scan.next();
                fin.updateCategoryName(catold, catnew);
                 */
                break;
               
            case "save":
                  /*
                ArrayList<Category> listToSave = fin.getCategory();
                try {
                    FileWriter file = new FileWriter(new File("data.txt"));
                    for (Category k : listToSave) {
                        file.write(k.toString());
                    }
                    file.close();
                } catch (Exception e) {
                    System.out.println("Unable to perform operation");
                }
*/
                break;
            case "quit":
                break;
            case "load":

                break;
            default:
                System.out.println("Invalid value");
                break;
        }

    }
    

}