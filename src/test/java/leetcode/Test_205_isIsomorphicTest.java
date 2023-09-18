package leetcode;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.params.provider.Arguments.arguments;

@DisplayName("同构字符串 测试")
class Test_205_isIsomorphicTest {
    private final Test_205_isIsomorphic isIsomorphic = new Test_205_isIsomorphic();

    //    @ParameterizedTest
    @MethodSource("generateRightCase")
    public void test(String s, String t, boolean expectedResult) {
        boolean actResult = isIsomorphic.isIsomorphic(s, t);
        Assertions.assertEquals(expectedResult, actResult);
    }

    public static Stream<Arguments> generateRightCase() {
        return Stream.of(
                arguments(new int[]{1,8,6,2,5,4,8,3,7}, 49),
                arguments(new int[]{1,1}, 1)
        );
    }
}