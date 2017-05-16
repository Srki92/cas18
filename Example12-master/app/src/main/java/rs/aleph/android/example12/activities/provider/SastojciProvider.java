package rs.aleph.android.example12.activities.provider;

import java.util.ArrayList;
import java.util.List;

import rs.aleph.android.example12.activities.model.Kategorija;
import rs.aleph.android.example12.activities.model.Sastojci;

/**
 * Created by androiddevelopment on 11.5.17..
 */

public class SastojciProvider {

    public static List<Sastojci> getSastojci() {

    Kategorija piletina = new Kategorija(0, "Piletina");
    Kategorija krofne = new Kategorija(1, "Krofne");
    Kategorija spagete = new Kategorija(2, "Spagete");


    List<Sastojci> sastojci = new ArrayList<>();
    sastojci.add (new Sastojci(0,"pile,krompir,povrce"));
    sastojci.add (new Sastojci(1,"testo,brasno,secer"));
    sastojci.add (new Sastojci(2,"testo,sir"));
        return sastojci;
    }

    public static List<String> getSastojciNaziv() {

        List<String> nazivi = new ArrayList<>();
        nazivi.add("Piletina");
        nazivi.add("Krofne");
        nazivi.add("Spagete");
        return nazivi;
    }

    public static Sastojci getSastojciById(int id) {

        Sastojci piletina = new Sastojci(0, "Piletina");
        Sastojci krofne = new Sastojci(1, "Krofne");
        Sastojci spagete = new Sastojci(2, "Spagete");

        switch (id) {
            case 0:
                return new Sastojci(0, "pile,krompir,povrce");
            case 1:
                return new Sastojci(1,"testo,brasno,secer");
            case 2:
                return new Sastojci(2, "testo,sir");
            default:
                return null;
        }
    }
}
