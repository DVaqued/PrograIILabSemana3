package sudoku;

public interface Sudoku {

    void llenarCelda(int fila, int columna, int valor);

    boolean esValido(int fila, int columna, int valor);

    int[][] obtenerTablero();
}
