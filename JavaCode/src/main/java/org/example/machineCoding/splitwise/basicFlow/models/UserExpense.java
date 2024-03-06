package org.example.machineCoding.splitwise.basicFlow.models;

public class UserExpense {
    private User user;
    private Expense expense;
    private double amount;
    private UserExpenseType userExpenseType;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Expense getExpense() {
        return expense;
    }

    public void setExpense(Expense expense) {
        this.expense = expense;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public UserExpenseType getUserExpenseType() {
        return userExpenseType;
    }

    public void setUserExpenseType(UserExpenseType userExpenseType) {
        this.userExpenseType = userExpenseType;
    }
}
