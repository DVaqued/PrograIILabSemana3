package sudoku;

public abstract class ClaseExtiendeSudoku implements Sudoku {

    protected int[][] tablero = new int[9][9];

    @Override
    public void llenarCelda(int fila, int columna, int valor) {
        if (esValido(fila, columna, valor)) {
            tablero[fila][columna] = valor;
        }
    }

    @Override
    public int[][] obtenerTablero() {
        return tablero;
    }
}
