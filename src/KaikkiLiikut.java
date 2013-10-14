/**
 * Tekee kaikki mahdolliset, ei syömistä sisältävät, siirrot.
 * @author Jasu
 */
public class KaikkiLiikut {
    Syvakopio kopiointi = new Syvakopio();
    Kentastolisays lisays = new Kentastolisays();
    KaikkiLiikut(){}
    public Valikentta[] teeKaikkiLiikut(String[][] kentta, String vari,
            Valikentta[] kentasto){
        for(int a=0;a<8;a++)
            for(int b=0;b<8;b++){
                if(kentta[a][b].equals(vari))
                    kentasto=liikutaPienta(kentta,a,b,kentasto);
                if(kentta[a][b].equals(vari.toUpperCase()))
                    kentasto=liikutaIsoa(kentta, a, b, kentasto);
            }
        return kentasto;
    }
    private Valikentta[] liikutaIsoa(String[][] kentta,int a,int b,Valikentta[] kentasto){
        kentasto=liikuIsoOikealleYlos(kentta,a,b,kentasto);
        kentasto=liikuIsoOikealleAlas(kentta,a,b,kentasto);
        kentasto=liikuIsoVasemmalleYlos(kentta, a, b, kentasto);
        kentasto=liikuIsoVasemmalleAlas(kentta, a, b, kentasto);
        return kentasto;
    }
    private Valikentta[] liikutaPienta(String[][] kentta,int a,int b,Valikentta[] kentasto){
        kentasto=liikuOikealle(kentta,a,b,kentasto);
        kentasto=liikuVasemmalle(kentta,a,b,kentasto);
        return kentasto;
    }
    private Valikentta[] liikuIsoOikealleYlos(String[][] kentta, int a, int b,
            Valikentta[] kentasto){
        String[][] apu = kopiointi.syvaKopio(kentta);
        if(a>0 && b<7 && apu[a-1][b+1].equals("x")){
            apu[a][b]="x";
            apu[a-1][b+1]=kentta[a][b];    
            kentasto=liikuIsoOikealleYlos(apu, a-1, b+1, lisays.lisaaKentastoon(apu, kentasto, 0));
        }
        return kentasto;
    }
    private Valikentta[] liikuIsoOikealleAlas(String[][] kentta, int a, int b,
            Valikentta[] kentasto){
        String[][] apu = kopiointi.syvaKopio(kentta);
        if(a<7 && b<7 && apu[a+1][b+1].equals("x")){
            apu[a][b]="x"; 
            apu[a+1][b+1]=kentta[a][b];
            kentasto=liikuIsoOikealleAlas(apu, a+1, b+1, lisays.lisaaKentastoon(apu, kentasto, 0));
        }
        return kentasto;
    }
    private Valikentta[] liikuIsoVasemmalleYlos(String[][] kentta, int a, int b,
            Valikentta[] kentasto){
        String[][] apu = kopiointi.syvaKopio(kentta);
        if(a>0 && b>0 && apu[a-1][b-1].equals("x")){
            apu[a][b]="x";
            apu[a-1][b-1]=kentta[a][b];
            kentasto=liikuIsoVasemmalleYlos(apu, a-1, b-1, lisays.lisaaKentastoon(apu, kentasto, 0));
        }
        return kentasto;
    }
    private Valikentta[] liikuIsoVasemmalleAlas(String[][] kentta, int a, int b,
            Valikentta[] kentasto){
        String[][] apu = kopiointi.syvaKopio(kentta);
        if(a<7 && b>0 && apu[a+1][b-1].equals("x")){
            apu[a][b]="x"; 
            apu[a+1][b-1]=kentta[a][b];
            kentasto=liikuIsoVasemmalleAlas(apu, a+1, b-1, lisays.lisaaKentastoon(apu, kentasto, 0));
        }
        return kentasto;
    }
    private Valikentta[] liikuVasemmalle(String[][] kentta, int a, int b,
            Valikentta[] kentasto){
        String[][] apu = kopiointi.syvaKopio(kentta);
        apu[a][b]="x";
        if((b>0 && a<7 && kentta[a][b].equals("m")) && (kentta[a+1][b-1].equals("x")))
            kentasto=lisays.lisaaKentastoon(sijoitaKenttaan(apu,a+1,b-1,"m"), kentasto, 0);
        if((b>0 && a>0 && kentta[a][b].equals("v")) && (kentta[a-1][b-1].equals("x"))){
            kentasto=lisays.lisaaKentastoon(sijoitaKenttaan(apu,a-1,b-1,"v"), kentasto, 0);
        }
        return kentasto;
    }
        private Valikentta[] liikuOikealle(String[][] kentta, int a, int b,
            Valikentta[] kentasto){
        String[][] apu = kopiointi.syvaKopio(kentta);
        apu[a][b]="x";
        if((b<7 && a<7 && kentta[a][b].equals("m")) && kentta[a+1][b+1].equals("x"))
            kentasto=lisays.lisaaKentastoon(sijoitaKenttaan(apu,a+1,b+1,"m"), kentasto, 0);
        if((b<7 && a>0 && kentta[a][b].equals("v")) && (kentta[a-1][b+1].equals("x")))
            kentasto=lisays.lisaaKentastoon(sijoitaKenttaan(apu,a-1,b+1,"v"), kentasto, 0);
        return kentasto;
    }
    private String[][] sijoitaKenttaan(String[][] kentta, int a, int b, String vari){
        kentta[a][b]=vari;
        return kentta;
    }
}
