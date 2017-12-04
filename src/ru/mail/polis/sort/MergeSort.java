package ru.mail.polis.sort;

import java.lang.reflect.Array;
import java.util.Arrays;

public class MergeSort<T extends Comparable<T>> extends AbstractSortOnComparisons<T>  {
    private T[] array;

    @Override
    public void sort(T[] array) {
        this.array = array;
        this.array = mergeSort(0, array.length - 1);
        System.arraycopy(this.array, 0, array, 0, this.array.length);
    }

    private T[] mergeSort(int left, int right) {
        if (left == right) {
            @SuppressWarnings("unchecked")
            T[]result = (T[]) Array.newInstance(array.getClass().getComponentType(), 1);

            result[0] = array[right];
            return result;
        }
        int middle = left + (right - left) / 2;
        T[] l = mergeSort(left, middle);
        T[] r = mergeSort(middle + 1, right);
        return merge(l, r);
    }

    private T[] merge(T[] a, T[] b) {
        @SuppressWarnings("unchecked")
        T[]result = (T[]) Array.newInstance(a.getClass().getComponentType(), a.length + b.length);

        int i = 0;
        int j = 0;
        int pointer = 0;
        while (i < a.length && j < b.length) {
            if (greater(a[i], b[j])) {
                result[pointer++] = b[j++];
            } else {
                result[pointer++] = a[i++];
            }
        }
        while (i < a.length) {
            result[pointer++] = a[i++];
        }
        while (j < b.length) {
            result[pointer++] = b[j++];
        }

        return result;
    }

    public static void main(String[] args) {
        System.out.println(MergeSort.class.getSimpleName());
        Integer[] arr = SortUtils.generateBoxedArray(40);
        System.out.println(Arrays.toString(arr));
        new MergeSort<Integer>().sort(arr);
        System.out.println(Arrays.toString(arr));
    }

}
