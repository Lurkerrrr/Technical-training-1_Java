package models;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Osoba {
    private final SimpleStringProperty imie;
    private final SimpleStringProperty nazwisko;

    public Osoba(String imie, String nazwisko) {
        this.imie = new SimpleStringProperty(imie);
        this.nazwisko = new SimpleStringProperty(nazwisko);
    }

    public String getImie() {
        return imie.get();
    }

    public void setImie(String imie) {
        this.imie.set(imie);
    }

    public StringProperty imieProperty() {  // Missing method added
        return imie;
    }

    public String getNazwisko() {
        return nazwisko.get();
    }

    public void setNazwisko(String nazwisko) {
        this.nazwisko.set(nazwisko);
    }

    public StringProperty nazwiskoProperty() {  // Missing method added
        return nazwisko;
    }
}

