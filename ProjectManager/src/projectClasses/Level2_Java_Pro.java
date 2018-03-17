package projectClasses;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;
import GUI.LoginPanel;

public class Level2_Java_Pro {



    public static void main(String[] args) {

        String projectPath = System.getProperty("user.dir");
        System.out.println("Project Path: " + projectPath);
        File currentDir = new File(projectPath); // current directory				
        checkDirectoryContents(currentDir);

        new LoginPanel().LoginFram.setVisible(true);
    }

    public static void checkDirectoryContents(File dir) {
        File[] files = dir.listFiles();
        boolean employeeFile = true;
        boolean PMFile = true;
        boolean LeaderFile = true;
        boolean TaskFile = true;
        boolean FtaskFile = true;
        boolean PenalitiesFile = true;
        boolean ProjectFile = true;
        boolean VacationFile = true;
        boolean RequestVacation = true;
        boolean Report = true;
        
        for (File file : files) {

            if (file.getName().contains("Employee.bin")) {
            	employeeFile = false;
            } else if (file.getName().contains("PM.bin")) {
            	PMFile = false;
            } else if (file.getName().contains("Leader.bin")) {
            	LeaderFile = false;
            } else if (file.getName().contains("Task.bin")) {
            	TaskFile = false;
            } else if (file.getName().contains("FinishedTasks.bin")) {
            	FtaskFile = false;
            }
            else if (file.getName().contains("Penalities.bin")) {
            	PenalitiesFile = false;
            }
            else if (file.getName().contains("ProjectName.bin")) {
            	ProjectFile = false;
            }
            else if (file.getName().contains("Vacation.bin")) {
            	VacationFile = false;
            }
            else if (file.getName().contains("RequestVacation.bin")) {
            	RequestVacation = false;
            }
            else if (file.getName().contains("Report.bin")) {
            	Report = false;
            }
        }
        if (employeeFile) {
            Employee x = new Employee();
            x.commitToFile();
        }

        if (PMFile) {
            ProjectManger x = new ProjectManger();
            x.commitToFile();
        }

        if (LeaderFile) {
            Leader x = new Leader();
            x.commitToFile();
        }

        if (TaskFile) {
            Task x = new Task();
            x.commitToFile();
        }

        if (FtaskFile) {
            Task x = new Task();
            x.commitToFTask();
        }
        
        if(PenalitiesFile) {
        	Penalities x = new Penalities();
        	x.commitToFile();
        }
        
        if (ProjectFile) {
            Project x = new Project();
            x.commitToFile();
        }
        
        if (VacationFile) {
        	Vacation x = new Vacation();
            x.commitToFile();
        }

        if (RequestVacation) {
        	Vacation x = new Vacation();
            x.commitToRequestFile();
        }
        
        if (Report) {
        	Report x = new Report();
            x.commitToFile();
        }
    }

}
