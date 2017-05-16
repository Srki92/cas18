package rs.aleph.android.example12.activities.provider;

import java.util.ArrayList;
import java.util.List;

import rs.aleph.android.example12.activities.model.Kategorija;

/**
 * Created by androiddevelopment on 11.5.17..
 */

public class KategorijaProvider {

    public static List<Kategorija> getKategorije() {

        List<Kategorija> kategorije = new ArrayList<>();
        kategorije.add(new Kategorija (0, "Piletina"));
        kategorije.add(new Kategorija (1, "Krofne"));
        kategorije.add(new Kategorija (2, "Spagete"));
        return kategorije;
    }

    public static List<String> getKategorijaNaziv() {
        List<String> names = new ArrayList<>();
        names.add("Piletina");
        names.add("Krofne");
        names.add("Spagete");
        return names;
    }

    public static Kategorija getKategorijaById(int id) {
        switch (id) {
            case 0:
                return new Kategorija(0, "Piletina");
            case 1:
                return new Kategorija(1, "Krofne");
            case 2:
                return new Kategorija(2, "Spagete");
            default:
                return null;
        }
    }
}
