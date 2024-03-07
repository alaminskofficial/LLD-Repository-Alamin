package org.example.machineCoding.splitwise.basicFlow.App;

public interface Command {

    void execute(String input);
    boolean matches(String input);
}
