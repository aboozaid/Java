package projectClasses;

import java.io.Serializable;
import java.util.ArrayList;


public class Leader extends Person implements Serializable {
    // Atribute
	String ProjName;
    private final String fileName = "Leader.bin";
    // Array of Leaders
    ArrayList<Leader> Leds = new ArrayList<>();
    // Association
    FileMangerBinary fm = new FileMangerBinary ();
    // Constructor
    public Leader() {}
    public Leader(int id, String password, String name, String position, int age) {
        super(id, password, name, position, age);
    }
    // toString
    @Override
    public String toString(){
        return "The Leader ID : "+ id + "\n" + "The Leader Name : "+ name + "\n" + "The Leader Position : "+ position + "\n" + "The Leader Age : "+ age + "\n";
    }
    // Add Leader by Admin to binary file
    public boolean addLeader() {
        loadFromFile();
        Leds.add(this);
        return commitToFile();
    }
    public boolean commitToFile() {
        return fm.write(fileName, Leds);
    }
    public void loadFromFile() {
        Leds = (ArrayList<Leader>) fm.read(fileName);
    }
    
    /* May be maked by GUI or Main */
    public void AssignTask(String taskName,String ProjectName ,String description, int taskNo, int EmployeeID){
        Task task = new Task(taskName, ProjName,description, taskNo, EmployeeID);
        task.AddTask();
    }
    private int getLeaderIndex(int ID) {
        for (int i = 0; i < Leds.size(); i++) {
            if (Leds.get(i).getId()==ID )
                return i;
        }
        return -1;
    }
    public boolean UpdatLeader (int oldID,Leader x){
        loadFromFile();
        int index = getLeaderIndex(oldID);
        if (index != -1) {
        	Leds.set(index, x);
            return commitToFile();
        }
        return false;
    }
    public boolean deleteLeader(int id) {
        loadFromFile();
        int index = getLeaderIndex(id);
        if (index != -1) {
            Leds.remove(index);
            return commitToFile();
        }
        return false;
    }
    public Object getLeader(int ID) {
    	loadFromFile();
    	for (int i = 0; i < Leds.size(); i++) {
            if (Leds.get(i).getId()==ID )
                return Leds.get(i);
        }
    	return null;
    }
    
    // View Finished Tasks
    public void viewFTasks(ArrayList<Task> tasks){
        tasks = (ArrayList<Task>) fm.read("FinishedTasks.bin");
        System.out.println(tasks);
        /*
        for(int i=0; i<tasks.size(); i++)
            System.out.println(tasks.get(i));
        */
    }
    // View Vacatons Requests
    public void viewVac(ArrayList<Vacation> vacs){
        vacs = (ArrayList<Vacation>) fm.read(Vacation.fileName);
        System.out.println(vacs);
        /*
        for(int i=0; i<vacs.size(); i++)
            System.out.println(vacs.get(i));
        */
    }
    // Anser the vacation request from Employee
    /* may be GUI */
    public boolean vacRespond(Vacation vac){
        return true; // the answer will be scanned in GUI 
    }
    // Login
    @Override
    public boolean login(int id, String password) {
        loadFromFile();
        for (Leader x : Leds) {
            if (id == (x.id) && password.equals(x.password)) {
                return true;
            }
        }
        return false;
    }
    // End of Leader
}
