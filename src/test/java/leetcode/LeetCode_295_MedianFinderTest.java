package leetcode;

import org.github.fourth.leetcode.LeetCode_295_MedianFinder;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.params.provider.Arguments.arguments;

@DisplayName(" 测试")
class LeetCode_295_MedianFinderTest {
    private final LeetCode_295_MedianFinder medianFinder = new LeetCode_295_MedianFinder();

    //    @ParameterizedTest
    @MethodSource("generateRightCase")
    public void test() {
        // todo: 待实现
        medianFinder.findMedian();
    }

    public static Stream<Arguments> generateRightCase() {
        return Stream.of(
                arguments(new int[]{1, 8, 6, 2, 5, 4, 8, 3, 7}, 49),
                arguments(new int[]{1, 1}, 1)
        );
    }
}