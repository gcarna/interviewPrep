package test;


import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static src.master_the_interview.mergeArray.mergeArray;

public class MergeArrayTest {
    @Test
    public void testCase1(){
        int[] input1 = {1,2,3,4,5,10};
        int[] input2 = {1,2,3,4,5,6};
        ArrayList<Integer> expected = new ArrayList<>(Arrays.asList(1,1,2,2,3,3,4,4,5,5,6,10));
        assertEquals(expected, mergeArray(input1, input2));
    }
}
