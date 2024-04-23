import java.util.*;
/**
 * Write a description of class Jugador here.
 * 
 * @author (Luis Manuel Deniz Ramirez (1176494)) 
 * @version (Versión 2.0)
 */
public class Jugador
{
    private List<FichaDomino> fichas;

    public Jugador() {
        fichas = new ArrayList<>();
    }

    public void agregarFicha(FichaDomino ficha) {
        fichas.add(ficha);
    }

    public FichaDomino getFicha(int indice) {
        return fichas.get(indice);
    }

    public void removerFicha(int indice) {
        fichas.remove(indice);
    }

    public void mostrarFichas() {
        for (int i = 0; i < fichas.size(); i++) {
            FichaDomino ficha = fichas.get(i);
            System.out.println(i + ": " + "?" + "-" + "?");
        }
    }

    public int calcularPuntuacion() {
        int totalPuntos = 0;
        for (FichaDomino ficha : fichas) {
            totalPuntos += ficha.getLadoA() + ficha.getLadoB();
        }
        return totalPuntos;
    }
}
