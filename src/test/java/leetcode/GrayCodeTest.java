package leetcode;

import org.github.fourth.leetcode.GrayCode;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

/**
 * @author jwang55
 */
public class GrayCodeTest {

    @Test
    public void test() {
        GrayCode solution = new GrayCode();
        List<Integer> result2 = solution.grayCode(2);
        List<Integer> result2Verify = Arrays.asList(0, 1, 3, 2);
        for (int i = 0; i < result2Verify.size(); i++) {
            Assertions.assertEquals(result2Verify.get(i), result2.get(i));
        }

        List<Integer> result1 = solution.grayCode(1);
        List<Integer> result1Verify = Arrays.asList(0, 1);
        for (int i = 0; i < result1Verify.size(); i++) {
            Assertions.assertEquals(result1Verify.get(i), result1.get(i));
        }
    }
}
