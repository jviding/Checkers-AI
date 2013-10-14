import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import java.io.*;
public class Pelilauta extends JFrame {
    private JButton[] pelilauta;
    public Pelilauta() {
        setLayout(new BorderLayout());
        pelilauta = new JButton[8*8];
        JPanel paneeli=new JPanel(new GridLayout(8,8));
        for(int a=0;a<8*8;a++){
            pelilauta[a]= new JButton("");
            pelilauta[a].setPreferredSize(new Dimension(1,1));
            pelilauta[a].setOpaque(true);
            pelilauta[a].setBackground(Color.ORANGE);
            paneeli.add(pelilauta[a]);
        }
        for(int x=0;x<8;x++)
            for(int y=0;y<8;y++){
                if((x+y)%2!=0)
                    pelilauta[x*8+y].setBackground(Color.GRAY);
            }
        add("Center", paneeli);
        setVisible(true);
        aloita();
    }
    private void paivitaRuudukko(String[][] kentta){
        this.kentta=kentta;
        for(int a=0;a<8;a++){
            for(int b=0;b<8;b++){
                if(kentta[a][b].equals("x")){
                    pelilauta[a*8+b].setBackground(Color.GRAY);
                    pelilauta[a*8+b].setText(null);
                }
                if(kentta[a][b].equals("m") || kentta[a][b].equals("M")){
                    pelilauta[a*8+b].setBackground(Color.BLACK);
                    if(kentta[a][b].equals("M")){
                        pelilauta[a*8+b].setText("K");
                        pelilauta[a*8+b].setForeground(Color.WHITE);
                    }
                }
                if(kentta[a][b].equals("v") || kentta[a][b].equals("V")){
                    pelilauta[a*8+b].setBackground(Color.WHITE);
                    if(kentta[a][b].equals("V")){
                        pelilauta[a*8+b].setText("K");
                        pelilauta[a*8+b].setForeground(Color.BLACK);
                    }
                }
            }
        }
    }
    private String[][] kentta;
    private String pelivari;
    private String nappula;
    private Tammi tammipeli;
    private void luoNappitapahtumat(){
        for(int a=0;a<8*8;a++)
            pelilauta[a].addActionListener(
                new ActionListener() {
                    public void actionPerformed(ActionEvent tapahtuma){
                        for(int b=0;b<8*8;b++)
                            if(pelilauta[b]==tapahtuma.getSource()){
                                nappiaPainetaan(b);
                                break;
                            }
                    }
                }
            );
    }
    private void nappiaPainetaan(int i){
        if(kentta[i/8][i%8].equals("x")){
            kentta[i/8][i%8]=nappula;
            paivitaRuudukko(kentta);
            koneenVuoro();
        }
        if(kentta[i/8][i%8].toUpperCase().equals(pelivari.toUpperCase())){
            nappula=kentta[i/8][i%8];
            kentta[i/8][i%8]="x";
        }   
        if(!kentta[i/8][i%8].toUpperCase().equals(pelivari.toUpperCase())){
            kentta[i/8][i%8]="x";
        }
    }
    private int kysely(){
        JFrame frame = new JFrame("Pelivalikko");
        Object[] valinnat = {"AI vs AI","Pelaaja(valk.) vs AI","AI vs Pelaaja(musta)"};
        String kysymys = "Valitse pelitapa:";
        int valinta = JOptionPane.showOptionDialog(frame, kysymys, "Pelivalikko", JOptionPane.PLAIN_MESSAGE, 1, null, valinnat, "AI vs AI");
        this.setSize(300,200);
        this.setLocation(10,200);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
        return valinta;
    }
    private void aloita(){
        int valinta = kysely();
        tammipeli = new Tammi(valinta);
        paivitaRuudukko(tammipeli.getKentta());
        if(valinta==0)
            koneetVastakkain();
        if(valinta==1){
            pelivari="v";
            pelaajanVuoro();
        }
        if(valinta==2){
            pelivari="m";
            koneenVuoro();
            pelaajanVuoro();
        }
    }
//    private void valkPelaaja(){
//        this.kentta=tammipeli.getKentta();
//        
//            //paivitaRuudukko(tammipeli.valkoisenVuoro());
//            pelaajanVuoro("v");
//            //if(jatkuuko(tammipeli.jatkuukoPeli())==false)
//
////            paivitaRuudukko(tammipeli.mustanVuoro());
//            //if(jatkuuko(tammipeli.jatkuukoPeli())==false)
//
//    }
//    private void mustPelaaja(){
////            paivitaRuudukko(tammipeli.valkoisenVuoro());
//            //if(jatkuuko(tammipeli.jatkuukoPeli())==false)
//
//            //paivitaRuudukko(tammipeli.mustanVuoro());
//            pelaajanVuoro("m");
//            //if(jatkuuko(tammipeli.jatkuukoPeli())==false)
//
//    }
    private void koneenVuoro(){
        tammipeli.setKentta(kentta);
        if(pelivari.equals("v"))
            paivitaRuudukko(tammipeli.mustanVuoro());
        paivitaRuudukko(tammipeli.valkoisenVuoro());
    }
    private void pelaajanVuoro(){
        luoNappitapahtumat();
    }
    private void koneetVastakkain(){
        while(true){
            paivitaRuudukko(tammipeli.valkoisenVuoro());
            if(jatkuuko(tammipeli.jatkuukoPeli())==false)
                break;
            paivitaRuudukko(tammipeli.mustanVuoro());
            if(jatkuuko(tammipeli.jatkuukoPeli())==false)
                break;
        }
    }
    private boolean jatkuuko(String teksti){
        if(teksti.equals(""))
            return true;
        System.out.println(teksti);
        return false;
    }
}
