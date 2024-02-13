package org.example.machineCoding.tictactoe.strategy;

import org.example.machineCoding.tictactoe.entities.Board;
import org.example.machineCoding.tictactoe.entities.Move;
import org.example.machineCoding.tictactoe.entities.Player;

import java.util.HashMap;
import java.util.Map;

public class ColWinningStrategy implements WinningStrategy{
    Map<Integer, Map<Character, Integer>> colMaps = new HashMap<>();
    @Override
    public boolean checkWinner(Board board, Move move) {
        int col = move.getCell().getCol();
        Character symbol = move.getPlayer().getSymbol();
        // create new hashmap
        if(!colMaps.containsKey(col)){
            colMaps.put(col, new HashMap<>());
        }
        //put the symbol and it's frequency
        Map<Character, Integer> colMap = colMaps.get(col);
        if(!colMap.containsKey(symbol)){
            colMap.put(symbol, 0);
        }
        colMap.put(symbol, colMap.get(symbol)+1);
        // winning condition
        if(colMap.get(symbol).equals(board.getDimension())){
            return true;
        }
        return false;
    }

    @Override
    public void handleUndo(Board board, Move lastMove) {
        Character symbol = lastMove.getPlayer().getSymbol();
        int col = lastMove.getCell().getCol();

        Map<Character, Integer> colMap = colMaps.get(col);
        colMap.put(symbol, colMap.get(symbol)-1);
    }
}
