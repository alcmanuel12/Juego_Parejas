import java.util.Scanner;

public class JuegoParejas {
    // Definición de las dimensiones del tablero
    public static int filas = 4;
    public static int columnas = 4;
    // Tablero del juego representado como una matriz 2D
    private static int[][] tablero = new int[filas][columnas];

    // Método para rellenar el tablero con números proporcionados por el usuario
    public static void RellenarArray() {
        System.out.println("¡Hola Game Master! Bienvenido al juego de las parejas. Rellena el tablero como consideres.");
        System.out.println("Escribe 16 números para rellenarlo.");
        System.out.println("Cada número debe estar entre 1 y 8, y repetirse exactamente dos veces.");
        Scanner pedirNumero = new Scanner(System.in);
        int[] contador = new int[9]; // Array para contar las repeticiones de cada número

        // Bucle para rellenar el tablero
        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < columnas; j++) {
                boolean valido = false;
                while (!valido) {
                    System.out.print("Introduce el número para la posición [" + i + "][" + j + "]: ");
                    int numero = pedirNumero.nextInt();
                    // Validar que el número esté entre 1 y 8 y no se haya repetido más de dos veces
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

    // Método para que los jugadores seleccionen y comparen números en el tablero
    public static void chequearNumeros(int[][] puntuaciones, int jugadorActual) {
        Scanner scanner = new Scanner(System.in);
        int fila1, columna1, fila2, columna2;
        boolean casillaValida;

        System.out.println("Turno del jugador " + (jugadorActual + 1));
        System.out.println("Ahora puedes elegir dos casillas para ver si los números que contiene son iguales. Recuerda que la primera casilla es la 1 1");
        mostrarTablero();

        // Selección de la primera casilla
        do {
            System.out.print("Introduce la fila y columna del primer número siguiendo el formato NumeroFila NumeroColumna, p.e. 1 1: ");
            fila1 = scanner.nextInt() - 1;
            columna1 = scanner.nextInt() - 1;
            casillaValida = fila1 >= 0 && fila1 < filas && columna1 >= 0 && columna1 < columnas && tablero[fila1][columna1] != 0;
            if (!casillaValida) {
                System.out.println("Posición no válida o ya destapada. Inténtalo de nuevo.");
            }
        } while (!casillaValida);

        // Selección de la segunda casilla
        do {
            System.out.print("Introduce la fila y columna del segundo número siguiendo el formato NumeroFila NumeroColumna, p.e. 1 1: ");
            fila2 = scanner.nextInt() - 1;
            columna2 = scanner.nextInt() - 1;
            casillaValida = fila2 >= 0 && fila2 < filas && columna2 >= 0 && columna2 < columnas && tablero[fila2][columna2] != 0 && !(fila1 == fila2 && columna1 == columna2);
            if (!casillaValida) {
                System.out.println("Posición no válida o ya destapada. Inténtalo de nuevo.");
            }
        } while (!casillaValida);

        // Comprobación de si los números seleccionados son iguales
        if (tablero[fila1][columna1] == tablero[fila2][columna2]) {
            System.out.println("¡Correcto! Los números son iguales.");
            puntuaciones[jugadorActual][contarPuntuaciones(puntuaciones[jugadorActual])] = 1;
            tablero[fila1][columna1] = 0; // Sustituir por 'O'
            tablero[fila2][columna2] = 0; // Sustituir por 'O'
        } else {
            System.out.println("Incorrecto. Los números no son iguales.");
            puntuaciones[jugadorActual][contarPuntuaciones(puntuaciones[jugadorActual])] = 0;
        }

        mostrarTablero();
        System.out.println("Puntuaciones: Jugador 1 - " + contarPuntuaciones(puntuaciones[0]) + ", Jugador 2 - " + contarPuntuaciones(puntuaciones[1]));
    }

    // Método para mostrar el estado actual del tablero
    public static void mostrarTablero() {
        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < columnas; j++) {
                if (tablero[i][j] == 0) {
                    System.out.print("O "); // Mostrar 'O' para casillas destapadas
                } else {
                    System.out.print("X "); // Mostrar 'X' para casillas no destapadas
                }
            }
            System.out.println();
        }
    }

    // Método para contar las puntuaciones de un jugador
    public static int contarPuntuaciones(int[] puntuaciones) {
        int count = 0;
        for (int puntuacion : puntuaciones) {
            if (puntuacion == 1) {
                count++;
            }
        }
        return count;
    }

    // Método principal que inicia el juego
    public static void main(String[] args) {
        RellenarArray(); // Rellenar el tablero con números
        int[][] puntuaciones = new int[2][8]; // Array de puntuaciones para dos jugadores
        int jugadorActual = 0; // 0 para el primer jugador, 1 para el segundo jugador

        // Bucle principal del juego
        while (true) {
            chequearNumeros(puntuaciones, jugadorActual); // Turno del jugador actual
            if (contarPuntuaciones(puntuaciones[jugadorActual]) == 4) { // Comprobar si el jugador ha ganado
                System.out.println("¡Felicidades Jugador " + (jugadorActual + 1) + "! Has ganado el juego.");
                break; // Salir del bucle si hay un ganador
            }
            jugadorActual = (jugadorActual + 1) % 2; // Cambiar de turno
        }
    }
}