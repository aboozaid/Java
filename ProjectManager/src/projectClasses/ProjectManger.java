package projectClasses;

import java.io.Serializable;
import java.util.ArrayList;

public class ProjectManger extends Person implements Serializable {
    // Atribute
    private final String path = "PM.bin";
    // Array of PM
    ArrayList<ProjectManger> PMs = new ArrayList<>();
    // Assocition 
    FileMangerBinary fm = new FileMangerBinary();
    // project manger will fill projectnumber attr in project's class by GUI
    public ProjectManger() {}
    public ProjectManger(int id, String password, String name, String position, int age) {
        super(id, password, name, position, age);
    }
    // ViewPrecentage 
    /* this function not totaly right */
    public void viewPrecentage(Project pro){ // Aggregation
        ArrayList<Task> tasks = new ArrayList<>();
        tasks = (ArrayList<Task>) fm.read("FinishedTasks.bin");
        float x = (tasks.size() / pro.getTotalTasks())*100;
        System.out.println("The percentage is: " + x);
    }
    // Add PM by Admin in BinaryFile
    public boolean AddProjectManager() {
        loadFromFile();
        PMs.add(this);
        return commitToFile();
    }
    public void loadFromFile() {
        PMs = (ArrayList<ProjectManger>) fm.read(path);
    }  
    public boolean commitToFile() {
        return fm.write(path, PMs);
    }
    // Modefi PM 
    public boolean UpdatPM (int ID,ProjectManger x){
        loadFromFile();
        int index = getProjectManagerIndex(ID);

        if (index != -1) {
            PMs.set(index, x);
            return commitToFile();
        }
        return false;
    }
    private int getProjectManagerIndex(int ID) {
        for (int i = 0; i < PMs.size(); i++) {
            if (PMs.get(i).getId()==ID )
                return i;
        }
        return -1;
    }
    public Object getProjectManger(int ID) {
    	loadFromFile();
    	for (int i = 0; i < PMs.size(); i++) {
            if (PMs.get(i).getId()==ID )
                return PMs.get(i);
        }
    	return null;
    }
    public boolean deleteProjectManager(int id) {
        loadFromFile();
        int index = getProjectManagerIndex(id);

        if (index != -1) {
            PMs.remove(index);

            return commitToFile();
        }

        return false;
    }
    // toSting
    @Override
    public String toString() {
        return "The Project Manager ID : " + id + "\n" + "The Project Manager Name: " + name + "\n" + "The Project Manager Position : " + position + "\n" + " The Project Manager Age : " + age + "\n";
    }
    // Logig
    @Override
    public boolean login(int id, String password) {
        loadFromFile();
        for (ProjectManger x : PMs) {
            if (id == (x.id) && password.equals(x.password)) {
                return true;
            }
        }
        return false;
    }
    // MakeReport
    /* May be maked by GUI */
    public void makeReport() {
        Report myReport = new Report(); 
        myReport.addReport(); 
    }
    // Assign Project 
    /* May be maked by GUI */
    public void AssignProject(){
        Project pro = new Project();
        pro.AddProject();
    }
    // End of PM
}
