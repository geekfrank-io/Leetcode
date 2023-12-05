package org.example;

import static org.junit.Assert.assertTrue;

import org.example.DFS.CombinationSum39;
import org.junit.Test;

import java.util.List;

/**
 * Unit test for simple App.
 */
public class AppTest {
    /**
     * Rigorous Test :-)
     */
    @Test
    public void shouldAnswerWithTrue() {
        //assertTrue( true );
        CombinationSum39 obj = new CombinationSum39();
        int[] candidates = {2,3,5};
        int target = 8;
        List<List<Integer>> result = obj.combinationSum(candidates, target);
        System.out.print(result);
    }
}
