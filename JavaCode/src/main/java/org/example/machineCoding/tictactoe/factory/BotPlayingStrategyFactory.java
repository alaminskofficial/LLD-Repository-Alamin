package org.example.machineCoding.tictactoe.factory;

import org.example.designpattern.factory.AndroidUIFactory;
import org.example.designpattern.factory.IosUIFactory;
import org.example.designpattern.factory.WebUiFactory;
import org.example.machineCoding.tictactoe.entities.DifficultyLevel;
import org.example.machineCoding.tictactoe.strategy.BotPlayingStrategy;
import org.example.machineCoding.tictactoe.strategy.EasyBotPlayingStrategy;
import org.example.machineCoding.tictactoe.strategy.HardBotPlayingStrategy;
import org.example.machineCoding.tictactoe.strategy.MediumBotPlayingStrategy;

public class BotPlayingStrategyFactory {
    public static BotPlayingStrategy getBotPlayingStrategy(DifficultyLevel difficultyLevel) {
        return switch(difficultyLevel){
            case EASY -> new EasyBotPlayingStrategy();
            case MEDIUM -> new MediumBotPlayingStrategy();
            case HARD ->  new HardBotPlayingStrategy();
        };
    }
}
