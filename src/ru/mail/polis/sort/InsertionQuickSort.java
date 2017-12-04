package ru.mail.polis.sort;

import java.util.Arrays;

public class InsertionQuickSort<T extends Comparable<T>> extends AbstractSortOnComparisons<T>  {
    private static int count_Quick = 0;
    private static int count_Inser = 0;
    @Override
    public void sort(T[] array) {
        quickSort(array, 0, array.length - 1);
    }

    protected void swap(T[] a, int i, int j) {
        T temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }

    private int rnd(int min, int max) {
        max -= min - 1;
        return (int) (Math.random() * max) + min;
    }

    private int partition(T[] a, int left, int right) {
        T p = a[rnd(left, right)];
        int i = left, j = right;
        while (i <= j) {
            while (lesser(a[i], p)) i++;
            while (lesser(p, a[j])) j--;
            if (i <= j) swap(a, i++, j--);
        }
        return j;
    }

    private void quickSort(T[] a, int left, int right) {
        if (right - left < 47) {
            insertionSort(a, left, right);
        } else {
            if (left >= right) return;
            int idx = partition(a, left, right);
            count_Quick++;
            quickSort(a, left, idx);
            quickSort(a, idx + 1, right);
        }
    }

    private void insertionSort(T[] a, int left, int right) {
        count_Inser++;

        for (int i = left + 1; i <= right; i++) {
            for (int j = i; j > left && lesser(a[j], a[j - 1]); j--) {
                swap(a, j, j - 1);
            }
        }
//        for (int i = 1; i < a.length; i++) {
//            for (int j = i; j > 0 && lesser(a[j], a[j - 1]); j--) {
//                swap(a, j, j - 1);
//            }
//        }
    }

    // добавить переход на insertionSort
    public static void main(String[] args) {
        System.out.println(InsertionQuickSort.class.getSimpleName());
        Integer[] arr = SortUtils.generateBoxedArray(10000);
        System.out.println(Arrays.toString(arr));
        new InsertionQuickSort<Integer>().sort(arr);
        System.out.println(Arrays.toString(arr));

        System.out.println("Quick = " + count_Quick + ", Insertion = " + count_Inser);
    }
}
