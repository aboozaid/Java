package projectClasses;

import java.io.Serializable;

public abstract class Person implements Ilogin, Serializable {
    // Atribute
    protected int id;
    protected String password;
    protected String name;
    protected String position;
    protected int age;
    // Association with MyException
    MyException MyEX = new MyException("TEAM");
    // firstConstractor
    public Person() {}
    // secondConstractor
    public Person(int id,String password, String name, String position, int age) {
        if (id < 0) {
            this.id = MyEX.checkPositive("ID");
        } else {
            this.id = id;
        }
        
        	this.name = name;

        if (age < 0) {
            this.age = MyEX.checkPositive("Age");
        } else {
            this.age = age;
        }

        if (password.length() < 8) {
            this.password = MyEX.checkPassLength("Password");
        } else {
            this.password = password;
        }
        
        this.position = position;
    }
    // abstract method
    @Override
    public abstract String toString();
    // Setter
    public void setId(int id) {
        this.id = id;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    public void setName(String name) {
        this.name = name;
    }
    public void setPosition(String position) {
        this.position = position;
    }
    public void setAge(int age) {
        this.age = age;
    }
    // Getter
    public int getId() {
        return id;
    }
    public String getPassword() {
        return password;
    }
    public String getName() {
        return name;
    }
    public String getPosition() {
        return position;
    }
    public int getAge() {
        return age;
    }
    // End of Person
}
