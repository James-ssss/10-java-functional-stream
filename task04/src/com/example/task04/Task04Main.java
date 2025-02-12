package com.example.task04;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Task04Main {

    public static void main(String[] args) {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    br.lines()
            .map(String::toLowerCase)
            .flatMap(x-> Stream.of(x.split("[^a-zа-яё0-9]")))
            .filter(x-> !x.isEmpty())
            .collect(Collectors.groupingBy(x -> x,Collectors.counting()))
            .entrySet()
            .stream()
            .sorted(Map.Entry.comparingByKey())
            .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
            .limit(10)
            .forEach(x -> System.out.print(x.getKey() + "\n"));
    }

}
