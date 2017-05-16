package rs.aleph.android.example12.activities.model;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by androiddevelopment on 9.5.17..
 */

public class Kategorija {

    private int id;
    private String naziv;
    private List<Jelo> jela;



    public Kategorija() {

        jela = new ArrayList<>();
    }

    public Kategorija(int id,String naziv){

        this.id = id;
        this.naziv = naziv;
        jela = new ArrayList<>();
    }

    public int getId(){return id;}
    public String getNaziv() {return naziv;}
    public List<Jelo> getJela(){return jela;}


    public void setId(int id){this.id = id;}
    public void setNaziv(String naziv){this.naziv = naziv;}
    public void setJela(List<Jelo> jela) {this.jela = jela;}

    public Jelo getJela(int position) {return jela.get(position);}


    @Override
    public String toString() {
        return "Kategorija{" +
                "id=" + id +
                ", naziv='" + naziv + '\'' +
                ", jela=" + jela +
                '}';
    }
}
