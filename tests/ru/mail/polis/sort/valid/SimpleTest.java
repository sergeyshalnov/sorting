package ru.mail.polis.sort.valid;

import java.io.IOException;

import org.junit.Assert;
import org.junit.Test;

import ru.mail.polis.sort.SimpleSortOnComparisons;

/**
 * Created by Nechaev Mikhail
 * Since 14/11/2017.
 */
public class SimpleTest {

    @Test
    public void test01() throws IOException {
        SimpleSortOnComparisons<String> simpleSort = new SimpleSortOnComparisons<>();
        String[] array = new String[]{"abc", "bcd", "cde", "acd", "zxy", "bba"};
        simpleSort.sort(array);
        Assert.assertArrayEquals(new String[]{"abc", "acd", "bba", "bcd", "cde", "zxy"}, array);
    }
}
