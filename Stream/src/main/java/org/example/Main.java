package org.example;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(1, 2, 4, 22, 3, 41, 59, 16, 97);
        Stream<Integer> streamInteger = numbers.stream();

        List<String> strings = Arrays.asList("Nafiul", "Islam", "Nayeem", "Nafiul_Islam_Nayeem", "Nafi", "Red", "Purple", "Apple", "Aspectcaser");
        Stream<String> stringStream = strings.stream();

        //add 5 in every numbers here
        List<Integer> integers = streamInteger.map(integer -> integer + 10).collect(Collectors.toList());
        System.out.println(integers);

        List<String> stringList = stringStream.filter(value -> value.length() > 5).toList();
        System.out.println(stringList);

        int sum = numbers.stream().reduce(0, (a, b) -> a + b);
        System.out.println(sum);

        // Given a list of integers, find the sum of all even numbers.
        Optional<Integer> askSum = numbers.stream().filter(integer -> (integer % 2) == 0).reduce((a, b) -> a + b);
        System.out.println(askSum.get());

        //Given a list of names, find the length of the longest name.
        String longestName = String.valueOf(stringList.stream().reduce((a, b) -> a.length() > b.length() ? a : b));
        System.out.println(longestName);

//        Given a list of integers, find the sum of the squares of the even numbers.
        Optional<Integer> sumOfSquares = numbers.stream().filter(a -> (a % 2 == 0)).map(a -> a * a).reduce((a, b) -> a + b);
        System.out.println(sumOfSquares.get());

//        Given a list of integers, find the sum of the squares of the even numbers greater than 5.
        Optional<Integer> sumOfSquaresGreater = numbers.stream().filter(a -> (a % 2 == 0) && a > 5).map(a -> a * a).reduce((a, b) -> a + b);
        System.out.println(sumOfSquaresGreater.get());

//        Given a list of words, find the length of the words that start with the letter 'A' and have an odd length.
        List<Integer> words = strings.stream().filter(a -> a.startsWith("A"))
                .map(a -> a.length())
                .filter(length -> (length % 2 != 0))
                .toList();
        System.out.println(words);

        List<Employee> employeeList = Arrays.asList(new Employee(1, "Nafiul", 12, 25)
                , new Employee(2, "Nafi", 34, 12)
                , new Employee(3, "Nayeem", 234, 22)
                , new Employee(4, "Islam", 3234, 12));

       //avarage salary

        Double avgSalary = employeeList.stream().map(a->a.getSalary()).reduce((a,b)->(a+b))
                .map(a->a/ employeeList.size()).orElse(0.0);
        System.out.println(avgSalary);

        //avarage age and whose age greater than 12
        int avgAge = employeeList.stream().map(a->a.getAge()).filter(a->a>12).reduce((a,b)->a+b)
                .map(a->a/ employeeList.size()).orElse(0);
        System.out.println(avgAge);

    }
}