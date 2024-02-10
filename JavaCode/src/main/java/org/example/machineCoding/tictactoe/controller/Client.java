package org.example.machineCoding.tictactoe.controller;
//@Author : Sk Alamin
import org.example.machineCoding.tictactoe.entities.*;
import org.example.machineCoding.tictactoe.exception.DuplicateSymbolForPlayer;
import org.example.machineCoding.tictactoe.exception.MoreThanOneBotException;
import org.example.machineCoding.tictactoe.exception.PlayersAndBoardCountMismatch;
import org.example.machineCoding.tictactoe.strategy.ColWinningStrategy;
import org.example.machineCoding.tictactoe.strategy.DiagonalWinningStrategy;
import org.example.machineCoding.tictactoe.strategy.RowWinningStrategy;
import org.example.machineCoding.tictactoe.strategy.WinningStrategy;

import java.util.ArrayList;
import java.util.List;

public class Client {
    public static void main(String[] args) throws PlayersAndBoardCountMismatch, DuplicateSymbolForPlayer, MoreThanOneBotException {
        GameController gameController = new GameController();

        int dimension = 4;
        List<Player> players = new ArrayList<>();

        players.add(new HumanPlayer('X', "Alamin", 1, PlayerType.HUMAN));
        players.add(new Bot('0', "GPT", 2, PlayerType.BOT, DifficultyLevel.EASY));
        players.add(new HumanPlayer('K', "Sk", 3, PlayerType.HUMAN));

        ArrayList<WinningStrategy> winningStrategies = new ArrayList<>();
        winningStrategies.add(new RowWinningStrategy());
        winningStrategies.add(new ColWinningStrategy());
        winningStrategies.add(new DiagonalWinningStrategy());

        Game game = gameController.createGame(dimension, players, winningStrategies);
        gameController.printBoard(game);
    }
}
