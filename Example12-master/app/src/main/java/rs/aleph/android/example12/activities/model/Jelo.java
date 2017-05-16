package rs.aleph.android.example12.activities.model;

/**
 * Created by androiddevelopment on 9.5.17..
 */

public class Jelo {

    private int id;
    private String slika;
    private String naziv;
    private String opis;
    private float kalorijskaVrednost;
    private float cena;
    private Kategorija kategorija;


    public Jelo(){

    }

    public Jelo(int id,String slika,String naziv,String opis,float kalorijskaVrednost,float cena,Kategorija kategorija){

        this.id=id;
        this.slika=slika;
        this.naziv=naziv;
        this.opis=opis;
        this.kalorijskaVrednost=kalorijskaVrednost;
        this.cena=cena;
        this.kategorija=kategorija;

    }

    public int getId(){return id;}
    public String getSlika(){return slika;}
    public String getNaziv(){return naziv;}
    public String getOpis(){return opis;}
    public float getKalorijskaVrednost(){return kalorijskaVrednost;}
    public float getCena(){return cena;}
    public Kategorija getKategorija() {return kategorija;}

    public void setId(int id){this.id = id;}
    public void setSlika(String slika){this.slika = slika;}
    public void setNaziv(String naziv){this.naziv = naziv;}
    public void setOpis(String opis){this.opis = opis;}
    public void setKalorijskaVrednost(float kalorijskaVrednost){this.kalorijskaVrednost = kalorijskaVrednost;}
    public void setCena(float cena){this.cena = cena;}
    public void setKategorija(Kategorija kategorija) {this.kategorija = kategorija;}

    @Override
    public String toString() {
        return "Jelo{" +
                "id=" + id +
                ", slika='" + slika + '\'' +
                ", naziv='" + naziv + '\'' +
                ", opis='" + opis + '\'' +
                ", kalorijskaVrednost=" + kalorijskaVrednost +
                ", cena=" + cena +
                '}';
    }



}
