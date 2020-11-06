package ba.unsa.etf.rpr;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SupermarketTest {

    @Test
    void dodajArtikl() {
        Supermarket s = new Supermarket();
        Artikl a = new Artikl("biciklo", 1000, "123");
        for(int i = 0; i < 50; i++)
            s.dodajArtikl(a);
        assertEquals(50, s.getVel());
    }

    @Test
    void getArtikli() {
        Supermarket s = new Supermarket();
        Artikl a = new Artikl("biciklo", 1000, "123");
        for(int i = 0; i < 999; i++)
            s.dodajArtikl(a);
        assertEquals(1000, s.getArtikli().length);
    }

    @Test
    void izbaciArtiklSaKodom() {
        Supermarket s = new Supermarket();
        Artikl a = new Artikl("biciklo", 1000, "123");
        for(int i = 0; i < 50; i++)
            s.dodajArtikl(a);
        Artikl a1 = s.izbaciArtiklSaKodom("123");
        assertEquals(a1.getKod(), String.valueOf(123));// provjera da li je izbacio tacno taj Artikal sa odredjenim kodom
        assertEquals(49, s.getVel()); // plus provjera da li je velicina niza smanjena za 1
    }

    @Test
    void izbaciArtiklSaKodomNull() {
        Supermarket s = new Supermarket();
        assertEquals(null, s.izbaciArtiklSaKodom("123"));
    }
}