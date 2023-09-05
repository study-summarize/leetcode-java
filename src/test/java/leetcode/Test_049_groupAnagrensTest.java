package leetcode;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

@DisplayName("XXX测试")
class Test_049_groupAnagrensTest {
    private final Test_049_groupAnagrens groupAnagrens = new Test_049_groupAnagrens();

    //    @ParameterizedTest
    @MethodSource("generateRightCase")
    public void test(String[] strs, List<List<String>> expectedResult) {

        List<List<String>> actResult1 = groupAnagrens.groupAnagrams(strs);
        Assertions.assertEquals(expectedResult, actResult1);

        List<List<String>> actResult2 = groupAnagrens.groupAnagrams2(strs);
        Assertions.assertEquals(expectedResult, actResult2);
    }

    public static Stream<Arguments> generateRightCase() {
        return Stream.of(
        );
    }
}