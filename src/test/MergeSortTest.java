package test;

import org.junit.jupiter.api.Test;
import main.java.sorting.MergeSort;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class MergeSortTest {
    MergeSort mergeSort = new MergeSort();

    @Test
    public void testCase1(){
        int[] input = {20,35,-15,7,55,1,-22};
        int[] expected = {-22,-15,1,7,20,35,55};
        assertArrayEquals(expected, mergeSort.sort(input));
    }

    @Test
    public void testCase2(){
        int[] input = {3};
        int[] expected = {3};
        assertArrayEquals(expected, mergeSort.sort(input));
    }

    @Test
    public void testCase3(){
        int[] input = {3,2};
        int[] expected = {2,3};
        assertArrayEquals(expected, mergeSort.sort(input));
    }

}
