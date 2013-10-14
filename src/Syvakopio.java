import java.util.Arrays;
public class Syvakopio {
    public Syvakopio(){}
    /**Tekee kopion saamastaan taulukosta. Kopio ei sisällä viitteitä alkuperäiseen,
     * joten sitä muokkaamalla muut taulukot eivät muutu.
     * @param kopioitava
     * @return kopio
     */
    public String[][] syvaKopio(String[][] kopioitava){
        String[][] kopio = new String[kopioitava.length][];
        for(int i=0;i<kopioitava.length;i++)
            kopio[i]=Arrays.copyOf(kopioitava[i],kopioitava[i].length);
        return kopio;
    }
}
