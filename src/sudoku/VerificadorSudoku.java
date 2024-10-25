package sudoku;

public class VerificadorSudoku {
    public boolean esValido(int[][] tablero) {
        for (int i = 0; i < 9; i++) {
            if (!esFilaValida(tablero, i) || !esColumnaValida(tablero, i) || !esCajaValida(tablero, i)) {
                return false;
            }
        }
        return true;
    }

    private boolean esFilaValida(int[][] tablero, int fila) {
        boolean[] presente = new boolean[10];
        for (int col = 0; col < 9; col++) {
            int valor = tablero[fila][col];
            if (valor != 0) {
                if (presente[valor]) {
                    return false;
                }
                presente[valor] = true;
            }
        }
        return true;
    }

    private boolean esColumnaValida(int[][] tablero, int columna) {
        boolean[] presente = new boolean[10];
        for (int fila = 0; fila < 9; fila++) {
            int valor = tablero[fila][columna];
            if (valor != 0) {
                if (presente[valor]) {
                    return false;
                }
                presente[valor] = true;
            }
        }
        return true;
    }

    private boolean esCajaValida(int[][] tablero, int caja) {
        boolean[] presente = new boolean[10];
        int filaInicio = (caja / 3) * 3;
        int colInicio = (caja % 3) * 3;

        for (int fila = filaInicio; fila < filaInicio + 3; fila++) {
            for (int col = colInicio; col < colInicio + 3; col++) {
                int valor = tablero[fila][col];
                if (valor != 0) {
                    if (presente[valor]) {
                        return false;
                    }
                    presente[valor] = true;
                }
            }
        }
        return true;
    }
}
