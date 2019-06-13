package org.hillel.homework.serialization;

public class StudentFromDSU extends Student{

    private String name;

    private String faculty;

    private int age;

    private transient int id;

    public StudentFromDSU() {
        System.out.println("This is default StudentFromDSU constructor");
    }

    public StudentFromDSU(String name, String faculty, int age, int id) {
        System.out.println("No default constructor was called!");
        this.name = name;
        this.faculty = faculty;
        this.age = age;
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFaculty() {
        return faculty;
    }

    public void setFaculty(String faculty) {
        this.faculty = faculty;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "StudentFromDSU{" +
                "name='" + name + '\'' +
                ", faculty='" + faculty + '\'' +
                ", age=" + age +
                ", id=" + id +
                '}' + " StudentParent{ " +
                "rating= '" + rating + '\'' +
                '}';
    }
}
