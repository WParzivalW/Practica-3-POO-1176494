import java.util.*;
/**
 * Write a description of class main here.
 * 
 * @author (Luis Manuel Deniz Ramirez (1176494)) 
 * @version (Versión 2.0)
 */
public class main
{
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Bienvenido al juego de Dominó");
        System.out.println("¿Cuántos jugadores participarán? (2-4): ");
        int numJugadores = scanner.nextInt();
        scanner.nextLine(); // Consumir el salto de línea

        System.out.println("¿Cuál es el objetivo de puntos para ganar el juego?");
        int objetivoPuntos = scanner.nextInt();
        scanner.nextLine(); // Consumir el salto de línea

        JuegoDomino juego = new JuegoDomino(numJugadores, objetivoPuntos);
        juego.jugar();

        scanner.close();
    }
}
