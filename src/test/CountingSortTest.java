import main.java.sorting.BubbleSort;
import main.java.sorting.CountingSort;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class CountingSortTest {
    @Test
    public void testCase1(){
        int[] input = {3,2,1,4,5,10};
        int[] expected = {1,2,3,4,5,10};
        assertArrayEquals(expected, CountingSort.sort(input, 10));
    }

    @Test
    public void testCase2(){
        int[] input = {3};
        int[] expected = {3};
        assertArrayEquals(expected, CountingSort.sort(input, 3));
    }

    @Test
    public void testCase3(){
        int[] input = {3,2};
        int[] expected = {2,3};
        assertArrayEquals(expected, CountingSort.sort(input, 3));
    }

}
