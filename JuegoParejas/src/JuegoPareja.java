import java.util.Scanner;

public class JuegoPareja {

    public static int filas = 4;
    public static int columnas = 4;
    private static int[][] tablero = new int[filas][columnas]; // Tablero como variable de instancia

    public static void RellenarArray() {
        System.out.println("Escriba 16 números para rellenar el tablero.");
        System.out.println("Cada número debe estar entre 1 y 8, y repetirse exactamente dos veces.");
        Scanner pedirNumero = new Scanner(System.in);
        int[] contador = new int[9]; // Array para contar las repeticiones de cada número (1-8)

        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < columnas; j++) {
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
        pedirNumero.close(); // Cerrar el Scanner
    }

    /* public static void imprimirTablero() {
        System.out.println("Tablero rellenado:");
        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < columnas; j++) {
                System.out.print(tablero[i][j] + " ");
            }
            System.out.println();
        }
    } */

    public static void main(String[] args) {
        RellenarArray();
        /* imprimirTablero(); */
    }
}