package org.example.machineCoding.tictactoe.strategy;

import org.example.machineCoding.tictactoe.entities.Board;
import org.example.machineCoding.tictactoe.entities.Move;
import org.example.machineCoding.tictactoe.entities.Player;

import java.util.HashMap;
import java.util.Map;

public class RowWinningStrategy implements WinningStrategy{
    Map<Integer, Map<Character, Integer>> rowMaps = new HashMap<>();

    @Override
    public boolean checkWinner(Board board, Move move) {
        int row = move.getCell().getRow();
        Character symbol = move.getPlayer().getSymbol();

        if(!rowMaps.containsKey(row)){
            rowMaps.put(row, new HashMap<>());
        }

        Map<Character, Integer> rowMap = rowMaps.get(row);
        if(!rowMap.containsKey(symbol)){
            rowMap.put(symbol, 0);
        }
        rowMap.put(symbol, rowMap.get(symbol)+1);

        if(rowMap.get(symbol).equals(board.getDimension())){
            return true;
        }
        return false;
    }
    @Override
    public void handleUndo(Board board, Move lastMove) {
        int row = lastMove.getCell().getRow();
        Character symbol = lastMove.getPlayer().getSymbol();

        Map<Character, Integer> rowMap = rowMaps.get(row);
        rowMap.put(symbol, rowMap.get(symbol)-1);
    }
}
