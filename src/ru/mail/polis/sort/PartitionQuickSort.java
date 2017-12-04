package ru.mail.polis.sort;

import java.util.Arrays;

import ru.mail.polis.bench.PartitionSortBench;

public class PartitionQuickSort<T extends Comparable<T>> extends AbstractSortOnComparisons<T>  {
    @Override
    public void sort(T[] array) {
        quickSort(array, 0, array.length - 1);
    }

    public void swap(T[] a, int i, int j) {
        T temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }

    private int rnd(int min, int max) {
        max -= min - 1;
        return (int) (Math.random() * max) + min;
    }

    private int[] partition(T[] a, int left, int right) {
        swap(a, left, rnd(left, right));

        T item = a[left];

        int minA = left;
        int maxA = right;
        int i = left + 1;

        while (i <= maxA) {
            if (lesser(a[i], item)) {
                swap(a, i++, minA++);
            } else if (greater(a[i], item)) {
                swap(a, i, maxA--);
            } else {
                i++;
            }
        }

        int result[] = new int[2];
        result[0] = minA;
        result[1] = maxA;
        return result;
    }

    private void quickSort(T[] a, int left, int right) {
        if (left >= right) return;
        int[] idx = partition(a, left, right);
        quickSort(a, left, idx[0] - 1);
        quickSort(a, idx[1] + 1, right);
    }

    public static void main(String[] args) {
        System.out.println(PartitionQuickSort.class.getSimpleName());
        Integer[] arr = SortUtils.generateBoxedArray(40);
        System.out.println(Arrays.toString(arr));
        new PartitionQuickSort<Integer>().sort(arr);
        System.out.println(Arrays.toString(arr));

    }
}
