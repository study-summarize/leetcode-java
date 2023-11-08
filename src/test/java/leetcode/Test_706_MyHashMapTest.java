package leetcode;

import org.github.fourth.leetcode.LeetCode_706_MyHashMap;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.params.provider.Arguments.arguments;

@DisplayName(" 测试")
class Test_706_MyHashMapTest {
    private final LeetCode_706_MyHashMap myHashMap = new LeetCode_706_MyHashMap();

    //    @ParameterizedTest
    @MethodSource("generateRightCase")
    public void test() {
        // todo: 待实现
    }

    public static Stream<Arguments> generateRightCase() {
        return Stream.of(
                arguments(new int[]{1, 8, 6, 2, 5, 4, 8, 3, 7}, 49),
                arguments(new int[]{1, 1}, 1)
        );
    }
}