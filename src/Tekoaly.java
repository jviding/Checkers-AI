import java.util.Arrays;
public class Tekoaly {
    private KaikkiSyonnit syomiset = new KaikkiSyonnit();
    private ParasLiikku parhain = new ParasLiikku();
    private String pelivari;
    public Tekoaly(String vari){
        pelivari=vari;
    }
    public String[][] keskustelu(String[][] kentta){
        Valikentta alkulauta = new Valikentta(kentta,0);
        if(pelivari.equals("m"))
            tutkimus(syomiset.voikoSyoda(kentta,"m"),alkulauta,"m",0,0);
        else
            tutkimus(syomiset.voikoSyoda(kentta,"v"),alkulauta,"v",0,0);
        return alkulauta.getKentta();
    }
    private int valitseArvo(Valikentta[] kentasto, int arvo, String vari){
        int valinta=arvo;
        for(int i=0;i<kentasto.length;i++)
            if(kentasto[i]!=null)
                if(!pelivari.equals(vari))
                    if(valinta>arvo-kentasto[i].getTilasto())
                        valinta=arvo-kentasto[i].getTilasto();
                else
                    if(valinta<arvo+kentasto[i].getTilasto())
                        valinta=arvo+kentasto[i].getTilasto();
        return valinta;
    }
    private void tutkimus(Valikentta[] kentasto, Valikentta isi, String vari, int syvyys, int arvo){
        int valinta=0;
        if(syvyys==4){
            isi.setArvo(valitseArvo(kentasto, arvo, vari));
            return;
        }
        for(int a=0;a<kentasto.length;a++){
            if(kentasto[a]!=null){
                valinta=kentasto[a].getTilasto();
                if(!pelivari.equals(vari))
                    valinta=0-valinta;
                if(vari.equals("m"))
                    tutkimus((syomiset.voikoSyoda(kentasto[a].getKentta(),"v")), kentasto[a],"v",syvyys+1,valinta+arvo);
                if(vari.equals("v"))
                    tutkimus((syomiset.voikoSyoda(kentasto[a].getKentta(),"m")), kentasto[a],"m",syvyys+1,valinta+arvo);
            }
        }
        asetaArvoja(kentasto,isi,syvyys);
        if(syvyys==0)
            isi.setKentta(parhain.valitseParas(kentasto, vari, isi));
    }
    private void asetaArvoja(Valikentta[] kentasto, Valikentta isi, int syvyys){
        for(int a=0;a<kentasto.length;a++){
            if(kentasto[a]!=null){
                if(syvyys%2==0)
                    isi.setArvo(kentasto[a].getPieninArvo());
                else
                    isi.setArvo(kentasto[a].getSuurinArvo());
            }
        }
    }
}