package org.example.machineCoding.splitwise.basicFlow.models;

public class UserExpense {

    private User user;
    private Expense expense;
    private int amount;
    private UserExpenseType userExpenseType;

    public UserExpense(User user, Expense expense, int amount, UserExpenseType userExpenseType) {
        this.user = user;
        this.expense = expense;
        this.amount = amount;
        this.userExpenseType = userExpenseType;
    }

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

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public UserExpenseType getUserExpenseType() {
        return userExpenseType;
    }

    public void setUserExpenseType(UserExpenseType userExpenseType) {
        this.userExpenseType = userExpenseType;
    }
}
