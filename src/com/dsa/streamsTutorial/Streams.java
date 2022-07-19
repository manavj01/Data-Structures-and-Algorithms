package com.dsa.streamsTutorial;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Streams {
    public static void main(String[] args) throws IOException {
        // 1. Integer Streams
        IntStream
                .range(1, 10)
                .forEach(System.out::println);
        System.out.println();

        // 2. Integer streams with skip
        IntStream
                .range(1, 10)
                .skip(5)
                .forEach(x -> System.out.println(x));
        System.out.println();

        // 3. Integer Stream with sum
        System.out.println(
                IntStream
                        .range(1, 5)
                        .sum()
        );
        System.out.println();

        // 4. Stream of, sorted and findFirst
//        String[] arr = {"1","2","3"};
        Stream.of("Ava", "Aneri", "Alberto")
                .sorted()
                .findFirst()
                .ifPresent(System.out::println);
        System.out.println();

        // 5. Stream from Array, sort, filter and print
        String[] names = {"Al", "Ankit", "Kushal", "Brent", "Sarika", "amanda", "Hans", "Shivika", "Sachin"};
        Arrays.stream(names)
                .filter(x -> x.startsWith("S"))
                .sorted()
                .forEach(System.out::println);
        System.out.println();

        // 6. average of squares of an int array
        Arrays.stream(new int[]{2, 4, 6, 8, 10})
                .map(x -> x * x)
                .average()
                .ifPresent(System.out::println);
        System.out.println();

        // 7. Stream from List, filter and print
        List<String> people = Arrays.asList("Al", "Ankit", "Kushal", "Brent", "Sarika", "amanda", "Hans", "Shivika", "Sachin");
        people
                .stream()
                .map(String::toLowerCase)
                .filter(x -> x.startsWith("a"))
                .forEach(System.out::println);
        System.out.println();

        // 8. Stream rows from text file, sort , filter and print
        Stream<String> bands = Files.lines(Paths.get("./bands.txt"));
        bands
                .sorted()
                .filter(x -> x.length() > 13)
                .forEach(System.out::println);
        bands.close();

        // 9. Stream rows from text file and save to List
        List<String> bands2 = Files.lines(Paths.get("bands.txt"))
                .filter(x -> x.contains("jit")).toList();
        bands2.forEach(System.out::println);

    }
}
