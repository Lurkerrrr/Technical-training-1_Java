package zadaniajava.lab9;

public class Osoba {
    public String imie;
    public String nazwisko;
    public int rokUrodzenia;

    public Osoba(String imie, String nazwisko, int rokUrodzenia) {
        this.imie = imie;
        this.nazwisko = nazwisko;
        this.rokUrodzenia = rokUrodzenia;
    }

    @Override
    public String toString() {
        return imie + " " + nazwisko + " (" + rokUrodzenia + ")";
    }
}
