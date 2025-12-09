package model;

public class Student {

    private String email;
    private String name;
    private int age;


    public Student(String email, String name, int age) {
        this.name = name;
        this.age = age;
        this.email = email;
    }

    // ------- Setting and Getting methods ----- //

    public String getName(){
        return name;
    }

    public int getAge(){
        return age;
    }

    public String getEmail(){
        return email;
    }

    public void setName(String name){
        this.name = name;
    }

    public void setAge(int age){
        this.age = age;
    }

    public void setEmail(String email){
        this.email = email;
    }

    public void info(){
        System.out.println("Name: " + this.name);
        System.out.println("Age: " + this.age);
        System.out.println("Email: " + this.email);
    }
}