package controller;

import database.StudentDAO;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import model.Student;

public class MainController {

    @FXML private TextField filterField;
    @FXML private TableView<Student> studentTable;
    @FXML private TableColumn<Student, String> firstNameColumn;
    @FXML private TableColumn<Student, String> lastNameColumn;
    @FXML private TableColumn<Student, String> albumNumberColumn;

    private ObservableList<Student> studentList = FXCollections.observableArrayList();

    @FXML
    public void initialize() {
        firstNameColumn.setCellValueFactory(data -> new javafx.beans.property.SimpleStringProperty(data.getValue().getImie()));
        lastNameColumn.setCellValueFactory(data -> new javafx.beans.property.SimpleStringProperty(data.getValue().getNazwisko()));
        albumNumberColumn.setCellValueFactory(data -> new javafx.beans.property.SimpleStringProperty(data.getValue().getNrAlbumu()));

        loadAllStudents();
    }

    @FXML
    public void onFilter() {
        String filter = filterField.getText().trim();
        if (!filter.isEmpty()) {
            studentList.setAll(StudentDAO.getStudentsBySurnamePrefix(filter));
        } else {
            loadAllStudents();
        }
    }

    @FXML
    public void onRefresh() {
        filterField.clear();
        loadAllStudents();
    }

    private void loadAllStudents() {
        studentList.setAll(StudentDAO.getAllStudents());
        studentTable.setItems(studentList);
    }
}
