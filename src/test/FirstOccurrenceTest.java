package test;

import org.junit.jupiter.api.Test;

import static src.master_the_interview.GoogleQuestion.firstOccurrence;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class FirstOccurrenceTest {
    @Test
    public void testCase1(){
        int[] input = {2,5,1,2,3,5,1,2,4};
        assertEquals(2, firstOccurrence(input));
    }

    @Test
    public void testCase2(){
        int[] input = {2,1,1,2,3,5,1,2,4};
        assertEquals(1, firstOccurrence(input));
    }

    @Test
    public void testCase3(){
        int[] input = {1,2,3,4};
        assertEquals(-1, firstOccurrence(input));
    }

}
