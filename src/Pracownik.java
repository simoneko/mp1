import java.io.Serializable;

public abstract class Pracownik implements Serializable {
    private String imie;
    private int id;
    private static int nastepneId = 0;
    private int pensja;
    private int roczneZarobki;


    public Pracownik(String imie, int pensja){
        this.imie = imie;
        this.id = ++nastepneId;
        this.pensja = pensja;
        this.roczneZarobki = obliczRoczneZarobki();
    }

    abstract int obliczRoczneZarobki();

    public String getImie() {
        return imie;
    }

    public void setImie(String imie) {
        this.imie = imie;
    }

    public int getId() {
        return id;
    }

    public int getPensja() {
        return pensja;
    }

    public void setPensja(int pensja) {
        this.pensja = pensja;
    }

    public int getRoczneZarobki() {
        return roczneZarobki;
    }


    @Override
    public String toString() {
        return this.getClass() + ", id: " + this.getId() + ", imie: " + this.getImie() + ", zarobki: " + this.getPensja() + ", rocznie: " + this.getRoczneZarobki();
    }
}
