package org.example.machineCoding.splitwise.basicFlow.App;


import org.example.machineCoding.splitwise.basicFlow.controllers.UserController;

public class SettleUpUser implements Command{

    private UserController userController;

    public SettleUpUser(UserController userController) {
        this.userController = userController;
    }

    @Override
    public void execute(String input) {
        // u1 settleUp g1
        String[] s = input.split(" ");
        userController.settleUser(s[0], s[2]);
    }

    @Override
    public boolean matches(String input) {
        String[] s = input.split(" ");
        return s[1].equalsIgnoreCase("settleup");
    }
}
