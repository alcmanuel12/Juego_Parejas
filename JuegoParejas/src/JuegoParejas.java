import java.util.Scanner;

public class JuegoParejas {
    public static int filas = 4;
    public static int columnas = 4;
    private static int[][] tablero = new int[filas][columnas]; // Tablero como variable de instancia
    private static String[][] tableroVisible = new String[filas][columnas];
    private static int[] puntuacionJugador1 = new int[8];
    private static int[] puntuacionJugador2 = new int[8];

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

    public static void chequearNumeros(int[][] tablero) {
        Scanner checker = new Scanner(System.in);
        int fila1, columna1, fila2, columna2;
        boolean juegoEnCurso = true;
        boolean turno1 = true;
        while (juegoEnCurso == true) {
            while (turno1 == true) {

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

                    if (tablero[fila1][columna1] == tablero[fila2][columna2]) {
                        System.out.println("¡Correcto! Los números son iguales.");
                        System.out.println("-------------------------------------");
                        tableroVisible[fila1][columna1] = "0";
                        tableroVisible[fila2][columna2] = "0";
                    } else {
                        System.out.println("Incorrecto. Los números no son iguales.");
                        System.out.println("-------------------------------------");
                        turno1 = false;
                    }

                } catch (Exception e) {
                    System.err.println("Los números deben estar comprendidos entre 1 y 4");
                }
                mostrarTablero();
            }
            while (turno1 == true) {

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

                    if (tablero[fila1][columna1] == tablero[fila2][columna2]) {
                        System.out.println("¡Correcto! Los números son iguales.");
                        System.out.println("-------------------------------------");
                        tableroVisible[fila1][columna1] = "0";
                        tableroVisible[fila2][columna2] = "0";
                    } else {
                        System.out.println("Incorrecto. Los números no son iguales.");
                        System.out.println("-------------------------------------");
                        turno1 = false;
                    }

                } catch (Exception e) {
                    System.err.println("Los números deben estar comprendidos entre 1 y 4");
                }
                mostrarTablero();
            }
        }
        checker.close();
    }

    public static void main(String[] args) {
        RellenarArray();
        chequearNumeros(tablero);
    }
}
