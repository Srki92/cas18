package rs.aleph.android.example12.activities.provider;

import java.util.ArrayList;
import java.util.List;

import rs.aleph.android.example12.activities.model.Jelo;
import rs.aleph.android.example12.activities.model.Kategorija;

/**
 * Created by androiddevelopment on 13.5.17..
 */

public class JeloProvider {


    public static List<Jelo> getJela() {

        Kategorija piletina = new Kategorija(0, "Piletina");
        Kategorija krofne = new Kategorija(1, "Krofne");
        Kategorija spagete = new Kategorija(2, "Spagete");


        List<Jelo> jela = new ArrayList<>();
        jela.add (new Jelo(0,"piletina.jpg",  "Piletina" , "pileca piletina od mladog pileta" , 600f , 700f  ,piletina));
        jela.add (new Jelo(1,"krofne.jpeg" , "Krofne" , "okrugle krofne sa rupom" , 800f , 120f , krofne));
        jela.add (new Jelo(2,"spagete.jpg" , "Spagete" , "duga kao pertla" , 1200f , 300f , spagete));
        return jela;
    }

    public static List<String> getJeloNaziv() {

        List<String> nazivi = new ArrayList<>();
        nazivi.add("Piletina");
        nazivi.add("Krofne");
        nazivi.add("Spagete");
        return nazivi;
    }

    public static Jelo getJeloById(int id) {

        Kategorija piletina = new Kategorija (0, "Piletina");
        Kategorija krofne = new Kategorija (1, "Krofne");
        Kategorija spagete = new Kategorija(2, "Spagete");

        switch (id) {
            case 0:
                return new Jelo(0, "piletina.jpg",  "Piletina" , "pileca piletina od mladog pileta" , 600f , 700f  ,piletina);
            case 1:
                return new Jelo(1, "krofne.jpeg" , "Krofne" , "okrugle krofne sa rupom" , 800f , 120f , krofne);
            case 2:
                return new Jelo(2, "spagete.jpg" , "Spagete" , "duga kao pertla" , 1200f , 300f , spagete);
            default:
                return null;
        }
    }
}
