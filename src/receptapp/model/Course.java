package receptapp.model;

public class Course {
    private int ID;
    private String name;

    public Course() {};

    public Course(String name) {
        this.name = name;
    }

    public Course(int ID, String name) {
        this.ID = ID;
        this.name = name;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Course: [ID: " + this.ID + "] " + this.name;
    }
}