package ru.mail.polis.bench;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;

public class BenchUtils {
    private static final int intMax   = 200000;
    private static final int intMin   = 1;
    private static final int intRange = 10;

    private static int rnd(int min, int max) {
        max -= min - 1;
        return (int) (Math.random() * max) + min;
    }

    public static Integer[] generateRandomArray(int size) {
        Integer[] result = new Integer[size];
        for (int i = 0; i < result.length; i++) {
            result[i] = rnd(intMin, intMax);
        }
        return result;
    }

    public static Integer[] generateSortedArray(int size) {
        Integer[] result = new Integer[size];
        for (int i = 0; i < size; i++) {
            result[i] = i;
        }
        return result;
    }

    public static Integer[] generateReversedArray(int size) {
        Integer[] result = new Integer[size];
        for (int i = 0; i < size ; i++) {
            result[i] = size - i;
        }
        return result;
    }

    public static Integer[] generateUniqueArray(int size) {
        Set<Integer> set = new HashSet<>();
        while (set.size() < size) {
            set.add(rnd(intMin, intMax));
        }
        return set.toArray(new Integer[0]);
    }

    public static Integer[] generateRepetitiveArray(int size) {
        final int uniqueNumber = (int) (size * 0.3);
        Integer[] unique = generateUniqueArray(uniqueNumber);
        Integer[] result = new Integer[size];
        for (int i = 0; i < result.length; i++) {
            result[i] = unique[rnd(intMin, unique.length - 1)];
        }
        return result;
    }


    public static Integer[] generateHeap(int size) {
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        for (int i = 0; i < size; i++) {
            queue.add(rnd(intMin, intMax));
        }
        return queue.toArray(new Integer[0]);
    }

    public static Integer[] generateReversedHeap(int size) {
        PriorityQueue<Integer> queue = new PriorityQueue<>(Comparator.reverseOrder());
        for (int i = 0; i < size; i++) {
            queue.add(rnd(intMin, intMax));
        }
        return queue.toArray(new Integer[0]);
    }

    public static Integer[] generateNarrowRangeArray(int size) {
        Integer[] result = new Integer[size];
        for (int i = 0; i < size; i++) {
            result[i] = rnd(intMin, intRange);
        }
        return result;
    }

    public static String[] generateStringArray(int size) {
        String[] result = new String[size];
        final int maxLength = 20;
        for (int i = 0; i < size; i++) {
            int length = rnd(intMin, maxLength) + 1;
            result[i] = randomString(length);
        }
        return result;
    }

    public static String[] generateLongStringArray(int size) {
        String[] result = new String[size];
        final int length = 2500;
        for (int i = 0; i < size; i++) {
            result[i] = randomString(length);
        }
        return result;
    }

    private static String randomString(int length) {
        StringBuilder builder = new StringBuilder();
        final int a = 97;
        for (int i = 0; i < length; i++) {
            char c = (char) (rnd(intMin, 26) + a);
            builder.append(c);
        }
        return builder.toString();
    }


}
