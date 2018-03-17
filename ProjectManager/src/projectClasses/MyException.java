package projectClasses;

import java.io.File;
import java.io.Serializable;
import javax.swing.*;

public class MyException extends Exception implements Serializable {

    public MyException() {
        super();
    }

    public MyException(String s) {
        super(s);
    }

    @Override
    public String toString() {
        return "My Exception";
    }

    int checkPositive(String x) {
        int number;
        do {
            number = Integer.parseInt(JOptionPane.showInputDialog("Enter Positive Number for " + x + " !"));
            if (number <= 0) {
                JOptionPane.showMessageDialog(null, "Not valid Input for Positive Int Try Again :(");
            }
        } while (number <= 0);

        return number;
    }

   /* public int checkLogin(int ID, String Password) {
    	Person x = null;
        	if ((ID)/10000 == 10) {
        		x = new Admin();
        		if (x.login(ID, Password)) return 1;
        	}
        	else if ((ID)/10000 == 20) {
        		x = new ProjectManger();
        		if (x.login(ID, Password)) return 2;
        	}
        	else if ((ID)/10000 == 30) {
        		x = new Leader();
        		if (x.login(ID, Password)) return 3;
        	}
        	else if ((ID)/10000 == 40) {
        		x = new Employee();
        		if (x.login(ID, Password)) return 4;
        	}
        	return 0;
       }*/
    public boolean filesExists(String name) {
    	File exist = new File(name);
    	if (exist.exists())
    		return true;
    	return false;
    }
    public boolean checkIdPosition(int id){
        String Position = null;
                 if(id == 100000)
                return true;
            else if (id/10000 == 20)
            	return true;
            else if (id/10000 == 30 )
            	return true;
            else if (id/10000 == 40 )
            	return true;
            else{
                JOptionPane.showMessageDialog(null, "Not valid Input for Position Try Again :(");
            }
                 return false;
    }
    

    public String checkPassLength(String x) {
        String pass;
        do {
            pass = JOptionPane.showInputDialog("Enter more than 8 char for " + x + " !");
            if (pass.length() < 8) {
                JOptionPane.showMessageDialog(null, "Not valid Password length Try Again :(");
            }
        } while (pass.length() < 8);

        return pass;
    }
    int checkDay(String x){
        int day;
        do{
            day = Integer.parseInt(JOptionPane.showInputDialog("Enter the right " + x + " !"));
            if (day > 30 || day < 0)
                JOptionPane.showMessageDialog(null, "Not valid Day :(");
        }while(day > 30 || day < 0);
        return day;
    }
    int checkMonth(String x){
        int month;
        do{
            month = Integer.parseInt(JOptionPane.showInputDialog("Enter the right " + x + " !"));
            if (month > 12 || month < 0)
                JOptionPane.showMessageDialog(null, "Not valid Month :(");
        }while(month > 12 || month < 0);
        return month;
    }
    int checYear(String x){
        int year;
        do{
            year = Integer.parseInt(JOptionPane.showInputDialog("Enter the right " + x + " !"));
            if (year < 2017)
                JOptionPane.showMessageDialog(null, "Not valid Year :(");
        }while(year < 2017);
        return year;
    }
   }

