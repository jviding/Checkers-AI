public class Valikentta {
    private String[][] kentta;
    private int[] taulu;
    private int lisatyt;
    private int tilasto;
    public Valikentta(String[][] kentta, int tilasto){
        this.kentta=kentta;
        this.tilasto=tilasto;
        taulu = new int[1];
        lisatyt=0;
    }
    public int[] haeKentanIndeksit(int luku){
        int[] indeksit = new int[taulu.length];
        for(int a=0;a<lisatyt;a++){
            if(taulu[a]==luku)
                indeksit[a]=1;
        }
        return indeksit;
    }
    public void setKentta(String[][] kentta){
        this.kentta=kentta;
    }
    public String[][] getKentta(){
        return kentta;
    }
    public void setArvo(int luku){
        lisaaTauluun(luku);
    }
    private void lisaaTauluun(int luku){
        lisatyt++;
        if(lisatyt>taulu.length)
            kasvataTaulua();
        taulu[lisatyt-1]=luku;
    }
    private void kasvataTaulua(){
        int[] apu = new int[taulu.length*2];
        for(int a=0;a<taulu.length;a++)
            apu[a]=taulu[a];
        taulu=apu;
    }
    public int getPieninArvo(){
        int pienin=taulu[0];
        for(int i=0;i<lisatyt;i++){
            if(taulu[i]<pienin)
                pienin=taulu[i];
        }
        return pienin;
    }
    public int getSuurinArvo(){
        int suurin=taulu[0];
        for(int i=0;i<lisatyt;i++){
            if(taulu[i]>suurin)
                suurin=taulu[i];
        }
        return suurin;
    }
    public int getTilasto(){
        return tilasto;
    }
}