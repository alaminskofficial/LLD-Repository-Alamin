package org.example.machineCoding.splitwise.basicFlow.repositories;



import org.example.machineCoding.splitwise.basicFlow.models.Expense;
import org.example.machineCoding.splitwise.basicFlow.models.Group;

import java.util.ArrayList;
import java.util.List;

public class GroupRepository {

    private List<Group> groups;

    public GroupRepository() {
        groups = new ArrayList<>();
    }

    public void addGroup(Group group){
        groups.add(group);
    }

    public List<Expense> findExpensesByGroup(String groupName) {

        for(Group group: groups){
            if(groupName.equalsIgnoreCase(group.getName())){
                return group.getExpenses();
            }
        }
        return new ArrayList<>();
    }
}
