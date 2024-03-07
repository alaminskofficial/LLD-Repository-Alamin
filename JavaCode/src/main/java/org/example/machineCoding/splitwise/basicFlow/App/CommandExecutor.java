package org.example.machineCoding.splitwise.basicFlow.App;

import java.util.ArrayList;
import java.util.List;

public class CommandExecutor {

    public CommandExecutor(SettleUpUser settleUpUser) {
        commands.add(settleUpUser);
    }

    private List<Command> commands = new ArrayList<>();

    public void addCommand(Command command){
        commands.add(command);
    }

    public void removeCommand(Command command){
        commands.remove(command);
    }

    public void execute(String input){
        for(Command command: commands){
            if(command.matches(input)){
                command.execute(input);
                break;
            }
        }
    }
}
