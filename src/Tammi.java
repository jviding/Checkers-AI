import javax.swing.JFrame;
public class Tammi extends JFrame {
    private String[][] kentta = new String[8][8];
    private Pelaaja valkoinen;
    private Pelaaja musta;
    private void alustaKentta(){
        for(int a=0;a<8;a++)
            for(int b=0;b<8;b++){
                if((a+b)%2==0)
                    kentta[a][b]="o";
                else
                    if(a<2)
                        kentta[a][b]="m";
                    else if(a>5)
                        kentta[a][b]="v";
                    else
                        kentta[a][b]="x";
            }
    }
    private void luoPelaajat(int valinta){
        if(valinta==0){
            valkoinen=new Pelaaja("v",true);
            musta=new Pelaaja("m",true);
        }
        else if(valinta==1){
            valkoinen=new Pelaaja("v",false);
            musta=new Pelaaja("m",true);
        }
        else{
            valkoinen=new Pelaaja("v",true);
            musta=new Pelaaja("m",false);
        }
    }
    public Tammi(int valinta) {
        luoPelaajat(valinta);
        alustaKentta();
    }
    public void setKentta(String[][] uusKentta){
        this.kentta=uusKentta;
    }
    public String[][] getKentta(){
        return kentta;
    } 
    public String[][] mustanVuoro(){
        if(musta.getKoneko()==true)
            tauko();    
        kentta=musta.keskustelu(kentta);
        return kentta;
    }
    public String[][] valkoisenVuoro(){
        if(valkoinen.getKoneko()==true)
            tauko();
        kentta=valkoinen.keskustelu(kentta);
        return kentta;
    }
    public String jatkuukoPeli(){
        int mustat=0;
        int valkoset=0;
        for(int a=0;a<8;a++)
            for(int b=0;b<8;b++){
                if(kentta[a][b].equals("M") || kentta[a][b].equals("m"))
                    mustat++;
                if(kentta[a][b].equals("V") || kentta[a][b].equals("v"))
                    valkoset++;
            }
        if(valkoset==0)
            return "Musta voitti!";
        if(mustat==0)
            return "Valkoinen voitti!";
        return "";
    }
    private void tauko(){
            try{
                Thread.sleep(1000);
            }
            catch(InterruptedException e){
                System.out.println("InterruptedException");
            }
    }
}