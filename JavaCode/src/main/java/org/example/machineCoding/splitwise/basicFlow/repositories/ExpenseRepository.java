package org.example.machineCoding.splitwise.basicFlow.repositories;



import org.example.machineCoding.splitwise.basicFlow.models.Expense;

import java.util.ArrayList;
import java.util.List;


public class ExpenseRepository {

    private List<Expense> expenseList;



    public void addExpense(Expense expense){
        expenseList.add(expense);
    }

    public ExpenseRepository() {
        expenseList = new ArrayList<>();
    }
}
