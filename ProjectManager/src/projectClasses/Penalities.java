package projectClasses;

import java.io.Serializable;
import java.util.ArrayList;

public class Penalities implements Serializable {
    // Atribute
    private String reason;
    private int employeeID;
    ArrayList <Penalities> Pens = new ArrayList <> ();
    FileMangerBinary  fm = new FileMangerBinary();
    static String fileName = "Penalities.bin";
    //Constructor
    public Penalities(){}
    public Penalities(String reason, int employeeID) {
        this.reason = reason;
        this.employeeID = employeeID;
    }
    // Setter and Getter
    public String getReason() {
        return reason;
    }
    public void setReason(String reason) {
        this.reason = reason;
    }

    public int getEmployeeID() {
        return employeeID;
    }
    public void setEmployeeID(int employeeID) {
        this.employeeID = employeeID;
    }
    // add Penalities in binary file by leader
    public boolean addPen() {
        loadFromFile();
        Pens.add(this);
        return commitToFile();
    }
    public boolean commitToFile() {
        return fm.write(fileName, Pens);
    }
    public void loadFromFile() {
        Pens = (ArrayList<Penalities>) fm.read(fileName);
    }
    // get index by empId
    private int getPenIndex(int empId) {
        for (int i = 0; i < Pens.size(); i++) {
            if (Pens.get(i).employeeID == empId)
                return i;
        }
        return -1;
    }
    // View Penalities for Employee
    public ArrayList<Penalities> viewPen(int id){
    	loadFromFile();
    	ArrayList<Penalities> pen = new ArrayList<>();
    	for(Penalities x : Pens) {
    		if (x.getEmployeeID() == id)
    			pen.add(x);
    	}
    	return pen;
    }
    // End of Penalities
}
