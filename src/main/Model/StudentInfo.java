package model;

public class StudentInfo {
    private String name;
    private String id;


    public StudentInfo(String name,String id) {
        super();
        this.id = id;
        this.name = name;
    }

    //EFFECTS: get/return id
    public String getIdnum() {
        return id;
    }

    //EFFECTS: get/return name
    public String getName() {
        return name;
    }

}
