package rs.aleph.android.example12.activities.model;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by androiddevelopment on 9.5.17..
 */

public class Sastojci {

    private int id;
    private String naziv;
    private List<Jelo> jela;


    public Sastojci(){

        jela = new ArrayList<>();

    }

    public Sastojci(int id,String naziv){

        this.id = id;
        this.naziv = naziv;
        jela = new ArrayList<>();

    }

    public int getId() {return id;}
    public String getNaziv(){return naziv;}
    public List<Jelo> getJela(){return jela;}

    public void setId(int id){this.id = id;}
    public void setNaziv(String naziv){this.naziv = naziv;}
    public void setJela(List<Jelo> jela) {this.jela = jela;}

    @Override
    public String toString() {
        return "Sastojci{" +
                "id=" + id +
                ", naziv='" + naziv + '\'' +
                ", jela=" + jela +
                '}';
    }
}
