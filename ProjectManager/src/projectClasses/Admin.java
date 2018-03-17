package projectClasses;

public class Admin extends Person {
    // firstConstractor
	int x;
    public Admin() {}
    // fullConstractor
    public Admin(String position, String pass, int id, String name, int age) {
        super(id, pass, name, position, age);
    }
    // toString
    @Override
    public String toString() {
        return "I'm Manager : " + name + "\n" + "ID : " + id + " Age : " + age + "\n" + "\t Password: " + password + "\n";
    }
    // Login
    @Override
    public boolean login(int id, String Pass) {
        return (id == 100000 && Pass.equals("A@123456"));
    }
    // End of Admin
}
