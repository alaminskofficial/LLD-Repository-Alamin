package org.example.machineCoding.tictactoe.entities;

import org.example.machineCoding.tictactoe.factory.BotPlayingStrategyFactory;
import org.example.machineCoding.tictactoe.strategy.BotPlayingStrategy;

public class Bot extends Player{
    private DifficultyLevel difficultyLevel;
    private BotPlayingStrategy botPlayingStrategy;

    public Bot(Character symbol, String name, int id, PlayerType playerType,DifficultyLevel difficultyLevel) {
        super(symbol, name, id, playerType);
        this.difficultyLevel = difficultyLevel;
        this.botPlayingStrategy = BotPlayingStrategyFactory.getBotPlayingStrategy(difficultyLevel);
    }
    public DifficultyLevel getDifficultyLevel() {
        return difficultyLevel;
    }
    public void setDifficultyLevel(DifficultyLevel difficultyLevel) {
        this.difficultyLevel = difficultyLevel;
    }
    public BotPlayingStrategy getBotPlayingStrategy() {
        return botPlayingStrategy;
    }
    public void setBotPlayingStrategy(BotPlayingStrategy botPlayingStrategy) {
        this.botPlayingStrategy = botPlayingStrategy;
    }
}
