package org.example.machineCoding.tictactoe.strategy;

import org.example.machineCoding.tictactoe.entities.Board;
import org.example.machineCoding.tictactoe.entities.Move;

public class RowWinningStrategy implements WinningStrategy{
    @Override
    public boolean checkWinner(Board board, Move move) {
        return false;
    }
}
