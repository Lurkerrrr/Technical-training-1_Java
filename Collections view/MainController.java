// MainController.java (Controller class)
package controllers;

import javafx.collections.FXCollections;
import javafx.collections.ListChangeListener;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import models.Osoba;

public class MainController {
    @FXML private TableView<Osoba> tabela;
    @FXML private TableColumn<Osoba, String> colImie;
    @FXML private TableColumn<Osoba, String> colNazwisko;
    @FXML private TextField txtImie;
    @FXML private TextField txtNazwisko;
    @FXML private Button btnDodaj;

    private final ObservableList<Osoba> listaOsob = FXCollections.observableArrayList();

    @FXML
    public void initialize() {
        colImie.setCellValueFactory(cellData -> cellData.getValue().imieProperty());
        colNazwisko.setCellValueFactory(cellData -> cellData.getValue().nazwiskoProperty());

        tabela.setItems(listaOsob);
        listaOsob.add(new Osoba("Jan", "Kowalski"));
        listaOsob.add(new Osoba("Anna", "Nowak"));

        TableView.TableViewSelectionModel<Osoba> selectionModel = tabela.getSelectionModel();
        selectionModel.setSelectionMode(SelectionMode.SINGLE);
        ObservableList<Osoba> selectedItems = selectionModel.getSelectedItems();

        selectedItems.addListener((ListChangeListener<Osoba>) change -> {
            if (!change.getList().isEmpty()) {
                Osoba os = change.getList().get(0);
                txtImie.setText(os.getImie());
                txtNazwisko.setText(os.getNazwisko());
            }
        });
    }

    @FXML
    private void handleDodaj() {
        String imie = txtImie.getText();
        String nazwisko = txtNazwisko.getText();
        if (!imie.isEmpty() && !nazwisko.isEmpty()) {
            listaOsob.add(new Osoba(imie, nazwisko));
            txtImie.clear();
            txtNazwisko.clear();
        }
    }
}
