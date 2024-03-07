package org.example.machineCoding.splitwise.basicFlow.models;

import java.util.ArrayList;
import java.util.List;

public class Group {

    private String name;
    private List<User> users;
    private List<Expense> expenses;

    public Group(String name) {
        this.name = name;
        this.users  = new ArrayList<>();
        this.expenses = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }

    public List<Expense> getExpenses() {
        return expenses;
    }

    public void setExpenses(List<Expense> expenses) {
        this.expenses = expenses;
    }
}
