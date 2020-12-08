package test;

import org.junit.jupiter.api.Test;
import src.sorting.SelectionSort;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class SelectionSortTest {
    SelectionSort selectionSort = new SelectionSort();

    @Test
    public void testCase1(){
        int[] input = {3,2,1,4,5,10};
        int[] expected = {1,2,3,4,5,10};
        assertArrayEquals(expected, selectionSort.sort(input));
    }

    @Test
    public void testCase2(){
        int[] input = {3};
        int[] expected = {3};
        assertArrayEquals(expected, selectionSort.sort(input));
    }

    @Test
    public void testCase3(){
        int[] input = {3,2};
        int[] expected = {2,3};
        assertArrayEquals(expected, selectionSort.sort(input));
    }

}
