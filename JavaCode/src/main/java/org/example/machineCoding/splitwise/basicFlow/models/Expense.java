package org.example.machineCoding.splitwise.basicFlow.models;

public class Expense {

    private String description;
    private int amount; // total amount of the expense
    private ExpenseType expenseType;

    public Expense(String description, int amount, ExpenseType expenseType) {
        this.description = description;
        this.amount = amount;
        this.expenseType = expenseType;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public ExpenseType getExpenseType() {
        return expenseType;
    }

    public void setExpenseType(ExpenseType expenseType) {
        this.expenseType = expenseType;
    }
}
