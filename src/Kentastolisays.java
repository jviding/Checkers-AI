public class Kentastolisays {
    public Kentastolisays(){}
    public Valikentta[] lisaaKentastoon(String[][] kentta,Valikentta[] kentasto,
            int tilasto){
        kentta=kuninkaaksiko(kentta);
        for(int a=0;a<kentasto.length;a++)
            if(kentasto[a]==null){
                kentasto[a]=new Valikentta(kentta,tilasto);
                return kentasto;
            }
        return pidennaKentasto(kentta,kentasto,tilasto);
    }
    private Valikentta[] pidennaKentasto(String[][] kentta,Valikentta[] kentasto,
            int tilasto){
        Valikentta[] apu = new Valikentta[kentasto.length*2];
        for(int a=0;a<kentasto.length;a++)
            apu[a]=kentasto[a];
        apu[kentasto.length]=new Valikentta(kentta,tilasto);
        return apu;
    }
    private String[][] kuninkaaksiko(String[][] kentta){
        for(int a=0;a<8;a++){
            if(kentta[0][a].equals("v"))
                kentta[0][a]=kentta[0][a].toUpperCase();
            if(kentta[7][a].equals("m"))
                kentta[7][a]=kentta[7][a].toUpperCase();
        }
        return kentta;
    }
}
