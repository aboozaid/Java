package projectClasses;

import java.io.Serializable;
import java.util.ArrayList;

public class Vacation implements Serializable {
    // Atribute
    private int employeeId , SD , SM , SY , ED , EM , EY;
    String Reason;
    static MyException MyEX = new MyException("TEAM");
    FileMangerBinary fm = new FileMangerBinary();
    ArrayList<Vacation> Vacs = new ArrayList<>();
    public ArrayList<Vacation> ReqVac = new ArrayList<>();
    static String fileName = "Vacation.bin";
    static String fileName2 = "RequestVacation.bin";
    // Constructor
    public Vacation(){}
    public Vacation(int employeeId, int SD, int SM, int SY, int ED, int EM, int EY, String Reason) {
        this.employeeId = employeeId;
        this.Reason = Reason;
        if(SD < 0 || SD > 30){
            this.SD = MyEX.checkDay("day");
        }
        else{
            this.SD = SD;
        }
        
        if(SM < 0 || SM > 12){
            this.SM = MyEX.checkMonth("month");
        }
        else{
            this.SM = SM;
        }
        
        if(SY < 2017 ){
            this.SY = MyEX.checYear("year");
        }
        else{ 
            this.SY = SY;
        }
        
        if(ED < 0 || ED > 30){
            this.ED = MyEX.checkDay("day");
        }
        else{      
            this.ED = ED;
        }
        
        if(EM < 0 || EM > 12){ 
            this.EM = MyEX.checkMonth("month");    
        }
        else{
            this.EM = EM;
        }
        
        if(EY < this.EY){
            this.EY = MyEX.checYear("year");
        }
        else{
            this.EY = EY; 
        }
    }
    // Setter
    public void setEmployeeId(int employeeId) {
        this.employeeId = employeeId;
    }
    public void setSD(int SD) {
        this.SD = SD;
    }
    public void setSM(int SM) {
        this.SM = SM;
    }
    public void setSY(int SY) {
        this.SY = SY;
    }
    public void setED(int ED) {
        this.ED = ED;
    }
    public void setEM(int EM) {
        this.EM = EM;
    }
    public void setEY(int EY) {
        this.EY = EY;
    }
    public void setReason(String Reason) {
        this.Reason = Reason;
    }
    // Getter
    public int getEmployeeId() {
        return employeeId;
    }
    public int getSD() {
        return SD;
    }
    public int getSM() {
        return SM;
    }
    public int getSY() {
        return SY;
    }
    public int getED() {
        return ED;
    }
    public int getEM() {
        return EM;
    }
    public int getEY() {
        return EY;
    }
    public String getReason() {
        return this.Reason;
    }
    // Add Vac in binaryFile
    public boolean addVacation() {
        loadFromFile();
        Vacs.add(this);
        return commitToFile();
    }
    public boolean addRequestVacation() {
    	loadFromRequestFile();
    	ReqVac.add(this);
        return commitToRequestFile();
    }
    public boolean commitToFile() {
        return fm.write(fileName, Vacs);
    }
    public boolean commitToRequestFile() {
        return fm.write(fileName2, ReqVac);
    }
    public void loadFromFile() {
        Vacs = (ArrayList<Vacation>) fm.read(fileName);
    }
    public void loadFromRequestFile() {
    	ReqVac = (ArrayList<Vacation>) fm.read(fileName2);
    }
    // End of Vacation
}
    