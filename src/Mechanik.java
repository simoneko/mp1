import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Mechanik extends Pracownik implements Serializable {

    private Kierownik kierownik;
    private static List<Mechanik> listaMechanikow = new ArrayList<>();


    public Mechanik(String imie, int pensja, Kierownik kierownik) throws IllegalArgumentException {
        super(imie, pensja);
        if(kierownik != null){
            this.kierownik = kierownik;
            kierownik.dodajPodwladnego(this);
        } else {
            throw new IllegalArgumentException("Kierownik nie może być nullem");
        }
        dodajMechanika(this);
    }

    @Override
    int obliczRoczneZarobki() {
        return this.getPensja() * 12;
    }

    public static void dodajMechanika(Mechanik mechanik){
        listaMechanikow.add(mechanik);
    }

    public static void usunMechanika(Mechanik mechanik){
        listaMechanikow.remove(mechanik);
    }

    public static void wyswietlListe(){
        System.out.println("Ekstensja klasy Mechanik:");
        for(Mechanik mechanik : listaMechanikow){
            System.out.println(mechanik);
        }
    }

    @Override
    public String toString() {
        return super.toString() + ", kierownik: " + this.getKierownik().getImie();
    }

    public Kierownik getKierownik() {
        return kierownik;
    }

    public void setKierownik(Kierownik kierownik) {
        this.kierownik.getListaPodwladnych().remove(this);
        kierownik.getListaPodwladnych().add(this);
        this.kierownik = kierownik;
    }

    public static void zapiszEkstensje(ObjectOutputStream stream) throws IOException {
        stream.writeObject(listaMechanikow);
    }

    public static void wczytajEkstensje(ObjectInputStream stream) throws IOException, ClassNotFoundException {
        listaMechanikow = (ArrayList<Mechanik>) stream.readObject();
    }

}
