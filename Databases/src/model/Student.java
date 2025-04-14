package model;

public class Student {
    private int id;
    private String imie;
    private String nazwisko;
    private String nrAlbumu;

    public Student(int id, String imie, String nazwisko, String nrAlbumu) {
        this.id = id;
        this.imie = imie;
        this.nazwisko = nazwisko;
        this.nrAlbumu = nrAlbumu;
    }

    public int getId() { return id; }
    public String getImie() { return imie; }
    public String getNazwisko() { return nazwisko; }
    public String getNrAlbumu() { return nrAlbumu; }

    @Override
    public String toString() {
        return imie + " " + nazwisko + " (" + nrAlbumu + ")";
    }
}
