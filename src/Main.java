public class Main {
    public static void main(String[] args) throws Exception {

        Kierownik kier1 = new Kierownik("Mariusz", 10000);
        Kierownik kier2 = new Kierownik("Adam", 7000);
        Kierownik kier3 = new Kierownik("Grzegorz", 7000);


        Mechanik mech1 = new Mechanik("Stefan", 5000, kier1);
        Mechanik mech2 = new Mechanik("Janek", 3000, kier2);
        Mechanik mech3 = new Mechanik("Darek", 3500, kier1);
        Mechanik mech4 = new Mechanik("Sławek", 4500, kier3);


        String path = "C:\\tmp\\extent.bin";
//
//        ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(path));
//        Mechanik.zapiszEkstensje(out);
//        Kierownik.zapiszEkstensje(out);
//        out.close();

//        ObjectInputStream in = new ObjectInputStream(new FileInputStream(path));
//        Mechanik.wczytajEkstensje(in);
//        Kierownik.wczytajEkstensje(in);
//        in.close();
//
//        Mechanik.wyswietlListe();
//        Kierownik.wyswietlListe();




    }
}
