import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Kierownik extends Pracownik implements Serializable {

    private static List<Kierownik> listaKierownikow = new ArrayList<>();
    private List<Mechanik> listaPodwladnych = new ArrayList<>();

    public Kierownik(String imie, int pensja){
        super(imie, pensja);
        dodajKierownika(this);
    }

    @Override
    public int obliczRoczneZarobki() {
        return getPensja() * 12 + getPensja();
    }

    public static void dodajKierownika(Kierownik kierownik){
        listaKierownikow.add(kierownik);
    }

    public static void usunKierownika(Kierownik kierownik){
        List<Mechanik> podwladni = kierownik.listaPodwladnych;
        for(Mechanik m : podwladni){
            Mechanik.usunMechanika(m);
        }
        listaKierownikow.remove(kierownik);
    }


    public void dodajPodwladnego(Mechanik mechanik){
        this.listaPodwladnych.add(mechanik);
    }

    public static void wyswietlListe(){
        System.out.println("Ekstensja klasy Kierownik:");
        for(Kierownik kierownik : listaKierownikow){
            System.out.println(kierownik);
        }
    }

    public void wyswietlPodwladnych(){
        System.out.println("Podwladni kierownika " + this.getImie() + ":");
        for(Pracownik pracownik : listaPodwladnych){
            System.out.println(pracownik);
        }
    }

    public void wyswietlPodwladnych(int id){
        Pracownik p = null;

        for(Pracownik pracownik : listaPodwladnych){
            if(pracownik.getId() == id){
                p = pracownik;
            }
            break;
        }

        if(p != null){
            System.out.println(p);
        } else {
            System.out.println("Kierownik nie ma podwładnego o id " + id);
        }
    }


    public static void zapiszEkstensje(ObjectOutputStream stream) throws IOException {
        stream.writeObject(listaKierownikow);
    }

    public static void wczytajEkstensje(ObjectInputStream stream) throws IOException, ClassNotFoundException {
        listaKierownikow = (ArrayList<Kierownik>) stream.readObject();
    }

    public static int search(int id){
        for(Kierownik kierownik : listaKierownikow){
            if(kierownik.getId() == id){
                return listaKierownikow.indexOf(kierownik);
            }
        }
        return -1;
    }

    public static Kierownik getKierownik(int index){
        return listaKierownikow.get(index);
    }

    public List<Mechanik> getListaPodwladnych() {
        return listaPodwladnych;
    }
}
