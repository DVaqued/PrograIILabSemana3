package sudoku;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Tablero extends JFrame implements ActionListener {
    private int rows = 9;
    private int columns = 9;
    private JButton[][] button = new JButton[9][9];
    private int[][] sudokuGrid = new int[9][9];
    private VerificadorSudoku verificadorSudoku = new VerificadorSudoku();

    public Tablero() {
        initComponents();
    }

    public void initComponents() {
        this.setLayout(new GridLayout(9, 9, 2, 2));
        this.setSize(600, 600);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < columns; c++) {
                button[r][c] = new JButton();
                button[r][c].setPreferredSize(new Dimension(50, 50));
                button[r][c].addActionListener(this);
                this.add(button[r][c]);
            }
        }

        this.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JButton sourceButton = (JButton) e.getSource();
        String respuesta = JOptionPane.showInputDialog(null, "Ingresar un número del 1-9:");

        if (respuesta == null) {
            return;
        }

        if (respuesta.matches("[1-9]")) {
            int value = Integer.parseInt(respuesta);
            sourceButton.setText(String.valueOf(value));
            
            for (int r = 0; r < rows; r++) {
                for (int c = 0; c < columns; c++) {
                    if (button[r][c] == sourceButton) {
                        sudokuGrid[r][c] = value;
                    }
                }
            }
            verificarGanador();
        } else {
            JOptionPane.showMessageDialog(this, "Número no válido. Por favor, ingrese un número del 1 al 9.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void verificarGanador() {
        boolean lleno = true;

        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < columns; c++) {
                if (sudokuGrid[r][c] == 0) {
                    lleno = false;
                    break;
                }
            }
        }

        if (lleno) {
            if (verificadorSudoku.esValido(sudokuGrid)) {
                JOptionPane.showMessageDialog(this, "¡Felicidades! Has ganado el juego.", "Fin del Juego", JOptionPane.INFORMATION_MESSAGE);
                System.exit(0);
            } else {
                JOptionPane.showMessageDialog(this, "Has llenado el tablero, pero hay errores. Intenta nuevamente.", "Fin del Juego", JOptionPane.INFORMATION_MESSAGE);
            }
        }
    }

    public static void main(String[] args) {
        new Tablero();
    }
}
