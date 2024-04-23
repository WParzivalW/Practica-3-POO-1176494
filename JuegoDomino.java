import java.util.*;
/**
 * Write a description of class JuegoDomino here.
 * 
 * @author (Luis Manuel Deniz Ramirez(1176494)) 
 * @version (Version 2.0)
 */
public class JuegoDomino
{
    private List<FichaDomino> mazo;
    private List<FichaDomino> pilaExtras;
    private List<Jugador> jugadores;
    private List<FichaDomino> fichasEnMesa;
    private int objetivoPuntos;

    public JuegoDomino(int numJugadores, int objetivoPuntos) {
        this.objetivoPuntos = objetivoPuntos;
        inicializarMazo();
        repartirFichas(numJugadores);
    }

    private void inicializarMazo() {
        mazo = new ArrayList<>();
        for (int i = 0; i <= 6; i++) {
            for (int j = i; j <= 6; j++) {
                mazo.add(new FichaDomino(i, j));
            }
        }
        Collections.shuffle(mazo);
        pilaExtras = new ArrayList<>();
    }

    private void repartirFichas(int numJugadores) {
        jugadores = new ArrayList<>();
        for (int i = 0; i < numJugadores; i++) {
            jugadores.add(new Jugador());
        }
        int numFichasPorJugador = (numJugadores == 2) ? 14 : (numJugadores == 3) ? 9 : 7;
        for (Jugador jugador : jugadores) {
            for (int i = 0; i < numFichasPorJugador; i++) {
                jugador.agregarFicha(mazo.remove(0));
            }
        }
    }

    public void jugar() {
        Scanner scanner = new Scanner(System.in);
        int turno = 0;
        boolean juegoTerminado = false;
        fichasEnMesa = new ArrayList<>();

        while (!juegoTerminado) {
            Jugador jugadorActual = jugadores.get(turno);
            System.out.println("Turno del jugador " + (turno + 1));
            System.out.println("Fichas del jugador: ");
            jugadorActual.mostrarFichas();

            System.out.println("Fichas en la mesa: ");
            mostrarFichasEnMesa();

            System.out.println("¿Desea jugar una ficha? (S/N)");
            String respuesta = scanner.nextLine();
            if (respuesta.equalsIgnoreCase("S")) {
                System.out.println("Ingrese el índice de la ficha que desea jugar: ");
                int indiceFicha = scanner.nextInt();
                scanner.nextLine(); // Consumir el salto de línea
                FichaDomino fichaSeleccionada = jugadorActual.getFicha(indiceFicha);

                if (fichasEnMesa.isEmpty()) {
    fichasEnMesa.add(fichaSeleccionada);
    jugadorActual.removerFicha(indiceFicha);
} else {
    // Mostrar la ficha seleccionada antes de preguntar el extremo
    System.out.print("[" + fichaSeleccionada.getLadoA() + "-" + fichaSeleccionada.getLadoB() + "] ");
    System.out.println("Ingrese el extremo de la ficha donde desea colocarla (izquierda o derecha): ");
    String extremo = scanner.nextLine();
    if (extremo.equalsIgnoreCase("izquierda")) {
        if (puedeColocarFichaEnExtremo(fichaSeleccionada, fichasEnMesa.get(0), true)) {
            fichasEnMesa.add(0, fichaSeleccionada);
            jugadorActual.removerFicha(indiceFicha);
        } else {
            System.out.println("No se puede colocar la ficha en el extremo izquierdo.");
        }
    } else if (extremo.equalsIgnoreCase("derecha")) {
        if (puedeColocarFichaEnExtremo(fichaSeleccionada, fichasEnMesa.get(fichasEnMesa.size() - 1), false)) {
            fichasEnMesa.add(fichaSeleccionada);
            jugadorActual.removerFicha(indiceFicha);
        } else {
            System.out.println("No se puede colocar la ficha en el extremo derecho.");
        }
    } else {
        System.out.println("Opción de extremo no válida.");
    }
}

            } else {
                // El jugador pasa su turno
            }

            // Verificar si el jugador ha alcanzado el objetivo de puntos
            if (jugadorActual.calcularPuntuacion() >= objetivoPuntos) {
                System.out.println("El jugador " + (turno + 1) + " ha alcanzado " + objetivoPuntos + " puntos. ¡Ha ganado el juego!");
                juegoTerminado = true;
            } else {
                turno = (turno + 1) % jugadores.size();
            }
        }

        scanner.close();
    }

    private void mostrarFichasEnMesa() {
        for (FichaDomino ficha : fichasEnMesa) {
            System.out.print("[" + ficha.getLadoA() + "-" + ficha.getLadoB() + "] ");
        }
        System.out.println();
    }
    
    private void intercambiarValores(FichaDomino ficha) {
    int temp = ficha.getLadoA();
    ficha.setLadoA(ficha.getLadoB());
    ficha.setLadoB(temp);
}

   private boolean puedeColocarFichaEnExtremo(FichaDomino fichaNueva, FichaDomino fichaExtremo, boolean izquierda) {
    if (izquierda) {
        if (fichaNueva.getLadoA() == fichaExtremo.getLadoA()) {
            intercambiarValores(fichaNueva);
        }
        return fichaNueva.getLadoA() == fichaExtremo.getLadoA() || fichaNueva.getLadoB() == fichaExtremo.getLadoA();
    } else {
        if (fichaNueva.getLadoB() == fichaExtremo.getLadoB()) {
            intercambiarValores(fichaNueva);
        }
        return fichaNueva.getLadoA() == fichaExtremo.getLadoB() || fichaNueva.getLadoB() == fichaExtremo.getLadoB();
    }
}
}
