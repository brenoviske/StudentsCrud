package dao;

import model.Student;
import Config.Database;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class StudentDAO {


    // ----- DAO METHODS ----- //


    // ------ Add Student ------ //
    public static void insertStudent(Student student){
        String sql = "INSERT INTO classmates (email , name , age) VALUES (?, ?, ?)";

        try (Connection connection = Database.getConnection();
             PreparedStatement stmt = connection.prepareStatement(sql)) {

            stmt.setString(1, student.getEmail());
            stmt.setString(2, student.getName());
            stmt.setInt(3, student.getAge());

            stmt.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // ------- Delete Method ------- //
    public static void deleteStudent(String email){
        String sql = "DELETE FROM classmates WHERE email = ?";

        try ( Connection connection = Database.getConnection();
              PreparedStatement stmt = connection.prepareStatement(sql)){

            stmt.setString(1,email);
            stmt.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // ------ Update method ------ //
    public static void updateStudent(Student student){
        String sql = "UPDATE classmates SET name = ?, age = ? WHERE email = ?";

        try ( Connection connection = Database.getConnection();
              PreparedStatement stmt = connection.prepareStatement(sql)){

            stmt.setString(1, student.getName());
            stmt.setInt(2, student.getAge());
            stmt.setString(3, student.getEmail());

            stmt.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // ----- Find by ID the student ----- //

    public static boolean getStudent(String email){
        String sql = "SELECT * FROM classmates WHERE email = ?";

        try( Connection connection = Database.getConnection();
             PreparedStatement stmt = connection.prepareStatement(sql)){

            stmt.setString(1,email);

            try ( ResultSet rs = stmt.executeQuery()){
                return rs.next();
            }
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    // -------- Getting all Students ------ //

    public static List<String> getAllStudents(){
        String sql = "SELECT * FROM classmates";

        List<String> students = new ArrayList<>();

        try( Connection connection = Database.getConnection();
             PreparedStatement stmt = connection.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()){

            while(rs.next()){
                String name = rs.getString("name");

                students.add(name);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return students;
    }
}