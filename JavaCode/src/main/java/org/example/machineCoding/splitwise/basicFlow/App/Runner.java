package org.example.machineCoding.splitwise.basicFlow.App;



import org.example.machineCoding.splitwise.basicFlow.controllers.UserController;
import org.example.machineCoding.splitwise.basicFlow.dtos.Transaction;
import org.example.machineCoding.splitwise.basicFlow.models.*;
import org.example.machineCoding.splitwise.basicFlow.repositories.ExpenseRepository;
import org.example.machineCoding.splitwise.basicFlow.repositories.GroupRepository;
import org.example.machineCoding.splitwise.basicFlow.repositories.UserExpenseRepository;
import org.example.machineCoding.splitwise.basicFlow.repositories.UserRepository;
import org.example.machineCoding.splitwise.basicFlow.services.UserService;
import org.example.machineCoding.splitwise.basicFlow.strategies.HeapSettleUpStrategy;

import java.util.ArrayList;
import java.util.List;

public class Runner {

    public static void main(String[] args) {

        UserRepository userRepository = new UserRepository();
        ExpenseRepository expenseRepository = new ExpenseRepository();
        GroupRepository groupRepository = new GroupRepository();
        UserExpenseRepository userExpenseRepository = new UserExpenseRepository();

        // create the users
        User a = new User("A", "12341234", "12341234");
        User b = new User("B", "12341234", "12341234");
        User c = new User("C", "12341234", "12341234");
        User d = new User("D", "12341234", "12341234");
        User e = new User("E", "12341234", "12341234");

        ArrayList<User> goaGuys = new ArrayList<>();
        goaGuys.add(a);
        goaGuys.add(b);
        goaGuys.add(c);
        goaGuys.add(d);
        goaGuys.add(e);


        // create the group
        Group goaGroup = new Group("Goa Trip");

        goaGroup.setUsers(goaGuys);

        // create the expense
        Expense expense = new Expense("Dinner", 6000, ExpenseType.NORMAL);

        // who paid and who had to pay
        UserExpense uE1 = new UserExpense(a, expense, 1000, UserExpenseType.HAD_TO_PAY);
        UserExpense uE2 = new UserExpense(b, expense, 1000, UserExpenseType.HAD_TO_PAY);
        UserExpense uE3 = new UserExpense(c, expense, 1000, UserExpenseType.HAD_TO_PAY);
        UserExpense uE4 = new UserExpense(d, expense, 1000, UserExpenseType.HAD_TO_PAY);
        UserExpense uE5 = new UserExpense(e, expense, 2000, UserExpenseType.HAD_TO_PAY);

        UserExpense uE6 = new UserExpense(a, expense, 6000, UserExpenseType.PAID_BY);

        // Add this data manually to the repositories
        userExpenseRepository.addUserExpense(uE1);
        userExpenseRepository.addUserExpense(uE2);
        userExpenseRepository.addUserExpense(uE3);
        userExpenseRepository.addUserExpense(uE4);
        userExpenseRepository.addUserExpense(uE5);
        userExpenseRepository.addUserExpense(uE6);

        userRepository.addUser(a);
        userRepository.addUser(b);
        userRepository.addUser(c);
        userRepository.addUser(d);
        userRepository.addUser(e);

        expenseRepository.addExpense(expense);

        goaGroup.getExpenses().add(expense);
        groupRepository.addGroup(goaGroup);

        UserController userController = new UserController(new UserService(
                groupRepository, userExpenseRepository, new HeapSettleUpStrategy()
        ));

        List<Transaction> transactions = userController.settleUser("a", "Goa Trip");

        System.out.println(transactions);
    }
}
