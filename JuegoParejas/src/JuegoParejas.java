import java.util.Scanner;

public class JuegoParejas {

    public static void main(String[] args) {
        chequearNumeros(null);
    }

    public static void chequearNumeros(int[][] tablero) {
        Scanner scanner = new Scanner(System.in);
        int fila1, columna1, fila2, columna2;

        System.out.println("Introduce la fila y columna del primer número: ");
        fila1 = scanner.nextInt();
        columna1 = scanner.nextInt();

        System.out.println("Introduce la fila y columna del segundo número: ");
        fila2 = scanner.nextInt();
        columna2 = scanner.nextInt();

        if (tablero[fila1][columna1] == tablero[fila2][columna2]) {
            System.out.println("¡Correcto! Los números son iguales.");
        } else {
            System.out.println("Incorrecto. Los números no son iguales.");
        }


        scanner.close();
    }
    }
