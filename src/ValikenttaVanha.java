//public class ValikenttaVanha {
//    private String[][] kentta;
//    private int[] taulu;
//    private int lisatyt;
//    private int tilasto;
//    private boolean onkoHuono = false;
//    private int huonous=0;
//    private int maxKierros;
//    public ValikenttaVanha(Valikentta valis){
//        this.kentta=valis.getKentta();
//        this.tilasto=valis.getTilasto();
//        taulu = new int[6];
//        lisatyt=0;
//    }
//    public String[][] getKentta(){
//        return kentta;
//    }
////    public void setArvo(int luku){
////        lisaaTauluun(luku);
////    }
//    private void lisaaTauluun(int luku, int indeksi){
//        lisatyt++;
//        if(lisatyt>taulu.length)
//            kasvataTaulua();
//        else
//            taulu[lisatyt-1]=luku;
//    }
//    private void kasvataTaulua(){
//        int[] apu = new int[lisatyt*2];
//        for(int a=0;a<taulu.length;a++)
//            apu[a]=taulu[a];
//        taulu=apu;
//    }
//    private int edellinenKierros;
//    private int omaArvo;
//    public void setArvo(int arvo){
//        omaArvo=arvo;
//    }
//    public int getArvo(int arvo){
//        return omaArvo;
//    }
//    public void paivitaTilasto(int arvo, int kierros){
//        if(arvo<0 && kierros==0){
//            onkoHuono=true;
//            huonous=arvo;
//        }
//        if(onkoHuono==false && arvo<0){
//            huonous++;
//        }
//        
//        //lisaaTauluun(arvo,kierros);
//        if(kierros>maxKierros){
//            maxKierros=kierros;
//        }
//
////
////        taulu[kierros]=arvo;
////        int apu=0;
////        if(kierros==4){
////            for(int a=0;a<3;a++){
////                if(taulu[a]<0){
////                    apu=apu+taulu[a];
////                }
////            }
////        }
////        edellinenKierros=kierros;
////        if(apu>tilasto)
////            tilasto=apu;
//    }
//    public void laskeHuonous(){
//        
//    }
//    public int getTilasto(){
//        return tilasto;
//    }
//    public boolean getOnkoHuono(){
//        return onkoHuono;
//    }
//    public int getHuonous(){
//        return huonous;
//    }
//}