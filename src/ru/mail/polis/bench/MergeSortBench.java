package ru.mail.polis.bench;

import java.util.concurrent.TimeUnit;

import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.annotations.BenchmarkMode;
import org.openjdk.jmh.annotations.Level;
import org.openjdk.jmh.annotations.Mode;
import org.openjdk.jmh.annotations.OutputTimeUnit;
import org.openjdk.jmh.annotations.Scope;
import org.openjdk.jmh.annotations.Setup;
import org.openjdk.jmh.annotations.State;
import org.openjdk.jmh.infra.Blackhole;
import org.openjdk.jmh.runner.Runner;
import org.openjdk.jmh.runner.RunnerException;
import org.openjdk.jmh.runner.options.Options;
import org.openjdk.jmh.runner.options.OptionsBuilder;

import ru.mail.polis.sort.MergeSort;

@State(Scope.Thread)
@BenchmarkMode(Mode.AverageTime)
@OutputTimeUnit(TimeUnit.MICROSECONDS)
public class MergeSortBench {
    private final int arraySize = 1000;

    private Integer[] regularHeap;
    private Integer[] reverseHeap;
    private Integer[] randomArray;
    private Integer[] sortedArray;
    private Integer[] uniqueArray;
    private Integer[] repetitiveArray;
    private Integer[] rangeArray;

    private String[] stringArray;
    private String[] longStringArray;

    private MergeSort<Integer> intSort = new MergeSort<>();
    private MergeSort<String> strSort = new MergeSort<>();

    @Setup(value = Level.Invocation)
    public void setUpInvocation() {
        regularHeap = BenchUtils.generateHeap(arraySize);
        reverseHeap = BenchUtils.generateReversedHeap(arraySize);
        randomArray = BenchUtils.generateRandomArray(arraySize);
        sortedArray = BenchUtils.generateSortedArray(arraySize);
        uniqueArray = BenchUtils.generateUniqueArray(arraySize);
        repetitiveArray = BenchUtils.generateRepetitiveArray(arraySize);
        rangeArray = BenchUtils.generateNarrowRangeArray(arraySize);

        stringArray = BenchUtils.generateStringArray(arraySize);
        longStringArray = BenchUtils.generateLongStringArray(arraySize);
    }

    @Benchmark
    public void regularHeapSort(Blackhole bh) {
        intSort.sort(regularHeap);
        bh.consume(regularHeap);
    }

    @Benchmark
    public void reversedHeapSort(Blackhole bh) {
        intSort.sort(reverseHeap);
        bh.consume(reverseHeap);
    }

    @Benchmark
    public void randomArraySort(Blackhole bh) {
        intSort.sort(randomArray);
        bh.consume(randomArray);
    }

    @Benchmark
    public void sortedArraySort(Blackhole bh) {
        intSort.sort(sortedArray);
        bh.consume(sortedArray);
    }

    @Benchmark
    public void reversedArraySort(Blackhole bh) {
        intSort.sort(sortedArray);
        bh.consume(sortedArray);
    }

    @Benchmark
    public void uniqueArraySort(Blackhole bh) {
        intSort.sort(uniqueArray);
        bh.consume(uniqueArray);
    }

    @Benchmark
    public void repetitiveArraySort(Blackhole bh) {
        intSort.sort(repetitiveArray);
        bh.consume(repetitiveArray);
    }

    @Benchmark
    public void rangeArraySort(Blackhole bh) {
        intSort.sort(rangeArray);
        bh.consume(rangeArray);
    }

    @Benchmark
    public void stringArraySort(Blackhole bh) {
        strSort.sort(stringArray);
        bh.consume(stringArray);
    }

    @Benchmark
    public void longStringArraySort(Blackhole bh) {
        strSort.sort(longStringArray);
        bh.consume(longStringArray);
    }


    public static void main(String[] args) throws RunnerException {
        Options opt = new OptionsBuilder()
                .include(MergeSortBench.class.getSimpleName())
                .warmupIterations(5)
                .measurementIterations(5)
                .forks(1)
                .build();

        new Runner(opt).run();
    }
}
