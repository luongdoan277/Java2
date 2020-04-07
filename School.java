package controller;
import model.Student;

import java.sql.*;
import java.util.ArrayList;

public class School {
    private ArrayList<Student> myStudent;
    public School(String id, String name, String address, String phone){
        this.myStudent=new ArrayList<Student>();
    }
    public boolean addNewStudent(Student student){
        if (findStudent(student.getName())>=0){
            System.out.println("Student is already on file");
            return false;
        }
        myStudent.add(student);
        return true;
    }
    private int findStudent(String StudentName){
        for(int i=0; i<this.myStudent.size();i++){
            Student student = this.myStudent.get(i);
            if (student.getName().equals(StudentName)){
                return i;
            }
        }
        return -1;
    }
    public void printStudent(){
        try(
                Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/adf2?allowPublicKeyRetrieval=true&useSSL=false&serverTimezone=UTC", "root", "");
                Statement stmt = conn.createStatement();
        ) {
            ResultSet rset = stmt.executeQuery("select * from student");
            ResultSetMetaData rsetMD = rset.getMetaData();
            // Get the number of column from metadata
            int numColumns = rsetMD.getColumnCount();
            // Print column names - Column Index begins at 1 (instead of 0)
            for (int i = 1; i <= numColumns; ++i) {
                System.out.printf("%-30s",rsetMD.getColumnName(i));
            }
            System.out.println();
            // Print column contents for all the rows
            while (rset.next()) {
                for (int i = 1; i <= numColumns; ++i) {
                    // getString() can be used for all column types
                    System.out.printf("%-30s",rset.getString(i));
                }
                System.out.println();
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void saveStudent(){
        try(
                Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/adf2?allowPublicKeyRetrieval=true&useSSL=false&serverTimezone=UTC", "root", "");
                PreparedStatement pstmt = conn.prepareStatement("insert into student values (?, ?, ?, ?)");
        ) {
            for (int i=0; i<this.myStudent.size();i++){
                pstmt.setString(1, myStudent.get(i).getId());  // Set values for parameters 1 to 5
                pstmt.setString(2, myStudent.get(i).getName());
                pstmt.setString(3, myStudent.get(i).getAddress());
                pstmt.setString(4, myStudent.get(i).getPhone());
                pstmt.addBatch();
                pstmt.executeUpdate();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
