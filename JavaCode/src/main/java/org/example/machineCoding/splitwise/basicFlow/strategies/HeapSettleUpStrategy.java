package org.example.machineCoding.splitwise.basicFlow.strategies;



import org.example.machineCoding.splitwise.basicFlow.dtos.Transaction;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

public class HeapSettleUpStrategy implements SettleUpStrategy{

    @Override
    public List<Transaction> settleUpGroup(Map<String, Integer> map) {

        PriorityQueue<Pair> receivers = new PriorityQueue<>();
        PriorityQueue<Pair> givers = new PriorityQueue<>();

        List<Transaction> transactions = new ArrayList<>();

        for(String user: map.keySet()){
            Integer amount = map.get(user);
            if(amount<0){
                givers.add(new Pair(-1*amount, user));
            }
            else if(amount>0){
                receivers.add(new Pair(amount, user));
            }
        }

        while(receivers.size()>0 && givers.size()>0){
            Pair giver = givers.poll();
            Pair receiver = receivers.poll();
            transactions.add(new Transaction(giver.user, receiver.user, giver.amount));

            if(giver.amount < receiver.amount){
                receivers.add(new Pair(receiver.amount- giver.amount, receiver.user));
            }
        }
        return transactions;
    }
}

class Pair implements Comparable {
    int amount;
    String user;

    public Pair(int amount, String user) {
        this.amount = amount;
        this.user = user;
    }

    @Override
    public int compareTo(Object o) {
        Pair other = (Pair) o;
        if(this.amount <= other.amount){
            return -1;
        }
        return 1;
    }
}
