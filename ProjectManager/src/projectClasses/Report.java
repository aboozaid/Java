package projectClasses;

import java.io.Serializable;
import java.util.ArrayList;

public class Report implements Serializable {
    // Atribute
    private String reportCause;
    private int employeeID;
    final private String filepath = "Report.bin";
    // Array Of Reports
    public static ArrayList<Report> reports = new ArrayList<>();
    // Association with FileMangerBinary
    FileMangerBinary fm = new FileMangerBinary();
    // firstContractor
    public Report (){}
    // FullContractor
    public Report (String reportCause,int employeeID){
        this.reportCause=reportCause;
        this.employeeID=employeeID;
    }
    // Setter 
    public void setRCause(String reportCause){
        this.reportCause = reportCause;
    } 
    public void setEmpID (int employeeID){
        this.employeeID = employeeID;
    }
    // Getter
    public String getRCause(){
        return this.reportCause;
    }
    public int getEmpID (){
        return this.employeeID;
    }
    // Add report in binaryFile 
    public boolean addReport() {
        loadFromFile();
        reports.add(this);
        return commitToFile();
    }
    public boolean commitToFile() {
        return fm.write(filepath, reports);
    }
    public void loadFromFile() {
        reports = (ArrayList<Report>) fm.read(filepath);
    }
    // Delete Report by index
    private int getReportndex(int id) {
        for (int i = 0; i < reports.size(); i++) {
            if (reports.get(i).employeeID == id) {
                return i;
            }
        }

        return -1;
    }
    public boolean deleteReport(int id) {
        loadFromFile();
        int index = getReportndex(id);

        if (index != -1) {
            reports.remove(index);

            return commitToFile();
        }

        return false;
    }
    public ArrayList<Report> getReports() {
    	loadFromFile();
    	return reports;
    }
    // End of Report 
}
