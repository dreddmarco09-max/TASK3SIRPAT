import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class Repository {
    private final String URL = "jdbc:sqlserver://LAPTOP-I6GCH1M5;databaseName=StudentSystem;integratedSecurity=true;encrypt=true;trustServerCertificate=true;";

    public void addStudent(Student s) {
        String sql = "INSERT INTO students (firstName, lastName, middleName, gender, age, course, yearLevel, address, contactNumber) VALUES (?,?,?,?,?,?,?,?,?)";
        try (Connection conn = DriverManager.getConnection(URL); 
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, s.getFirstName());
            pstmt.setString(2, s.getLastName());
            pstmt.setString(3, s.getMiddleName());
            pstmt.setString(4, s.getGender());
            pstmt.setInt(5, s.getAge());
            pstmt.setString(6, s.getCourse());
            pstmt.setInt(7, s.getYearLevel());
            pstmt.setString(8, s.getAddress());
            pstmt.setInt(9, s.getContactNumber());
            pstmt.executeUpdate();
            System.out.println("Registration successful!");
        } catch (SQLException e) {
            System.out.println("Save Error: " + e.getMessage());
        }
    }

    public List<Student> getAllStudents() {
        List<Student> students = new ArrayList<>();
        String sql = "SELECT * FROM students";
        try (Connection conn = DriverManager.getConnection(URL); 
             Statement stmt = conn.createStatement(); 
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                students.add(new Student.Builder()
                    .setStudentID(rs.getInt("studentID"))
                    .setFirstName(rs.getString("firstName"))
                    .setLastName(rs.getString("lastName"))
                    .setMiddleName(rs.getString("middleName"))
                    .setGender(rs.getString("gender"))
                    .setAge(rs.getInt("age"))
                    .setCourse(rs.getString("course"))
                    .setYearLevel(rs.getInt("yearLevel"))
                    .setAddress(rs.getString("address"))
                    .setContactNumber(rs.getInt("contactNumber"))
                    .build());
            }
        } catch (SQLException e) {
            System.out.println("Fetch Error: " + e.getMessage());
        }
        return students;
    }
}



