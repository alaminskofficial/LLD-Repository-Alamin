package org.example.streamApiPractice;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        List<Person> people = new ArrayList<>(
                List.of(
                        new Person("John", 30),
                        new Person("Jane", 25),
                        new Person("Jack", 20),
                        new Person("Jill", 35)
                )
        );
        List <String> resultantString = people.stream()
                .filter(p -> p.getAge()>27)
                .map(Person::getName)
                .sorted()
                .collect(Collectors.toList());
        System.out.println(resultantString);

        List<Integer> noList = List.of(1,2,3,4,5,6,7,8,9,10);
        int res = noList.stream()
                .reduce(10, Integer::sum);
        System.out.println(res);
    }
}