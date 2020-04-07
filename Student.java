package model;

public class Student {
    private String id, name, address, phone;
    public Student(String id, String name, String address, String phone){
        this.id=id;
        this.name=name;
        this.address=address;
        this.phone=phone;
    }
    public String getAddress() {
        return address;
    }
    public String getId() {
        return id;
    }
    public String getPhone() {
        return phone;
    }
    public String getName() {
        return name;
    }
    public static Student addSudent(String id, String name, String address, String phone){
        return new  Student(id,name,address,phone);
    }
}
