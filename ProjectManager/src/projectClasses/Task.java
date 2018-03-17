package projectClasses;

import java.io.Serializable;
import java.util.ArrayList;

public class Task implements Serializable {
    // Atribute
    private String taskName, ProjectName;
    private String description, writeTask; 
    private int taskNo;
    private int EmployeeID;
    //private String writeTask;
    private final String filepath="Task.bin";
    private final String filepathFT = "FinishedTasks.bin";
    // Array of tasks
    ArrayList <Task> tasks = new ArrayList<>();
    ArrayList<Task> ftasks = new ArrayList<>();
    // Association
    FileMangerBinary fm = new FileMangerBinary();
    // Constructor
    public Task(){}
    public Task(String taskName,String ProjectName ,String description, int taskNo, int EmployeeID) {
        this.taskName = taskName;
        this.ProjectName = ProjectName;
        this.description = description;
        this.taskNo = taskNo;
        this.EmployeeID = EmployeeID;
    }
    // Setter
    public void setTaskName(String taskName) {
        this.taskName = taskName;
    }
    public void setProjName(String projectName) {
        this.ProjectName = projectName;
    }
    public void setDescription(String description) {
        this.description = description;
    }
    public void setTaskNo(int taskNo) {
        this.taskNo = taskNo;
    }
    public void setEmployeeID(int EmployeeID) {
        this.EmployeeID = EmployeeID;
    }
    public void setWriteTask(String writeTask) {
    	this.writeTask = writeTask;
    }
   /* public void setWriteTask(String writeTask) {
        this.writeTask = writeTask;
    }*/
    // Getter
    public String getTaskName() {
        return taskName;
    }
    public String getDescription() {
        return description;
    }
    public String getProjName() {
        return ProjectName;
    }
    public int getTaskNo() {
        return taskNo;
    }
    public int getEmployeeID() {
        return EmployeeID;
    }
    public String getWriteTask() {
    	return this.writeTask;
    }
    /*public String getWriteTask() {
        return writeTask;
    }*/
    // Add task in binaryFile by Leader   
    public boolean AddTask (){
        loadFromFile();
        tasks.add(this);
        return commitToFile();
    }
    public boolean commitToFile() {
        return fm.write(filepath, tasks);
    }
    public void loadFromFile() {
        tasks = (ArrayList<Task>) fm.read(filepath);
    }
    // Add finished Tasks in binary file by Employee
    public boolean AddFinishTask (){
        loadFromFile();
        tasks.add(this);
        return commitToFile();
    }
    public boolean commitToFTask() {
        return fm.write(filepathFT, tasks);
    }
    public void loadFromFTask() {
        ftasks = (ArrayList<Task>) fm.read(filepathFT);
    }
    // View all tasks for Leader    
    public ArrayList<Task> ViewCompletedTasks (String projName){
    	loadFromFTask();
    	ArrayList<Task> tsks = new ArrayList<>();
    	for(Task x : tasks) {
        	if (x.ProjectName.equals(projName)) {
        		tsks.add(x);
        	} 
    	}
    	return tsks;
    }
    // view required tasks from Employee
    public ArrayList<Task> ViewTasks (int empId) { 
    	loadFromFile();
        ArrayList<Task> tsks = new ArrayList<>(); 
        for (Task x : tasks) {
            if (x.getEmployeeID() == empId){
                tsks.add(x);
            }
        }
        return tsks;
    }
    // View Finished Tasks for Employee
    public ArrayList<Task> ViewFinishedTasks (int empId){ 
        loadFromFTask();
        ArrayList<Task> tsks = new ArrayList<>(); 
        for (Task x : tasks) {
            if (x.getEmployeeID() == empId){
                tsks.add(x);
            }
        }
        return tsks;
    }
    
    public double viewPrecentage(String projName){ // Aggregation
    	loadFromFTask();
        int TFtasks = 0;
        for(Task x : tasks) {
        	if (x.ProjectName.equals(projName)) {
        		TFtasks++;
        	}
        }
        Project proj = new Project();
        return  (proj.GetTotalTasks(projName)/TFtasks)*100;
    }
    public Object GetEmployeeTask(int TaskNum) {
    	loadFromFile();
    	for (Task x : tasks) {
    		if (x.getTaskNo() == TaskNum)
    			return x;
    	}
    	return null;
    }
    // End of Task
}
