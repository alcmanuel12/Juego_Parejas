import java.util.Scanner;

public class JuegoParejas {
    public static int filas = 4;
    public static int columnas = 4;
    private static int[][] tablero = new int[filas][columnas]; // Tablero como variable de instancia

    public static void RellenarArray() {
        System.out.println("Escriba 16 números para rellenar el tablero.");
        System.out.println("Cada número debe estar entre 1 y 8, y repetirse exactamente dos veces.");
        Scanner pedirNumero = new Scanner(System.in);
        int[] contador = new int[9];

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
    }

    public static void chequearNumeros(int[][] tablero) {
        Scanner scanner = new Scanner(System.in);
        int fila1, columna1, fila2, columna2;

        System.out.println("Introduce la fila y columna del primer número: ");
        fila1 = scanner.nextInt();
        columna1 = scanner.nextInt()-1;

        System.out.println("Introduce la fila y columna del segundo número: ");
        fila2 = scanner.nextInt();
        columna2 = scanner.nextInt()-1;

        if (tablero[fila1][columna1] == tablero[fila2][columna2]) {
            System.out.println("¡Correcto! Los números son iguales.");
        } else {
            System.out.println("Incorrecto. Los números no son iguales.");
        }
        scanner.close();
    }
    public static void main(String[] args) {
        RellenarArray();
        chequearNumeros(tablero);
    }
}
