package org.example.machineCoding.tictactoe.controller;

import org.example.machineCoding.tictactoe.entities.*;
import org.example.machineCoding.tictactoe.exception.DuplicateSymbolForPlayer;
import org.example.machineCoding.tictactoe.exception.MoreThanOneBotException;
import org.example.machineCoding.tictactoe.exception.PlayersAndBoardCountMismatch;
import org.example.machineCoding.tictactoe.strategy.WinningStrategy;

import java.util.List;

public class GameController {
    public Game createGame(int dimension, List<Player> playerList,
                           List<WinningStrategy> winningStrategyList)
            throws PlayersAndBoardCountMismatch, DuplicateSymbolForPlayer, MoreThanOneBotException {

        return Game.getBuilder()
                .setPlayers(playerList)
                .setDimension(dimension)
                .setWinningStrategies(winningStrategyList)
                .build();
    }

    public void printBoard(Game game){

        game.printBoard();
    }

}
