import java.util.Scanner;
public class JuegoPareja {

}
    public static void main(String[] args) {
        int filas = 4;
        int columnas = 4;
        int[][] tablero = new int[filas][columnas];
        System.out.println("Escriba 16 números para rellenar el tablero. Cada numero se pondrá en una posición de la matriz por orden. Solo pueden usarse numeros del 1 al 8, y cada numero debe repetirse dos veces.");
        Scanner pedirNumero = new Scanner(System.in);
        for (int i = 0; i < filas; i++) { // Iterar sobre las filas
            for (int j = 0; j < columnas; j++) { // Iterar sobre las columnas
                System.out.print("Introduce el número para la posición [" + i + "][" + j + "]: ");
                tablero[i][j] = pedirNumero.nextInt(); // Leer el número y asignarlo a la matriz
            }
        }       
}