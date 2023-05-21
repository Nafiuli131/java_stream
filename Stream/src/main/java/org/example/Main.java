package org.example;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(1, 22, 3, 41, 59, 16, 97);
        Stream<Integer> streamInteger = numbers.stream();

        List<String> strings = Arrays.asList("Nafiul", "Islam", "Nayeem", "Nafi", "Red", "Purple");
        Stream<String> stringStream = strings.stream();

        //add 5 in every numbers here
        List<Integer> integers = streamInteger.map(integer -> integer + 10).collect(Collectors.toList());
        System.out.println(integers);

        List<String> stringList = stringStream.filter(value -> value.length() > 5).toList();
        System.out.println(stringList);

        int sum = numbers.stream().reduce(0, (a, b) -> a + b);
        System.out.println(sum);


    }
}