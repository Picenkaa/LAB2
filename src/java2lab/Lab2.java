package java2lab;

import ds.Category;
import ds.Expense;
import ds.Income;
import ds.PersonalFinance;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.util.Scanner;


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
                    incomeControl(scr, pf);
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
            case "quit":
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

            case "add":
                System.out.println("write category name");
                String eName = scan.next();
                System.out.println("write cheque nr");
                String ec = scan.next();
                System.out.println("expenses");
                String islaidos = scan.next();
                Expense ex = fin.gautikategorija(eName).addExpence(islaidos, ec);
                // new Category(); 
                break;
            case "print":
                System.out.println("write category name");
                String cName = scan.next();
                System.out.println(fin.gautikategorija(cName).getExpenses());
                break;
            case "allprint":

                ArrayList<Category> list2 = fin.getCategory();

                for (Category n : list2) {
                    System.out.println(n.toString());
                    if (n.getExpenses() != null) {
                        System.out.println(n.getExpenses().toString());
                    }
                }

                break;

            case "save":
                ArrayList<Category> listToSave = fin.getCategory();
                try {
                    FileWriter file = new FileWriter(new File("dataislaidos.txt"));
                    for (Category b : listToSave) {
                        file.write(b.getExpenses().toString());
                    }
                    file.close();
                } catch (Exception e) {
                    System.out.println("Unable to perform operation");
                }
                break;
                  case "load":
                        Scanner s = null;
        String pirmaEilute = null;
        try {
            s = new Scanner(new File("src/duomenys.txt"));
            String Kategorija = null;
            while (s.hasNext()) {
                pirmaEilute = s.nextLine();
                if (pirmaEilute.trim().endsWith(":")) {
                    Kategorija = pirmaEilute.replaceFirst(".$","");;
                } else {
                    String[] duom = pirmaEilute.split(";");
                    String komentaras = duom[0];
                 fin.addCategory(Kategorija, komentaras);
                    String chekionr = duom[1];
                  
                    String islaideles = duom[2];
                    fin.gautikategorija(Kategorija).addExpence(islaideles, chekionr);
                }
            }
        } catch (Exception klaida) {
            System.out.println("Klaida");
            klaida.printStackTrace();
        } finally {
            if (s != null) {
                s.close();
            }
        }
    
                
                break;
            case "quit":
                break;
            default:
                System.out.println("Invalid value");
                break;
        }

    }

    public static void incomeControl(Scanner scan, PersonalFinance fin) {
        String line = "";
        System.out.println("Choose from income option list: \n"
                + "\tadd - add income to chosen category \n"
                + "\tprint - print income from chosen category\n"
                + "\tallprint - print all income from all categories\n"
                + "\tsave - save category incomes to file\n"
                + "\tload -load category incomes from file\n"
                + "\tquit - Quit\n");

        line = scan.next().trim();
        switch (line.toLowerCase()) {

            case "add":
               System.out.println("write category name");
                String eName = scan.next();
                System.out.println("incomes");
                String incom = scan.next();
               Income in = fin.gautikategorija(eName).addIncome(incom);
                break;
            case "print":
               System.out.println("write category name");
                String cName = scan.next();
                System.out.println(fin.gautikategorija(cName).getIncomes());
                break;
            case "allprint":
                  ArrayList<Category> list3 = fin.getCategory();

                for (Category h : list3) {
                    System.out.println(h.toString());
                    if (h.getIncomes() != null) {
                        System.out.println(h.getIncomes().toString());
                    }
                }

                break;

            case "save":
                ArrayList<Category> listToSave = fin.getCategory();
                try {
                    FileWriter file = new FileWriter(new File("datapajamos.txt"));
                    for (Category c : listToSave) {
                        file.write(c.getIncomes().toString());
                    }
                    file.close();
                } catch (Exception e) {
                    System.out.println("Unable to perform operation");
                }
                break;
           
            case "load":  
                Scanner s = null;
        String pirmaEilute = null;
        try {
            s = new Scanner(new File("src/duomenys.txt"));
            String Kategorija = null;
            while (s.hasNext()) {
                pirmaEilute = s.nextLine();
                if (pirmaEilute.trim().endsWith(":")) {
                    Kategorija = pirmaEilute.replaceFirst(".$","");;
                } else {
                    String[] duom = pirmaEilute.split(";");
                    String komentaras = duom[0];
                    fin.addCategory(Kategorija, komentaras);
                    
                       String pajamos = duom[3];
                  
                    fin.gautikategorija(Kategorija).addIncome(pajamos);
                }
            }
        } catch (Exception klaida) {
            System.out.println("Klaida");
            klaida.printStackTrace();
        } finally {
            if (s != null) {
                s.close();
            }
        }
    
                
        
                break;
            case "quit":
                break;
            default:
                System.out.println("Invalid value");
                break;
        }

    }

}
