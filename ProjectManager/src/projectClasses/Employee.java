package projectClasses;

import java.io.Serializable;
import java.util.ArrayList;

public class Employee extends Person implements Serializable {
    // Atributes
    private double EntryTime;
    private double ExitTime;
    final private String FilePath="Employee.bin";
    FileMangerBinary fm = new FileMangerBinary();
    ArrayList<Employee> employees = new ArrayList<>();
    // Constuctor
    public Employee(){}
    public Employee(double EntryTime, double ExitTime, int id, String password, String name, String position, int age) {
        super(id, password, name, position, age);
        this.EntryTime = EntryTime;
        this.ExitTime = ExitTime;
    }
    // Setter
    public void setEntryTime(double EntryTime) {
        this.EntryTime = EntryTime;
    }
    public void setExitTime(double ExitTime) {
        this.ExitTime = ExitTime;
    }
    // Getter
    public double getEntryTime() {
        return EntryTime;
    }
    public double getExitTime() {
        return ExitTime;
    }
    
    // View Penalities
    public void viewPens(Penalities pen){
        pen.viewPen(id);
    }
    
    // Calculate work Hours
    public double CalculateHours (){
         return (this.ExitTime - this.EntryTime);
    }
    // Add Employee in binaryFile     
    public boolean AddEmployee() {
        loadFromFile();
        employees.add(this);
        return commitToFile();
    }
    public void loadFromFile() {
        employees = (ArrayList<Employee>) fm.read(FilePath);
    }  
    public boolean commitToFile() {
        return fm.write(FilePath, employees);
    }
    // Modefy   
    public boolean UpdatEmployee (int oldID,Employee x){
        loadFromFile();
        int index = getEmployeeIndex(oldID);
        if (index != -1) {
            employees.set(index, x);
            return commitToFile();
        }
        return false;
    }
    private int getEmployeeIndex(int ID) {
        for (int i = 0; i < employees.size(); i++) {
            if (employees.get(i).getId()==ID )
                return i;
        }
        return -1;
    }
    public int calcHours(int eID) {
    	FileManger fm = new FileManger();
    	ArrayList<Integer> hour = new ArrayList<>();
    	hour = fm.read("Hours.txt", eID);
    	int hoursOverMonth = 0;
    	for(Integer x : hour) {
    		hoursOverMonth += x;
    	}
    	return hoursOverMonth;
    }
    public Object getEmployee(int ID) {
    	loadFromFile();
    	for (int i = 0; i < employees.size(); i++) {
            if (employees.get(i).getId()==ID )
                return employees.get(i);
        }
    	return null;
    }
    public boolean deleteEmployee(int id) {
        loadFromFile();
        int index = getEmployeeIndex(id);
        if (index != -1) {
            employees.remove(index);
            return commitToFile();
        }
        return false;
    }
    // Write Task and put it in file finished Task
    public void writeTask (Task myTask) {
        // the code here come from main or GUI
        myTask.AddFinishTask();
    }
    // toString
    @Override
    public String toString() {
        return "The Employee ID : " +id + "\n" + "THe Employee Name : " + name +  "\n" + "The Employee Position : " + position + "\n" + "The Employee Age : " + age + "\n"; 
    }
    // Login
    @Override
    public boolean login(int id, String password) {
        loadFromFile();
        for (Employee x : employees) {
            if ((x.id)==id&&password.equals(x.password)) {
                return true;
            }
        }
        return false;
    }
    // End of Employee
}
