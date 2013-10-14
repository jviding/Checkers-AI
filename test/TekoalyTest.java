import java.util.Random;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;


public class TekoalyTest {
    private String[][] kentta = new String[8][8];
    
    
    public TekoalyTest() {
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
                System.out.print(kentta[a][b]);
            }
            System.out.println("");
        }
    }
    
    @After
    public void tearDown() {
    }

    @Test
    public void helloTest() {
        Tekoaly aly = new Tekoaly("m");
        kentta[1][0]="m";
        kentta[2][1]="m";
        kentta[1][2]="m";
        kentta[1][4]="m";
        kentta[1][6]="m";
        kentta[3][4]="v";
        kentta[7][0]="v";
        kentta[6][3]="v";
        kentta[6][5]="v";
        kentta = aly.keskustelu(kentta);
        
        System.out.println("ratkaisu:");
        for(int a=0;a<8;a++){
            for(int b=0;b<8;b++){
                System.out.print(kentta[a][b]);
            }
            System.out.println("");
        }
        
    }

}
