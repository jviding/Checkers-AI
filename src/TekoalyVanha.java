//import java.util.Arrays;
//public class TekoalyVanha {
//    private KaikkiSyonnit syomiset = new KaikkiSyonnit();
//    private String pelivari;
//    public TekoalyVanha(String vari){
//        pelivari=vari;
//    }
//    public String[][] keskustelu(String[][] kentta){
//        Valikentta[] kentasto = syomiset.voikoSyoda(kentta,pelivari);
//        ValikenttaVanha[] vanhat = new ValikenttaVanha[kentasto.length]; 
//        for(int i=0;i<kentasto.length;i++){
//            if(kentasto[i]!=null){
//                vanhat[i]=new ValikenttaVanha(kentasto[i]);
//                if(pelivari.equals("m"))
//                    tutkimus(syomiset.voikoSyoda(kentta,"v"),vanhat[i],"v",0);
//                else
//                    tutkimus(syomiset.voikoSyoda(kentta,"m"),vanhat[i],"m",0);
//            }
//        }
//        
//
//        //Kun päästään tähän, tarkistetaan mikä kentaston solmuista sisältää parhaan lukujonon.
//        //Tarkoitus että solmut ite analysoi dataa ja osaa arvioida oman hyvyytensä.
//        
//        
////        for(int a=0;a<kentasto.length;a++){
////            if(kentasto[a]!=null){
////                if(pelivari.equals("m"))
////                    tutkimus(voikoSyoda(kentasto[a].getKentta(), "v"), kentasto[a],"v",0,0);
////                if(pelivari.equals("v"))
////                    tutkimus(voikoSyoda(kentasto[a].getKentta(), "m"), kentasto[a],"m",0,0);
////            }
////        }
////        
//        ValikenttaVanha vertailu = new ValikenttaVanha(kentasto[0]);
//
//        for(int i=0;i<kentasto.length;i++){
//            if(kentasto[i]!=null){
//                if(vertailu.getOnkoHuono()==true && vanhat[i].getOnkoHuono()==false){
//                    vertailu=vanhat[i];
//                }
//                else if(vertailu.getOnkoHuono()==true && vanhat[i].getOnkoHuono()==true && vertailu.getHuonous()<vanhat[i].getHuonous()){
//                    vertailu=vanhat[i];
//                }
//                else if(vertailu.getOnkoHuono()==false && vanhat[i].getOnkoHuono()==false && vanhat[i].getHuonous()<vertailu.getHuonous()){
//                    vertailu=vanhat[i];
//                }
//            }
//        }
////        System.out.println(pelivari+"---"+paras+"---");
////        if(kentasto[0]!=null)
////            kentta=vertailu.getKentta();
//        
//        return vertailu.getKentta();
//    }
//    private void tutkimus(Valikentta[] kentasto, ValikenttaVanha isi, String vari, int syvyys){
//
//        if(syvyys==4){
//            for(int i=0;i<kentasto.length;i++){
//                if(kentasto[i]!=null){
//                    if(syvyys%2==0)
//                        isi.paivitaTilasto(-kentasto[i].getTilasto(), syvyys);
//                    else
//                        isi.paivitaTilasto(kentasto[i].getTilasto(), syvyys);
//                }                    
//            }
//            return;
//        }
//        for(int a=0;a<kentasto.length;a++){
//            if(kentasto[a]!=null){
//                if(syvyys%2==0)
//                    isi.paivitaTilasto(-kentasto[a].getTilasto(), syvyys);
//                else
//                    isi.paivitaTilasto(kentasto[a].getTilasto(), syvyys);
//                if(vari.equals("m"))
//                    tutkimus((syomiset.voikoSyoda(kentasto[a].getKentta(),"v")), isi,"v",syvyys+1);
//                if(vari.equals("v"))
//                    tutkimus((syomiset.voikoSyoda(kentasto[a].getKentta(),"m")), isi,"m",syvyys+1);
//            }
//        }
//    }
//    private int haeTilasto(Valikentta kenttatilanne, String vari){
//        if(pelivari.equals(vari))
//            return kenttatilanne.getTilasto();
//        return -kenttatilanne.getTilasto();
//    }
////    private void tilastonPaivitys(Valikentta kenttatilanne, int syvyys, String vari, Valikentta isi){
////        if(pelivari.equals(vari))
////            isi.paivitaTilasto(kenttatilanne.getTilasto(), syvyys);
////        else
////            isi.paivitaTilasto(-kenttatilanne.getTilasto(), syvyys);
////    }
//}