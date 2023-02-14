package main;
import java.io.IOException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws IOException {

        Kandidati kandidati = new Kandidati();

        kandidati.citanjeDokumenta();
        for(Kandidat kandidat: kandidati.listaKandidata){
            System.out.println(kandidat);
        }

        String komanda = "";

        while (!komanda.equals("Prekid")) {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Unesite 'Dodaj' za unos novog kandidata,'Prekid' za prekid unosa kandidata, 'Sortiraj' " +
                    "za sortiranje liste ili 'Kreiraj' za kreiranje txt datoteke sa unetim kandidatima:");
            komanda = scanner.next();
            if (komanda.equals("Dodaj")) {
                System.out.println("Unesite Ime, Prezime i godine kandidata: ");
                String unetoIme = scanner.next();
                String unetoPrezime = scanner.next();
                int uneteGodine = scanner.nextInt();
                if (!kandidati.poredjenje(unetoIme, unetoPrezime, uneteGodine)) {
                    System.out.println("Kandidat vec postoji u bazi!");
                } else {
                    kandidati.getListaKandidata().add(new Kandidat(unetoIme, unetoPrezime, uneteGodine));
                }
            }

            if (komanda.equals("Sortiraj")) {
                kandidati.sortiranjeKandidata();
            }
            if (komanda.equals("Kreiraj")) {
                kandidati.kreiranjeDokumenta();
            }
        }
        System.out.println(kandidati.getListaKandidata());
    }
}
