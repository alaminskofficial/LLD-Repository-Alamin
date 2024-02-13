package org.example.machineCoding.tictactoe.app;
//@Author : Sk Alamin
import org.example.machineCoding.tictactoe.controller.GameController;
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
import java.util.Scanner;

public class Client {
    public static void main(String[] args) throws PlayersAndBoardCountMismatch, DuplicateSymbolForPlayer, MoreThanOneBotException {
        GameController gameController = new GameController();
        Scanner scanner = new Scanner(System.in);
        int dimension = 3;
        List<Player> players = new ArrayList<>();

        players.add(new HumanPlayer('X', "Sk Alamin", 1, PlayerType.HUMAN ,scanner));
        //players.add(new Bot('0', "ChatGPT", 2, PlayerType.BOT, DifficultyLevel.EASY));
        players.add(new HumanPlayer('0',"Khadija" , 2 ,PlayerType.HUMAN , scanner));


        ArrayList<WinningStrategy> winningStrategies = new ArrayList<>();
        winningStrategies.add(new RowWinningStrategy());
        winningStrategies.add(new ColWinningStrategy());
        winningStrategies.add(new DiagonalWinningStrategy());

        Game game = gameController.createGame(dimension, players, winningStrategies);

        while(GameState.IN_PROGRESS.equals(game.getGameState())) {
            gameController.printBoard(game);
            // if somebody wants to make an undo
            System.out.println("Does anyone want to undo ? (y/n");
            String undo = scanner.next();

            if(undo.equalsIgnoreCase("y")){
                gameController.undo(game);
                continue;
            }
            gameController.makeMove(game);
        }

        if(GameState.CONCLUDED.equals(game.getGameState())){
            System.out.println(game.getWinner().getName()+" Has won the game !!!!");
        }
        if(GameState.DRAW.equals(game.getGameState())){
            System.out.println("It's a draw !!!");
        }
    }
}
