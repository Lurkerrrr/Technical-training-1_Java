package database;

import model.Student;
import model.StudentGrade;
import model.StudentSubject;
import model.SubjectGrade;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class StudentDAO {

    public static List<Student> getAllStudents() {
        List<Student> students = new ArrayList<>();
        String sql = "SELECT * FROM Student";
        try (Connection conn = DatabaseConnection.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                students.add(new Student(
                    rs.getInt("id"),
                    rs.getString("imie"),
                    rs.getString("nazwisko"),
                    rs.getString("nr_albumu")
                ));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return students;
    }

    public static List<Student> getStudentsBySurnamePrefix(String prefix) {
        List<Student> students = new ArrayList<>();
        String sql = "SELECT * FROM Student WHERE nazwisko LIKE ?";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, prefix + "%");
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                students.add(new Student(
                    rs.getInt("id"),
                    rs.getString("imie"),
                    rs.getString("nazwisko"),
                    rs.getString("nr_albumu")
                ));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return students;
    }

    public static List<StudentGrade> getStudentGrades() {
        List<StudentGrade> list = new ArrayList<>();
        String sql = "SELECT s.id, s.imie, s.nazwisko, o.przedmiot, o.wartosc FROM Student s JOIN Ocena o ON s.id = o.id_studenta";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                list.add(new StudentGrade(
                    rs.getInt("id"),
                    rs.getString("imie"),
                    rs.getString("nazwisko"),
                    rs.getString("przedmiot"),
                    rs.getString("wartosc")
                ));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    public static List<StudentSubject> getStudentSubjects() {
        List<StudentSubject> list = new ArrayList<>();
        String sql = "SELECT DISTINCT s.imie, s.nazwisko, o.przedmiot FROM Student s JOIN Ocena o ON s.id = o.id_studenta";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                list.add(new StudentSubject(
                    rs.getString("imie"),
                    rs.getString("nazwisko"),
                    rs.getString("przedmiot")
                ));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    public static List<StudentGrade> getPassingStudentGrades() {
        List<StudentGrade> list = new ArrayList<>();
        String sql = "SELECT s.id, s.imie, s.nazwisko, o.przedmiot, o.wartosc FROM Student s JOIN Ocena o ON s.id = o.id_studenta WHERE TRY_CAST(o.wartosc AS FLOAT) > 2.0";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                list.add(new StudentGrade(
                    rs.getInt("id"),
                    rs.getString("imie"),
                    rs.getString("nazwisko"),
                    rs.getString("przedmiot"),
                    rs.getString("wartosc")
                ));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    public static List<SubjectGrade> getGradesForStudent(int studentId) {
        List<SubjectGrade> list = new ArrayList<>();
        String sql = "SELECT przedmiot, wartosc FROM Ocena WHERE id_studenta = ?";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, studentId);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                list.add(new SubjectGrade(
                    rs.getString("przedmiot"),
                    rs.getString("wartosc")
                ));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }
}
