
/**
 * Write a description of class FichaDomino here.
 * 
 * @author (Luis Manuel Deniz Ramirez (1176494)) 
 * @version (Versión 2.0)
 */
public class FichaDomino
{
        private int ladoA;
    private int ladoB;

    public FichaDomino(int ladoA, int ladoB) {
        this.ladoA = ladoA;
        this.ladoB = ladoB;
    }

    public int getLadoA() {
        return ladoA;
    }

    public int getLadoB() {
        return ladoB;
    }

    public void setLadoA(int ladoA) {
        this.ladoA = ladoA;
    }

    public void setLadoB(int ladoB) {
        this.ladoB = ladoB;
    }
}
