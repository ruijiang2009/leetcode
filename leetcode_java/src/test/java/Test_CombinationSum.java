import com.programapprentice.app.CombinationSum;
import org.junit.Test;

import java.util.List;

/**
 * @author rjiang
 * @date 10/2/14
 */
public class Test_CombinationSum {
    CombinationSum obj = new CombinationSum();

    @Test
    public void test1() {
        int[] candidates = {2, 3, 6, 7};
        int target = 7;
        List<List<Integer>> output = obj.combinationSum(candidates, target);
        printOutput(output);
    }

    @Test
    public void test2() {
        int[] candidates = {1, 2};
        int target = 3;
        List<List<Integer>> output = obj.combinationSum(candidates, target);
        printOutput(output);
    }

    @Test
    public void test3() {
        int[] candidates = {1, 1};
        int target = 2;
        List<List<Integer>> output = obj.combinationSum(candidates, target);
        printOutput(output);
    }

    @Test
    public void test4() {
        int[] candidates = {1};
        int target = 2;
        List<List<Integer>> output = obj.combinationSum(candidates, target);
        printOutput(output);
    }

    private void printOutput(List<List<Integer>> output) {
        System.out.println("output is:");
        for(List<Integer> list : output) {
            for(Integer i : list) {
                System.out.print(i + "    ");
            }
            System.out.println();
        }
    }
}
