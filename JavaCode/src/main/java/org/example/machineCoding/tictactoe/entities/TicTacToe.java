package org.example.machineCoding.tictactoe.entities;
//@Author Sk Alamin
//Core logic to find a winner in TC: O(1)
import java.util.HashMap;
import java.util.Map;

public class TicTacToe {
    private int n;
    private Map<Integer, Integer>[] rowMaps;
    private Map<Integer, Integer>[] colMaps;
    private Map<Integer, Integer> mainDiagonalMap;
    private Map<Integer, Integer> antiDiagonalMap;

    public TicTacToe(int n) {
        this.n = n;
        this.rowMaps = new HashMap[n];
        this.colMaps = new HashMap[n];
        for (int i = 0; i < n; i++) {
            rowMaps[i] = new HashMap<>();
            colMaps[i] = new HashMap<>();
        }
        this.mainDiagonalMap = new HashMap<>();
        this.antiDiagonalMap = new HashMap<>();
    }

    public int move(int row, int col, int player) {
        // Update the frequency of the player's symbol in the corresponding row, column, and diagonals
        rowMaps[row].put(player, rowMaps[row].getOrDefault(player, 0) + 1);
        colMaps[col].put(player, colMaps[col].getOrDefault(player, 0) + 1);

        if (row == col) {
            mainDiagonalMap.put(player, mainDiagonalMap.getOrDefault(player, 0) + 1);
        }

        if (row + col == n - 1) {
            antiDiagonalMap.put(player, antiDiagonalMap.getOrDefault(player, 0) + 1);
        }

        // Check if the player has reached 3 frequency in any row, column, or diagonals
        if (checkWinner(rowMaps[row], player) || checkWinner(colMaps[col], player)
                || checkWinner(mainDiagonalMap, player) || checkWinner(antiDiagonalMap, player)) {
            return player; // Player wins
        }

        return 0; // No winner yet
    }
    private boolean checkWinner(Map<Integer, Integer> map, int player) {
        return map.getOrDefault(player, 0) == n;
    }

    public static void main(String[] args) {
        TicTacToe ticTacToe = new TicTacToe(3);
        System.out.println(ticTacToe.move(0, 0, 1));
        System.out.println(ticTacToe.move(0, 2, 1));
        System.out.println(ticTacToe.move(2, 2, 1));
        System.out.println(ticTacToe.move(1, 1, 2));
        System.out.println(ticTacToe.move(0, 0, 1));
    }
}
