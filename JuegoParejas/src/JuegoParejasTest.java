import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.io.ByteArrayInputStream;
import java.io.InputStream;

public class JuegoParejasTest {

    @BeforeEach
    public void setUp() {
        JuegoParejas.filas = 4;
        JuegoParejas.columnas = 4;
        JuegoParejas.tablero = new int[JuegoParejas.filas][JuegoParejas.columnas];
        JuegoParejas.tableroVisible = new String[JuegoParejas.filas][JuegoParejas.columnas];
        JuegoParejas.puntuacionJugador1 = new int[8];
        JuegoParejas.puntuacionJugador2 = new int[8];
        JuegoParejas.fila1 = 0;
        JuegoParejas.columna1 = 0;
        JuegoParejas.fila2 = 0;
        JuegoParejas.columna2 = 0;
        JuegoParejas.juegoEnCurso = true;
        JuegoParejas.turno1 = true;
        JuegoParejas.puntosJugador1 = 0;
        JuegoParejas.puntosJugador2 = 0;
    }

    @Test
    public void testRellenarArray() {
        String input = "1 1 2 2 3 3 4 4 5 5 6 6 7 7 8 8";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        JuegoParejas.RellenarArray();

        int[] contador = new int[9];
        for (int i = 0; i < JuegoParejas.filas; i++) {
            for (int j = 0; j < JuegoParejas.columnas; j++) {
                int numero = JuegoParejas.tablero[i][j];
                assertTrue(numero >= 1 && numero <= 8);
                contador[numero]++;
            }
        }

        for (int i = 1; i <= 8; i++) {
            assertEquals(2, contador[i]);
        }
    }

    @Test
    public void testMostrarTablero() {
        JuegoParejas.tableroVisible = new String[][] {
            {"1", "2", "3", "4"},
            {"5", "6", "7", "8"},
            {"1", "2", "3", "4"},
            {"5", "6", "7", "8"}
        };

        JuegoParejas.mostrarTablero();
    }

    @Test
    public void testChequearNumeros() {
        JuegoParejas.tablero = new int[][] {
            {1, 2, 3, 4},
            {5, 6, 7, 8},
            {1, 2, 3, 4},
            {5, 6, 7, 8}
        };

        String input = "1 1 1 2 2 1 2 2 3 1 3 2 4 1 4 2 1 3 1 4 2 3 2 4 3 3 3 4 4 3 4 4";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        JuegoParejas.chequearNumeros(JuegoParejas.tablero);

        assertFalse(JuegoParejas.juegoEnCurso);
        assertEquals(5, JuegoParejas.puntosJugador1);
        assertEquals(0, JuegoParejas.puntosJugador2);
    }

    @Test
    public void testFinalizarJuego() {
        JuegoParejas.puntosJugador1 = 4;
        JuegoParejas.puntuacionJugador1 = new int[] {1, 2, 3, 4, 0, 0, 0, 0};
        JuegoParejas.puntosJugador2 = 4;
        JuegoParejas.puntuacionJugador2 = new int[] {5, 6, 7, 8, 0, 0, 0, 0};

        JuegoParejas.finalizarJuego();
    }
}