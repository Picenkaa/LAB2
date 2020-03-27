package java2lab;

import ds.Category;
import ds.Expense;
import ds.Income;
import ds.Moneytrans;
import ds.PersonalFinance;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.ObjectInputStream;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;


public class Lab2 {

    static Category cat;
    static Expense ex;
    static Income in;
   

    public static void main(String[] args) throws ParseException {
        PersonalFinance pf = new PersonalFinance();
      // NewJFrame ui = new NewJFrame();
       // ui.setVisible(true);

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
                    balanseControl(scr, pf);
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

    public static void expenseControl(Scanner scan, PersonalFinance fin) throws ParseException {
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
                 try {
                System.out.println("write category name");     
                String eName = scan.next();
                System.out.println("write cheque nr");
                String ec = scan.next();
                System.out.println("expenses");
                String islaidos = scan.next();
                Double islaidos1 = Double.parseDouble(islaidos);
                System.out.println("write comment");
                String komentaras1 = scan.next();
                System.out.println("write date int this format dd/MM/yyyy");
                String sDate1 = scan.next();
               
   Date data = new SimpleDateFormat("dd/MM/yyyy").parse(sDate1);

  
               ex = fin.gautikategorija(eName).addExpence(islaidos1, ec, komentaras1, data);
                 }
      catch(Exception e){System.out.println("Category doesent exist or information is entered incorrectly");break;};
                break;
            case "print":
                try{
                System.out.println("write category name");
                String cName = scan.next();
                System.out.println(fin.gautikategorija(cName).getExpenses());
                }
                  catch(Exception e){System.out.println("Incorrect category name ");break;};
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
                            Kategorija = pirmaEilute.replaceFirst(".$", "");;
                        } else {
                            String[] duom = pirmaEilute.split(";");
                            String komentaras = duom[0];

                           cat= fin.addCategory(Kategorija, komentaras); // returinina cat jeigu nera

                            String chekionr = duom[1];

                            String islaideles = duom[2];

                            String komentarass = duom[4];

                            String sDate11 = duom[5];
                            Date data1 = new SimpleDateFormat("dd/MM/yyyy").parse(sDate11);

                            Double islaidos2 = Double.parseDouble(islaideles);
                            fin.gautikategorija(Kategorija).addExpence(islaidos2, chekionr, komentarass, data1);

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

    public static void incomeControl(Scanner scan, PersonalFinance fin) throws ParseException {
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
                try{
                System.out.println("write category name");
                String eName = scan.next();
                System.out.println("incomes");
                String incom = scan.next();
                Double income1 = Double.parseDouble(incom);
                System.out.println("write comment");
                String kom = scan.next();
                System.out.println("write date int this format dd/MM/yyyy");
                String sDate1 = scan.next();
                Date data = new SimpleDateFormat("dd/MM/yyyy").parse(sDate1);
                in = fin.gautikategorija(eName).addIncome(income1, kom, data);}
                 catch(Exception e){System.out.println("Category doesent exist or information is entered incorrectly");break;};
                break;
            case "print":
                try{
                System.out.println("write category name");
                String cName = scan.next();
                System.out.println(fin.gautikategorija(cName).getIncomes());
                }
                 catch(Exception e){System.out.println("Incorrect category name");break;};
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
                            Kategorija = pirmaEilute.replaceFirst(".$", "");;
                        } else {
                            String[] duom = pirmaEilute.split(";");
                            String komentaras = duom[0];

                          cat =  fin.addCategory(Kategorija, komentaras);  //returinina cat jeigu nera

                            String pajamos = duom[3];
                            String komentarass = duom[4];
                            String sDate11 = duom[5];
                            Date data1 = new SimpleDateFormat("dd/MM/yyyy").parse(sDate11);

                            Double income12 = Double.parseDouble(pajamos);

                            fin.gautikategorija(Kategorija).addIncome(income12, komentarass, data1);
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

    public static void balanseControl(Scanner scan, PersonalFinance fin) {
        String line = "";
        System.out.println("Choose from income option list: \n"
                + "\tprint - print balance\n"
                + "\tsave - save category expense income\n"
                + "\tload -load category expense income \n"
                + "\tquit - Quit\n");

        line = scan.next().trim();
        switch (line.toLowerCase()) {
            case "print":
                
               Double suma=0.0;        
                ArrayList<Category> list = fin.getCategory();
                 ArrayList<Expense> list1 = cat.getExpenses();
                  ArrayList<Income> list2 = cat.getIncomes();
                  
                for (Category c : list) {     
                              
                for (Expense e : list1) {     
                   suma+=e.getSuma();
                }     
                 for (Income i : list2) {     
                   suma+=i.getSuma();
                }   
                }
                 System.out.println("balansinis likutis: " +suma);
                 
                break;
            case "save":
                
                ArrayList<Category> listToSave = fin.getCategory();
                try {
                    FileWriter file = new FileWriter(new File("datapajamosislaidos.txt"));
                    for (Category c : listToSave) {
                        file.write(c.getIncomes().toString());
                    }
                    for (Category c : listToSave) {
                        file.write(c.getExpenses().toString());
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
                            Kategorija = pirmaEilute.replaceFirst(".$", "");;
                        } else {
                            String[] duom = pirmaEilute.split(";");
                            String komentaras = duom[0];

                           cat= fin.addCategory(Kategorija, komentaras); // if nera cat add, else return 

                            String chekionr = duom[1];

                            String islaideles = duom[2];
                            Double ex13 = Double.parseDouble(islaideles);
                            String pajamos = duom[3];
                            Double income14 = Double.parseDouble(pajamos);

                            String komentarass = duom[4];

                            String sDate11 = duom[5];
                            Date data1 = new SimpleDateFormat("dd/MM/yyyy").parse(sDate11);
                           
                            fin.gautikategorija(Kategorija).addExpence(ex13, chekionr, komentarass, data1);
                            fin.gautikategorija(Kategorija).addIncome(income14, komentarass, data1);

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
