import java.util.Scanner;

public class JuegoParejas {
    // Variables globales
    public static int filas = 4;
    public static int columnas = 4;
    private static int[][] tablero = new int[filas][columnas];
    private static String[][] tableroVisible = new String[filas][columnas];
    private static int[] puntuacionJugador1 = new int[8];
    private static int[] puntuacionJugador2 = new int[8];
    private static int fila1, columna1, fila2, columna2;
    private static boolean juegoEnCurso = true;
    private static boolean turno1 = true;
    private static int puntosJugador1 = 0;
    private static int puntosJugador2 = 0;

    // Rellena el tablero con números proporcionados por el usuario
    public static void RellenarArray() {
        System.out.println("Escriba 16 números para rellenar el tablero.");
        System.out.println("Cada número debe estar entre 1 y 8, y repetirse exactamente dos veces.");
        Scanner pedirNumero = new Scanner(System.in);
        int[] contador = new int[9]; // Array para contar las repeticiones de cada número (1-8)

        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < columnas; j++) {
                tableroVisible[i][j] = "X";
                boolean valido = false;
                while (!valido) {
                    System.out.print("Introduce el número para la posición [" + i + "][" + j + "]: ");
                    int numero = pedirNumero.nextInt();

                    if (numero >= 1 && numero <= 8 && contador[numero] < 2) {
                        tablero[i][j] = numero;
                        contador[numero]++;
                        valido = true;
                    } else {
                        System.out.println("Número no válido. Debe estar entre 1 y 8, y no exceder dos repeticiones.");
                    }
                }
            }
        }
        mostrarTablero();
    }

    // Muestra el tablero visible
    public static void mostrarTablero() {
        int contador = 0;
        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < columnas; j++) {
                System.out.print(tableroVisible[i][j] + " ");
                contador++;
                if (contador == 4) {
                    System.out.print("\n");
                    contador = 0;
                }
            }
        }
    }

    // Lógica del juego para chequear los números seleccionados por los jugadores
    public static void chequearNumeros(int[][] tablero) {
        Scanner checker = new Scanner(System.in);

        while (juegoEnCurso == true) {
            while (juegoEnCurso == true && turno1 == true) {
                System.out.println("\nTURNO JUGADOR 1");
                try {
                    System.out.println("-------------------------------------");
                    System.out.print("Introduce la fila y columna del primer número: ");
                    fila1 = checker.nextInt() - 1;
                    columna1 = checker.nextInt() - 1;
                    System.out.println("Has destapado el número " + tablero[fila1][columna1]);

                    System.out.print("Introduce la fila y columna del segundo número: ");
                    fila2 = checker.nextInt() - 1;
                    columna2 = checker.nextInt() - 1;
                    System.out.println("Has destapado el número " + tablero[fila2][columna2]);

                    boolean yaSeleccionado = false;
                    for (int i = 0; i < puntuacionJugador1.length; i++) {
                        if (tablero[fila1][columna1] == puntuacionJugador1[i]
                                || tablero[fila2][columna2] == puntuacionJugador1[i]) {
                            System.out.println("Este número ya ha sido resuelto.");
                            yaSeleccionado = true;
                        }
                    }

                    if (tablero[fila1][columna1] == tablero[fila2][columna2] && yaSeleccionado == false) {
                        System.out.println("¡Correcto! Los números son iguales.");
                        System.out.println("-------------------------------------");
                        tableroVisible[fila1][columna1] = "0";
                        tableroVisible[fila2][columna2] = "0";
                        puntuacionJugador1[puntosJugador1] = tablero[fila1][columna1];
                        puntosJugador1++;
                        System.out.println("El jugador 1 ahora tiene " + puntosJugador1 + " puntos.\n");
                        if (puntosJugador1 >= 5) {
                            juegoEnCurso = false;
                            System.out.println("¡El jugador 1 gana la partida!");
                        } else if (puntosJugador1 == 4 && puntosJugador2 == 4) {
                            System.out.println("¡Empate! Partida terminada.");
                            juegoEnCurso = false;
                        }
                    } else {
                        System.out.println(
                                "Incorrecto. Los números no son iguales o ya han sido seleccionados. Pierdes el turno.");
                        System.out.println("-------------------------------------");
                        turno1 = false;
                        yaSeleccionado = false;
                    }

                } catch (Exception e) {
                    System.err.println("Los números deben estar comprendidos entre 1 y 4");
                }
                mostrarTablero();
            }
            while (juegoEnCurso == true && turno1 == false) {
                System.out.println("\nTURNO JUGADOR 2");
                try {
                    System.out.println("-------------------------------------");
                    System.out.print("Introduce la fila y columna del primer número: ");
                    fila1 = checker.nextInt() - 1;
                    columna1 = checker.nextInt() - 1;
                    System.out.println("Has destapado el número " + tablero[fila1][columna1]);

                    System.out.print("Introduce la fila y columna del segundo número: ");
                    fila2 = checker.nextInt() - 1;
                    columna2 = checker.nextInt() - 1;
                    System.out.println("Has destapado el número " + tablero[fila2][columna2]);

                    boolean yaSeleccionado = false;
                    for (int i = 0; i < puntuacionJugador2.length; i++) {
                        if (tablero[fila1][columna1] == puntuacionJugador2[i]
                                || tablero[fila2][columna2] == puntuacionJugador2[i]) {
                            System.out.println("Este número ya ha sido resuelto.");
                            yaSeleccionado = true;
                        }
                    }

                    if (tablero[fila1][columna1] == tablero[fila2][columna2] && yaSeleccionado == false) {
                        System.out.println("¡Correcto! Los números son iguales.");
                        System.out.println("-------------------------------------");
                        tableroVisible[fila1][columna1] = "0";
                        tableroVisible[fila2][columna2] = "0";
                        puntuacionJugador2[puntosJugador2] = tablero[fila1][columna1];
                        puntosJugador2++;
                        System.out.println("El jugador 2 ahora tiene " + puntosJugador2 + " puntos.\n");
                        if (puntosJugador2 >= 5) {
                            juegoEnCurso = false;
                            System.out.println("¡El jugador 2 gana la partida!");
                        } else if (puntosJugador1 == 4 && puntosJugador2 == 4) {
                            System.out.println("¡Empate! Partida terminada.");
                            juegoEnCurso = false;
                        }
                    } else {
                        System.out.println(
                                "Incorrecto. Los números no son iguales o ya han sido seleccionados. Pierdes el turno.");
                        System.out.println("-------------------------------------");
                        turno1 = true;
                        yaSeleccionado = false;
                    }

                } catch (Exception e) {
                    System.err.println("Los números deben estar comprendidos entre 1 y 4");
                }
                mostrarTablero();
            }
        }
        checker.close();
    }

    // Muestra la puntuación final del juego
    public static void finalizarJuego() {
        System.out.println("\nPUNTUACIÓN FINAL");
        System.out.println("Jugador1:  " + puntosJugador1 + " puntos.");
        System.out.println("Números acertados del jugador 1: ");
        for (int i = 0; i < puntuacionJugador1.length; i++) {
            if (puntuacionJugador1[i] != 0) {
                System.out.print(puntuacionJugador1[i] + " ");
            }
        }
        System.out.println("\nJugador2:  " + puntosJugador2 + " puntos.");
        System.out.println("Números acertados del jugador 2: ");
        for (int i = 0; i < puntuacionJugador2.length; i++) {
            if (puntuacionJugador2[i] != 0) {
                System.out.print(puntuacionJugador2[i] + " ");
            }
        }
    }

    // Método principal que inicia el juego
    public static void main(String[] args) {
        RellenarArray();
        chequearNumeros(tablero);
        finalizarJuego();
    }
}
