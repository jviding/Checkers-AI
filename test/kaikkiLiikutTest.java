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
public class kaikkiLiikutTest {
    public String[][] kentta = new String[8][8];
    public Random arpoja = new Random();
    public kaikkiLiikutTest() {
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
     public void pieniLiikkuuTest() {
        int x=0;
        int y=0;
        KaikkiLiikut liikut = new KaikkiLiikut();
        Valikentta[] kentasto = new Valikentta[1];
        String vari = "m";
        for(int a=0;a<500;a++){
            while(!kentta[x][y].equals("x")){
                x=arpoja.nextInt(6)+1;
                y=arpoja.nextInt(8);
            }
            kentta[x][y]=vari; 
            kentasto=liikut.teeKaikkiLiikut(kentta, vari, kentasto);
            
            int laskuri=0;
            for(int i=0;i<kentasto.length;i++){
                if(kentasto[i]!=null)
                    laskuri++;
            }
            if(y==0 || y==7)
                assertEquals(1,laskuri);
            else
                assertEquals(2,laskuri);
            
            kentasto = new Valikentta[1];
            laskuri=0;
            x--;
            if(a==249)
                vari="v";
            setUp();
        }
     
     
     }
}
