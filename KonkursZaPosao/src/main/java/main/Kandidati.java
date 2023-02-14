package main;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Kandidati {
    ArrayList<Kandidat> listaKandidata = new ArrayList<>();

    public ArrayList<Kandidat> getListaKandidata() {
        return listaKandidata;
    }

    public boolean poredjenje(String ime, String prezime, int godine) {
        boolean poredjenjeKandidata = true;
        for (int i = 0; i < listaKandidata.size(); i++) {
            if (listaKandidata.get(i).getIme().equals(ime) && listaKandidata.get(i).getPrezime().equals(prezime) && listaKandidata.get(i).getGodine() == godine) {
                poredjenjeKandidata = false;
            }
        }
        return poredjenjeKandidata;
    }

    public void sortiranjeKandidata() {
        for (int i = 0; i < listaKandidata.size() - 1; i++) {
            for (int j = 0; j < listaKandidata.size() - i - 1; j++) {
                if (listaKandidata.get(j).getGodine() > listaKandidata.get(j + 1).getGodine()) {
                    Kandidat privremena = listaKandidata.get(j);
                    listaKandidata.set(j, listaKandidata.get(j + 1));
                    listaKandidata.set(j + 1, privremena);
                }
            }
        }
        for (Kandidat kandidat : listaKandidata) {
            System.out.println(kandidat.getIme() + " " + kandidat.getPrezime() + " " + kandidat.getGodine());
        }
    }

    public void saveToFile(String fileName, String text, boolean append) throws IOException {
        File file = new File(fileName);
        FileWriter fw = new FileWriter(file, append);
        PrintWriter pw = new PrintWriter(fw);
        pw.println(text);
        pw.close();
    }

    public void kreiranjeDokumenta() {
        for (int i = 0; i < listaKandidata.size(); i++) {
            String outputText = listaKandidata.get(i).getIme() + " " + listaKandidata.get(i).getPrezime() + " " +
                    listaKandidata.get(i).getGodine();
            try {
                saveToFile("ListaUnetihKandidata.txt", outputText, true);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public void citanjeDokumenta() throws IOException{
        File postojeciFile = new File("ListaUnetihKandidata.txt");
        Scanner citanje = new Scanner(postojeciFile);

        StringTokenizer token = null;

        String staroIme = "";
        String staroPrezime = "";
        int stareGodine = 0;

       while(citanje.hasNextLine()) {
           token = new StringTokenizer(citanje.nextLine(), " ");

           staroIme = token.nextToken();
           staroPrezime = token.nextToken();
           stareGodine = Integer.parseInt(token.nextToken());

           Kandidat kandidat = new Kandidat(staroIme, staroPrezime,stareGodine);
           listaKandidata.add(kandidat);
       }

    }
}

