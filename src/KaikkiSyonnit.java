/**
 * Tekee kaikki, syönnin sisältävät, siirrot.
 * @author Timo
 */
public class KaikkiSyonnit {
    private KaikkiLiikut normiliikut = new KaikkiLiikut();
    private Syvakopio kopiointi = new Syvakopio();
    private Kentastolisays lisays = new Kentastolisays();
    public KaikkiSyonnit(){}
    public Valikentta[] voikoSyoda(String[][] kentta, String vari){
        Valikentta[] kentasto = new Valikentta[1];
        for(int a=0;a<8;a++)
            for(int b=0;b<8;b++){
                if(kentta[a][b].equals(vari))
                    kentasto=pieniSyo(kentta, a, b, kentasto);
                if(kentta[a][b].equals(vari.toUpperCase()))
                    kentasto=isoSyo(kentta, a, b, kentasto, vari);
            }
        if(kentasto[0]==null)
            return normiliikut.teeKaikkiLiikut(kentta, vari, kentasto);
        return kentasto;
    }
    private Valikentta[] pieniSyo(String[][] kentta,int a,int b, Valikentta[] kentasto){
        kentasto=syoVasemmalle(kentta,a,b, kentasto);
        kentasto=syoOikealle(kentta, a, b, kentasto);
        return kentasto;
    }
    private Valikentta[] isoSyo(String[][] kentta,int a,int b,Valikentta[] kentasto,String vari){
        kentasto=syoIsoOikealleYlos(kentta,a,b,kentasto,vari.toUpperCase());
        kentasto=syoIsoOikealleAlas(kentta,a,b,kentasto,vari.toUpperCase());
        kentasto=syoIsoVasemmalleYlos(kentta,a,b,kentasto,vari.toUpperCase());
        kentasto=syoIsoVasemmalleAlas(kentta,a,b,kentasto,vari.toUpperCase());
        return kentasto;
    }
    private Valikentta[] syoIsoOikealleYlos(String[][] kentta, int a, int b,
            Valikentta[] kentasto, String vari){
        String[][] apu = kopiointi.syvaKopio(kentta);
        apu[a][b]="x";
        while(a>1 && b<6 && apu[a][b].equals("x")){
            a--; b++;
            if(!vari.equals(kentta[a][b].toUpperCase()) && !kentta[a][b].equals("x") && kentta[a-1][b+1].equals("x")){
                apu[a][b]="x";
                return jatkaSyomista(sijoitaKenttaan(apu,a-1,b+1,vari), a-1, b+1, kentasto,1);
            }
        }
        return kentasto;
    }
    private Valikentta[] syoIsoOikealleAlas(String[][] kentta, int a, int b,
            Valikentta[] kentasto, String vari){
        String[][] apu = kopiointi.syvaKopio(kentta);
        apu[a][b]="x";
        while(a<6 && b<6 && apu[a][b].equals("x")){
            a++; b++;
            if(!vari.equals(kentta[a][b].toUpperCase()) && !kentta[a][b].equals("x") && kentta[a+1][b+1].equals("x")){
                apu[a][b]="x";
                return jatkaSyomista(sijoitaKenttaan(apu,a+1,b+1,vari), a+1, b+1, kentasto,1);
            }
        }
        return kentasto;
    }
    private Valikentta[] syoIsoVasemmalleYlos(String[][] kentta, int a, int b,
            Valikentta[] kentasto, String vari){
        String[][] apu = kopiointi.syvaKopio(kentta);
        apu[a][b]="x";
        while(a>1 && b>1 && apu[a][b].equals("x")){
            a--; b--;
            if(!vari.equals(kentta[a][b].toUpperCase()) && !kentta[a][b].equals("x") && kentta[a-1][b-1].equals("x")){
                apu[a][b]="x";
                return jatkaSyomista(sijoitaKenttaan(apu,a-1,b-1,vari), a-1, b-1, kentasto,1);
            }
        }
        return kentasto;
    }
    private Valikentta[] syoIsoVasemmalleAlas(String[][] kentta, int a, int b,
            Valikentta[] kentasto, String vari){
        String[][] apu = kopiointi.syvaKopio(kentta);
        apu[a][b]="x";  
        while(a<6 && b>1 && apu[a][b].equals("x")){
            a++; b--;
            if(!vari.equals(kentta[a][b].toUpperCase()) && !kentta[a][b].equals("x") && kentta[a+1][b-1].equals("x")){
                apu[a][b]="x";
                return jatkaSyomista(sijoitaKenttaan(apu,a+1,b-1,vari), a+1, b-1, kentasto,1);
            }
        }
        return kentasto;
    }
    private Valikentta[] syoOikealle(String[][] kentta, int a, int b,
            Valikentta[] kentasto){
        String[][] apu = kopiointi.syvaKopio(kentta);
        apu[a][b]="x";
        if(kentta[a][b].equals("m") && a<6 && b<6 && (kentta[a+1][b+1].equals("v") 
                || kentta[a+1][b+1].equals("V")) && kentta[a+2][b+2].equals("x")){
            apu[a+1][b+1]="x";
            kentasto=jatkaSyomista(sijoitaKenttaan(apu,a+2,b+2,kentta[a][b]),a+2,b+2,kentasto,1);
        }
        if(kentta[a][b].equals("v") && a>1 && b<6 && (kentta[a-1][b+1].equals("m") 
                || kentta[a-1][b+1].equals("M")) && kentta[a-2][b+2].equals("x")){
            apu[a-1][b+1]="x";
            kentasto=jatkaSyomista(sijoitaKenttaan(apu,a-2,b+2,kentta[a][b]),a-2,b+2,kentasto,1);
        }
        return kentasto;
    }
    private Valikentta[] syoVasemmalle(String[][] kentta, int a, int b,
            Valikentta[] kentasto){
        String[][] apu = kopiointi.syvaKopio(kentta);
        apu[a][b]="x";      
        if(kentta[a][b].equals("m") && b>1 && a<6 && (kentta[a+1][b-1].equals("v") 
                || kentta[a+1][b-1].equals("V")) && kentta[a+2][b-2].equals("x")){
            apu[a+1][b-1]="x";
            kentasto=jatkaSyomista(sijoitaKenttaan(apu,a+2,b-2,kentta[a][b]),a+2,b-2,kentasto,1);
        }
        if(kentta[a][b].equals("v") && b>1 && a>1 && (kentta[a-1][b-1].equals("m") 
                || kentta[a-1][b-1].equals("M")) && kentta[a-2][b-2].equals("x")){
            apu[a-1][b-1]="x";
            kentasto=jatkaSyomista(sijoitaKenttaan(apu,a-2,b-2,kentta[a][b]),a-2,b-2,kentasto,1);
        }
        return kentasto;
    }
    private Valikentta[] jatkaSyomista(String[][] kentta, int a, int b,
            Valikentta[] kentasto, int syonnit){             
        kentasto=syoVasemmalleYlos(kopiointi.syvaKopio(kentta), kentta, a, b, kentasto, syonnit);
        kentasto=syoVasemmalleAlas(kopiointi.syvaKopio(kentta), kentta, a, b, kentasto, syonnit);
        kentasto=syoOikealleYlos(kopiointi.syvaKopio(kentta), kentta, a, b, kentasto, syonnit);
        kentasto=syoOikealleAlas(kopiointi.syvaKopio(kentta), kentta, a, b, kentasto, syonnit);
        if(voikoJatkaaSyomista(kentta,a,b)==false)
            return lisays.lisaaKentastoon(kentta, kentasto, syonnit);
        return kentasto;
    }
    private boolean voikoJatkaaSyomista(String[][] kentta,int a,int b){
        String vari=kentta[a][b].toUpperCase();
        if((a>1 && b>1 && !vari.equals(kentta[a-1][b-1].toUpperCase()) && !kentta[a-1][b-1].equals("x") && kentta[a-2][b-2].equals("x"))
                || (a<6 && b>1 && !vari.equals(kentta[a+1][b-1].toUpperCase()) && !kentta[a+1][b-1].equals("x") && kentta[a+2][b-2].equals("x"))
                || (a>1 && b<6 && !vari.equals(kentta[a-1][b+1].toUpperCase()) && !kentta[a-1][b+1].equals("x") && kentta[a-2][b+2].equals("x"))
                || (a<6 && b<6 && !vari.equals(kentta[a+1][b+1].toUpperCase()) && !kentta[a+1][b+1].equals("x") && kentta[a+2][b+2].equals("x")))
            return true;
        return false;
    }
    private Valikentta[] syoOikealleYlos(String[][] apu,String[][] kentta,int a,int b, 
            Valikentta[] kentasto,int syonnit){
        if(a>1 && b<6 && !kentta[a][b].toUpperCase().equals(kentta[a-1][b+1].toUpperCase())
                && !kentta[a-1][b+1].equals("x") && kentta[a-2][b+2].equals("x")){
            apu[a-1][b+1]="x";
            apu[a][b]="x";
            return jatkaSyomista(sijoitaKenttaan(apu,a-2,b+2,kentta[a][b]),a-2,b+2,kentasto,syonnit+1);
        }
        return kentasto;
    }
    private Valikentta[] syoOikealleAlas(String[][] apu,String[][] kentta,int a,int b, 
            Valikentta[] kentasto,int syonnit){
        if(a<6 && b<6 && !kentta[a][b].toUpperCase().equals(kentta[a+1][b+1].toUpperCase())
                && !kentta[a+1][b+1].equals("x") && kentta[a+2][b+2].equals("x")){
            apu[a+1][b+1]="x";
            apu[a][b]="x";
            return jatkaSyomista(sijoitaKenttaan(apu,a+2,b+2,kentta[a][b]),a+2,b+2,kentasto,syonnit+1);
        }
        return kentasto;
    }
    private Valikentta[] syoVasemmalleAlas(String[][] apu,String[][] kentta,int a,int b, 
            Valikentta[] kentasto,int syonnit){
        if(a<6 && b>1 && !kentta[a][b].toUpperCase().equals(kentta[a+1][b-1].toUpperCase())
                && !kentta[a+1][b-1].equals("x") && kentta[a+2][b-2].equals("x")){
            apu[a+1][b-1]="x";
            apu[a][b]="x";
            return jatkaSyomista(sijoitaKenttaan(apu,a+2,b-2,kentta[a][b]),a+2,b-2,kentasto,syonnit+1);
        }
        return kentasto;
    }
    private Valikentta[] syoVasemmalleYlos(String[][] apu,String[][] kentta,int a,int b, 
            Valikentta[] kentasto,int syonnit){
        if(a>1 && b>1 && !kentta[a][b].toUpperCase().equals(kentta[a-1][b-1].toUpperCase())
                && !kentta[a-1][b-1].equals("x") && kentta[a-2][b-2].equals("x")){
            apu[a-1][b-1]="x";
            apu[a][b]="x";
            return jatkaSyomista(sijoitaKenttaan(apu,a-2,b-2,kentta[a][b]),a-2,b-2,kentasto,syonnit+1);
        }
        return kentasto;
    }
    private String[][] sijoitaKenttaan(String[][] kentta, int a, int b, String vari){
        kentta[a][b]=vari;
        return kentta;
    }
}
