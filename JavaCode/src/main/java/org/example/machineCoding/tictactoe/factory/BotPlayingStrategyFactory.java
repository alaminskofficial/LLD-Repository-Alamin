package org.example.machineCoding.tictactoe.factory;

import org.example.machineCoding.tictactoe.entities.DifficultyLevel;
import org.example.machineCoding.tictactoe.strategy.BotPlayingStrategy;
import org.example.machineCoding.tictactoe.strategy.EasyBotPlayingStrategy;

public class BotPlayingStrategyFactory {
    public static BotPlayingStrategy getBotPlayingStrategy(DifficultyLevel difficultyLevel) {
        // w.r.t difficulty level ...
        return new EasyBotPlayingStrategy();
    }
}
