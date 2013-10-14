import java.util.Scanner;
public class Pelaaja {
    private String pelivari;
    private boolean tietokonepelaaja = false;
    private Tekoaly tietokone;
    public Pelaaja(String vari, boolean koneko){
        if(koneko==true){
            tietokonepelaaja=true;
            tietokone=new Tekoaly(vari);
        }
        pelivari=vari;
    }
    public boolean getKoneko(){
        return tietokonepelaaja;
    }
    public String[][] keskustelu(String[][] kentta){
        if(tietokonepelaaja=true)
            return tietokone.keskustelu(kentta);
        return null;
    }
}
