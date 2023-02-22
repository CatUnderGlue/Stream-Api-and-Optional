package ru.catunderglue;

import java.util.Comparator;
import java.util.List;
import java.util.function.BiConsumer;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {
        // Task 1
        List<Integer> integers = List.of(1, 2, 4, 5, 6, 9, 3, 10, 7, 8);
        List<String> strings = List.of("a", "b", "f", "g", "c", "d");
        findMinMax(integers.stream(), Integer::compareTo, (x, y) -> System.out.println("Минимальное число: " + x + "\nМаксимальное число: " + y));
        findMinMax(strings.stream(), String::compareTo, (x, y) -> System.out.println("Первая буква: " + x + "\nПоследняя буква: " + y));

        // Task 2
        printNumberOfEven(integers);
    }

    // Task 1
    private static <T> void findMinMax(Stream<? extends T> stream, Comparator<? super T> order, BiConsumer<? super T, ? super T> minMaxConsumer) {
        List<? extends T> list = stream.sorted(order).toList();
        if (list.isEmpty()) {
            minMaxConsumer.accept(null, null);
        } else {
            minMaxConsumer.accept(list.get(0), list.get(list.size() - 1));
        }

    }

    // Task 2
    private static void printNumberOfEven(List<Integer> integers){
        List<Integer> evenIntegers = integers.stream()
                .filter(x -> x % 2 == 0)
                .toList();
        System.out.println("Кол-во чётных чисел: " + evenIntegers.size());
        evenIntegers.forEach(System.out::println);
    }
}