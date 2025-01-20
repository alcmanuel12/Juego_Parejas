import java.util.Scanner;
public class Juego {
    public static void main(String[] args){

    Scanner check= new Scanner(System.in);
    //Aqui se pide que se indique la posicion que queremos ver
    System.out.println("Indique una fila: ");
    int fila= check.nextInt();
    System.out.println("Indique una columna: ");
    int columna= check.nextInt();

    //Aqui se imprime por pantalla el numero que hay en la posicion que hemos marcado antes
    System.out.println("En la fila " + fila + " columna " + columna + "esta el numero: " + tablero[fila][columna]);
    
    
    }
}

