package org.example.machineCoding.tictactoe.strategy;

import org.example.machineCoding.tictactoe.entities.Board;
import org.example.machineCoding.tictactoe.entities.Move;

public interface WinningStrategy {
    boolean checkWinner(Board board, Move move);
}
