# Matching Pairs Game

## Description
**JuegoParejas** is a memory game where two players take turns finding pairs of numbers on a 4x4 board. Each number, from 1 to 8, appears exactly twice on the board. The goal is to find all pairs before the opponent. The game ends when all pairs are found or when a player reaches 5 points.

## Main Features
- **Game Board:** 4 rows by 4 columns.
- **Gameplay:**
  - Two players take turns selecting positions on the board.
  - A point is awarded for each matching pair found.
  - The game ends when all pairs are found or a player reaches 5 points.
- **Game Flow Control:**
  - Turn alternation.
  - Validation of selections.
  - Display of final results.

## Project Structure

### Global Variables
- `filas` and `columnas`: Board dimensions.
- `tablero`: 2D array containing hidden numbers.
- `tableroVisible`: 2D array representing the visible state of the board.
- `puntuacionJugador1` and `puntuacionJugador2`: Arrays storing pairs found by each player.
- `fila1, columna1, fila2, columna2`: Variables for selected positions.
- `juegoEnCurso`: Boolean indicating if the game is still ongoing.
- `turno1`: Boolean indicating if it's player 1's turn.
- `puntosJugador1` and `puntosJugador2`: Players' accumulated scores.

### Main Methods
1. `RellenarArray()`: Requests the user to fill the board with numbers.
2. `mostrarTablero()`: Displays the current state of the visible board.
3. `chequearNumeros(int[][] tablero)`: Manages the game logic, checking for matches.
4. `finalizarJuego()`: Displays the final scores and the numbers found by each player.
5. `main(String[] args)`: The main entry point of the game.

## Usage Instructions
1. Compile the code with:
   ```bash
   javac JuegoParejas.java
   ```
2. Run the game with:
   ```bash
   java JuegoParejas
   ```
3. Follow the on-screen instructions to input numbers and play.

## Example of Use
```plaintext
Enter 16 numbers to fill the board.
Each number must be between 1 and 8 and repeated exactly twice.
Enter the number for position [0][0]: 1
Enter the number for position [0][1]: 2
...
```

## Requirements
- **Java 8 or higher**.
- Java runtime environment configured.

## Author
Developed by Manuel Alcántara, Sammy Cabello, Álvaro Rodríguez & Manuel Vega

## License
This project is distributed under the MIT license.

