package org.example.machineCoding.tictactoe.entities;

import org.example.machineCoding.tictactoe.exception.DuplicateSymbolForPlayer;
import org.example.machineCoding.tictactoe.exception.MoreThanOneBotException;
import org.example.machineCoding.tictactoe.exception.PlayersAndBoardCountMismatch;
import org.example.machineCoding.tictactoe.strategy.WinningStrategy;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class Game {
    private List<Player> playerList;
    private Board board;
    private Player winner;
    private GameState gameState;
    private int nextPlayerIndex;
    private List<Move> moves;
    private List<WinningStrategy> winningStrategies;
    private Game(List<Player> playerList, int dimension,
                 List<WinningStrategy> winningStrategies) {
        this.nextPlayerIndex = 0;
        this.gameState = GameState.IN_PROGRESS;
        this.moves = new ArrayList<>();
        this.playerList = playerList;
        this.board = new Board(dimension);
        this.winningStrategies = winningStrategies;
    }

    public List<Player> getPlayerList() {
        return playerList;
    }

    public void setPlayerList(List<Player> playerList) {
        this.playerList = playerList;
    }

    public Board getBoard() {
        return board;
    }

    public void setBoard(Board board) {
        this.board = board;
    }

    public Player getWinner() {
        return winner;
    }

    public void setWinner(Player winner) {
        this.winner = winner;
    }

    public GameState getGameState() {
        return gameState;
    }

    public void setGameState(GameState gameState) {
        this.gameState = gameState;
    }

    public int getNextPlayerIndex() {
        return nextPlayerIndex;
    }

    public void setNextPlayerIndex(int nextPlayerIndex) {
        this.nextPlayerIndex = nextPlayerIndex;
    }

    public List<Move> getMoves() {
        return moves;
    }

    public void setMoves(List<Move> moves) {
        this.moves = moves;
    }
    public void printBoard() {
        board.printBoard();
    }
    public static Builder getBuilder(){
        return new Builder();
    }
    public static class Builder {
        private List<Player> players;
        private int dimension;
        private List<WinningStrategy> winningStrategies;
        private Builder(){
            this.dimension = 0;
            this.players = new ArrayList<>();
        }
        public Builder setDimension(int dimension){
            this.dimension = dimension;
            return this;
        }

        public Builder setPlayers(List<Player> players){
            this.players = players;
            return this;
        }

        public Builder setWinningStrategies(List<WinningStrategy> winningStrategies){
            this.winningStrategies = winningStrategies;
            return this;
        }
        public Game build() throws MoreThanOneBotException, PlayersAndBoardCountMismatch, DuplicateSymbolForPlayer {
            // add all the validations
            validateBotCount();
            validateDimensionAndPlayerCount();
            validateUniqueSymbolForEachPlayer();
            return new Game(players, dimension, winningStrategies);
        }
        private void validateUniqueSymbolForEachPlayer() throws DuplicateSymbolForPlayer {

            HashSet<Character> symbols = new HashSet<>();
            for(Player player: players){
                if(symbols.contains(player.getSymbol())){
                    throw new DuplicateSymbolForPlayer();
                }
                symbols.add(player.getSymbol());
            }
        }

        private void validateDimensionAndPlayerCount() throws PlayersAndBoardCountMismatch {

            if(players.size()!=(dimension-1)){
                throw new PlayersAndBoardCountMismatch();
            }
        }
        private void validateBotCount() throws MoreThanOneBotException {
            int botCount = 0;
            for(Player player: players){
                if (player.getPlayerType().equals(PlayerType.BOT)) {
                    botCount++;
                }
                if(botCount>1){
                    throw new MoreThanOneBotException();
                }
            }
        }

    }


}
