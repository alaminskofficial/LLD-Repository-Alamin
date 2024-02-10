package org.example.machineCoding.tictactoe.strategy;

import org.example.machineCoding.tictactoe.entities.Board;
import org.example.machineCoding.tictactoe.entities.Cell;
import org.example.machineCoding.tictactoe.entities.CellState;

import java.util.List;

public class EasyBotPlayingStrategy implements BotPlayingStrategy{
    @Override
    public Cell makeMove(Board board) {
            for(List<Cell> row: board.getBoard()){
                for(Cell cell: row){
                    if (CellState.EMPTY.equals(cell.getCellState())) {
                        return cell;
                    }
                }
            }
            return null;
    }
}
