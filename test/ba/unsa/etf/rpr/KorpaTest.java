package ba.unsa.etf.rpr;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

class KorpaTest {

    @Test
    void dodajArtikl() { // do 50 vraca true
        Artikl artikl = new Artikl("Bajk", 1000, "1");
        Korpa korpa = new Korpa();
        for(int i = 0; i < 50; i++) {
            assertTrue(korpa.dodajArtikl(artikl));
        }
    }

    @Test
    void dodajArtikl1() { // preko 50 mora vratiti false
        Artikl artikl = new Artikl("Bajk", 1000, "1");
        Korpa korpa = new Korpa();
        for(int i = 0; i < 50; i++) {
            korpa.dodajArtikl(artikl);
        }
        assertFalse(korpa.dodajArtikl(artikl));
    }

    @Test
    void getArtikli() { // provjera da li metoda vraća tacno onoliko artikala koliko smo i ubacili
        Artikl artikl = new Artikl("Bajk", 1000, "1");
        Korpa korpa = new Korpa();
        for(int i = 0; i < 50; i++) {
            korpa.dodajArtikl(artikl);
        }
        assertEquals(50, korpa.getArtikli().length);
    } // dobro bi bilo jos da se napravi test za referecnu, mozda sa pomocnom klasom unutar testa..

    @Test
    void izbaciArtiklSaKodom() {
        Korpa korpa = new Korpa();
        for(int i = 0; i < 49; i++) {
            korpa.dodajArtikl(new Artikl("Bajk", 1000, String.valueOf(i)));
        }
        Artikl izbaci1 = korpa.izbaciArtiklSaKodom("25");
        assertEquals(izbaci1.getKod(), String.valueOf(25));// provjera da li je izbacio tacno taj Artikal sa odredjenim kodom
        assertEquals(48, korpa.getVel()); // plus provjera da li je velicina niza smanjena za 1
    }

    @Test
    void dajUkupnuCijenuArtikala() {
        Korpa korpa = new Korpa();
        for(int i = 0; i < 49; i++) {
            korpa.dodajArtikl(new Artikl("Bajk", 1000, String.valueOf(i)));
        }
    }
}