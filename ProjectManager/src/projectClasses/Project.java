package projectClasses;

import java.io.Serializable;
import java.util.ArrayList;

public class Project implements Serializable {
    // Atributes
    private String projName;
    private int totalTasks, leaderId;
    private final String path = "ProjectName.bin";
    // Array of tasks of Project
    Task[] task = new Task[totalTasks]; 
    // Association with FileMangerBinary
    FileMangerBinary fm = new FileMangerBinary();
    // Array of Projects
    ArrayList<Project> projects = new ArrayList<>();
    // Constractors
    public Project(){}
    public Project(String projName, int totalTasks, int leaderId) {
        this.projName = projName;
        this.totalTasks = totalTasks;
        this.leaderId = leaderId;
    }
    // Setter
    public void setProjName(String projName) {
        this.projName = projName;
    }
    public void setTotalTasks(int totalTasks) {
        this.totalTasks = totalTasks;
    }
    public void setLeaderId(int leaderId) {
        this.leaderId = leaderId;
    }
    // Getter
    public String getProjName() {
        return projName;
    }
    public int getTotalTasks() {
        return totalTasks;
    }
    public int getLeaderId() {
        return leaderId;
    }
    // Add Project in binary file
    public boolean AddProject() {
        loadFromFile();
        projects.add(this);
        return commitToFile();
    }  
    public void loadFromFile() {
        projects = (ArrayList<Project>) fm.read(path);
    }   
    public boolean commitToFile() {
        return fm.write(path, projects);
    }
    // Delete Project
    private int getProgectIndex(String proName) {
        for (int i = 0; i < projects.size(); i++) {
            if (projects.get(i).projName.equals(proName))
                return i;
        }
        return -1;
    }
    public boolean deleteProject(String proName) {
        loadFromFile();
        int index = getProgectIndex(proName);

        if (index != -1) {
            projects.remove(index);
            return commitToFile();
        }
        return false;
    }
    // view required Project from Leader
    public ArrayList<Project> ViewProject () {  
    	loadFromFile();
        return projects;
    }
    public int GetTotalTasks(String ProjName) {
    	loadFromFile();
    	for(Project x : projects) {
    		if (x.getProjName().equals(ProjName))
    			return x.getTotalTasks();
    	}
    	return 0;
    }
    // End of Project
}
