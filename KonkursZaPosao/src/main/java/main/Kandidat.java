package main;

public class
Kandidat{
    String ime;
    String prezime;
    int godine;

    public Kandidat(String ime, String prezime, int godine) {
        this.ime = ime;
        this.prezime = prezime;
        this.godine = godine;
    }

    public String getIme() {
        return ime;
    }

    public void setIme(String ime) {
        this.ime = ime;
    }

    public String getPrezime() {
        return prezime;
    }

    public void setPrezime(String prezime) {
        this.prezime = prezime;
    }

    public int getGodine() {
        return godine;
    }

    public void setGodine(int godine) {
        this.godine = godine;
    }


    @Override
    public String toString() {
        return "Kandidat{" +
                "ime='" + ime + '\'' +
                ", prezime='" + prezime + '\'' +
                ", godine=" + godine +
                '}';
    }
}
