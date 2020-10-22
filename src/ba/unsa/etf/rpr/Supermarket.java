package ba.unsa.etf.rpr;

public class Supermarket {
    private Artikl[] artikli = new Artikl[1000];
    private int vel = 0;

    public void dodajArtikl(Artikl artikal){
        artikli[vel] = artikal;
       // System.out.println("naziv " + artikli[vel].getNaziv() + " cijena " + artikli[vel].getCijena() + " kod " + artikli[vel].getKod());
        vel = vel + 1;
//        for (Artikl a : artikli) {
//            if(a != null) System.out.println("Naziv: " + a.getNaziv() + ", Kod: " + a.getKod() + ", Cijena: " + a.getCijena() + " KM");
//        }
//        System.out.println(vel);
    }
    public Artikl[] getArtikli() {
        return artikli;
    }
    public Artikl izbaciArtiklSaKodom(String kod){
        for(int i = 0; i < vel; i++){
            int pom = Integer.parseInt(artikli[i].getKod());
            if(pom == Integer.parseInt(kod)){
                Artikl vrati = artikli[i];
                System.arraycopy(artikli, i+1, artikli , i, vel-i);
                vel = vel - 1;
                return vrati;
            }
        }
        return null;
    }
    public int getVel(){
        return vel;
    }
}
