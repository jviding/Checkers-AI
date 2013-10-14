/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
import java.util.Random;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Timo
 */
public class KaikkiSyonnitTest {
    public String[][] kentta = new String[8][8];
    public Random arpoja = new Random();
    public KaikkiSyonnitTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        for(int a=0;a<8;a++){
            for(int b=0;b<8;b++){
                if((a+b)%2==0)
                    kentta[a][b]="o";
                else
                    kentta[a][b]="x";
            }
        }
    }
    
    @After
    public void tearDown() {
    }

    @Test
    public void pieniSyoYhdenTest() {
        int x=0;
        int y=0;
        KaikkiSyonnit syonnit = new KaikkiSyonnit();
        Valikentta[] kentasto;
        String vari = "m";
        for(int a=0;a<500;a++){
            while(!kentta[x][y].equals("x")){
                x=arpoja.nextInt(4)+2;
                y=arpoja.nextInt(4)+2;
            }
            if(vari.equals("v")){
                kentta[x][y]="v";
                kentta[x-1][y-1]="m";
                kentta[x-1][y+1]="m";
                kentta[x+1][y-1]="m";
                kentta[x+1][y+1]="m"; 
            }
            else{
                kentta[x][y]="m";
                kentta[x-1][y-1]="v";
                kentta[x-1][y+1]="v";
                kentta[x+1][y-1]="v";
                kentta[x+1][y+1]="v";
            }
            kentasto=syonnit.voikoSyoda(kentta, vari);
            for(int i=0;i<2;i++){
                assertEquals(1,kentasto[i].getTilasto());
            }
            x--;
            if(a==249)
                vari="v";
            setUp();
        }
    }
    @Test
    public void syoKaksTest(){
        int x=0;
        int y=0;
        String vari="m";
        KaikkiSyonnit syonnit = new KaikkiSyonnit();
        Valikentta[] kentasto;
        for(int i=0;i<400;i++){
            while(!kentta[x][y].equals("x")){
                x=arpoja.nextInt(4)+1;
                y=arpoja.nextInt(4)+1;
            }
            if(vari.equals("m")){
                kentta[x][y]="m";
                kentta[x][y+2]="m";
                if(i<100){
                    kentta[x-1][y-1]="V";
                    kentta[x+1][y-1]="v";
                    kentasto=syonnit.voikoSyoda(kentta, "v");
                }
                else{
                    kentta[x-1][y+3]="V";
                    kentta[x+1][y+3]="v";
                    kentasto=syonnit.voikoSyoda(kentta, "v");
                }
            }
            else{
                kentta[x][y]="v";
                kentta[x][y+2]="v";
                if(i<300){
                    kentta[x-1][y-1]="m";
                    kentta[x+1][y-1]="M";
                    kentasto=syonnit.voikoSyoda(kentta, "m");
                }
                else{
                    kentta[x-1][y+3]="m";
                    kentta[x+1][y+3]="M";
                    kentasto=syonnit.voikoSyoda(kentta, "m");
                }
            }
            for(int a=0;a<1;a++){
                assertEquals(2,kentasto[a].getTilasto());
            }
            if(i==200)
                vari="v";
            setUp();
            x++;
        }
    }

}
