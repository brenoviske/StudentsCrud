package controller;

import dao.StudentDAO;
import model.Student;

import java.sql.SQLException;
import java.util.List;

public class StudentController {

    public static boolean addStudent(Student student) throws SQLException {
        StudentDAO.insertStudent(student);
        return true;
    }

    public static boolean deleteStudent(String email ) throws SQLException {
        StudentDAO.deleteStudent(email);
        return true;

    }

    public static boolean updateStudent(Student student) throws SQLException {
        StudentDAO.updateStudent(student);
        return true;
    }

    public static boolean getStudent(String email) {
        try{
            return StudentDAO.getStudent(email);
        } catch(Exception e){
            e.printStackTrace();
            return false;
        }
    }

    public static List<String> getAllStudents() throws SQLException {
        return StudentDAO.getAllStudents();
    }


}