package org.example.machineCoding.splitwise.basicFlow.services;



import org.example.machineCoding.splitwise.basicFlow.dtos.Transaction;
import org.example.machineCoding.splitwise.basicFlow.models.*;
import org.example.machineCoding.splitwise.basicFlow.repositories.*;
import org.example.machineCoding.splitwise.basicFlow.strategies.SettleUpStrategy;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class UserService {

    private GroupRepository groupRepository;
    private UserExpenseRepository userExpenseRepository;
    private SettleUpStrategy settleUpStrategy;

    public UserService(GroupRepository groupRepository, UserExpenseRepository userExpenseRepository, SettleUpStrategy settleUpStrategy) {
        this.groupRepository = groupRepository;
        this.userExpenseRepository = userExpenseRepository;
        this.settleUpStrategy = settleUpStrategy;
    }

    public List<Transaction> settleUser(String userName, String groupName) {

        Map<String, Integer> extraAmountMap = new HashMap<>();

        List<Expense> expenses = groupRepository.findExpensesByGroup(groupName);

        for(Expense expense: expenses){

            if(ExpenseType.NORMAL.equals(expense.getExpenseType())){

                List<UserExpense> userExpenseList
                        = userExpenseRepository.findUserExpenseByExpense(expense.getDescription());

                for(UserExpense userExpense: userExpenseList){
                    User user = userExpense.getUser();

                    if(!extraAmountMap.containsKey(user.getName())){
                        extraAmountMap.put(user.getName(), 0);
                    }

                    Integer amount = extraAmountMap.get(user.getName());
                    if(userExpense.getUserExpenseType().equals(UserExpenseType.PAID_BY)){
                        amount += userExpense.getAmount();
                    }
                    else{
                        amount -= userExpense.getAmount();
                    }

                    extraAmountMap.put(user.getName(), amount);
                }
            }
        }

        List<Transaction> transactions = settleUpStrategy.settleUpGroup(extraAmountMap);

        List<Transaction> userTransactions = new ArrayList<>();

        for(Transaction transaction: transactions){
            if(transaction.getFrom().equalsIgnoreCase(userName) || transaction.getTo().equalsIgnoreCase(userName)){
                userTransactions.add(transaction);
            }
        }

        return userTransactions;

    }
}
