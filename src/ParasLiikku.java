import java.util.Random;
public class ParasLiikku {
    private Random randomi = new Random();
    private Kentastolisays lisaaja = new Kentastolisays();
    public ParasLiikku(){}
    private int[] tulokset=new int[1];
    public String[][] valitseParas(Valikentta[] kentasto, String vari, Valikentta isi){
        kentasto=luoKentasto(kentasto, isi);        
        
        for(int a=0;a<kentasto.length;a++)
            if(kentasto[a]!=null)
                lisaaTuloksiin(laskeKentanArvo(kentasto[a].getKentta(),vari));
        return asetaParas(kentasto).getKentta();
    }
    private Valikentta[] luoKentasto(Valikentta[] kentasto, Valikentta isi){
        int[] indeksit=isi.haeKentanIndeksit(isi.getSuurinArvo());
        Valikentta[] apu = new Valikentta[1];
        for(int a=0;a<indeksit.length;a++){
            if(indeksit[a]==1){
                apu=lisaaja.lisaaKentastoon(kentasto[a].getKentta(), apu, 0);
            }
        }
        return apu;
    }
    private Valikentta asetaParas(Valikentta[] kentasto){
        int suurin=suurinArvo();
        int lisatyt=0;
        Valikentta[] lopullinen = new Valikentta[1];
        for(int a=0;a<tulokset.length;a++){
            if(tulokset[a]==suurin){
                lisatyt++;
                lopullinen=lisaaja.lisaaKentastoon(kentasto[a].getKentta(), lopullinen, a);
            }
        }
        tulokset=new int[1];
        return lopullinen[randomi.nextInt(lisatyt)];
    }
    private int suurinArvo(){
        int suurin=0;
        for(int a=0;a<tulokset.length;a++)
            if(tulokset[a]>suurin)
                suurin=tulokset[a];
        return suurin;
    }
    private void lisaaTuloksiin(int luku){
        for(int a=0;a<tulokset.length;a++){
            if(tulokset[a]==0){
                tulokset[a]=luku;
                return;
            }
        }
        pidennaLista(luku);
    }
    private void pidennaLista(int luku){
        int[] apu = new int[tulokset.length*2];
        for(int a=0;a<tulokset.length;a++)
            apu[a]=tulokset[a];
        apu[tulokset.length]=luku;
        tulokset=apu;
    }
    private int laskeKentanArvo(String[][] kentta,String vari){
        int kentanArvo=0;
        int pieninEtaisyys=0;
        for(int a=0;a<8;a++){
            for(int b=0;b<8;b++){
                if(kentta[a][b].toUpperCase().equals(vari.toUpperCase())){
                    if(a<7-a)
                        pieninEtaisyys=a;
                    else
                        pieninEtaisyys=7-a;
                    if(b<7-b)
                        if(pieninEtaisyys>b)
                            pieninEtaisyys=b;
                    else
                        if(pieninEtaisyys>7-b)
                            pieninEtaisyys=7-b;
                    kentanArvo+=4-pieninEtaisyys;
                }
            }
        }
        return kentanArvo;
    }
}
