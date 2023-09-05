package leetcode;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.params.provider.Arguments.arguments;

@DisplayName("XXXX")
class Test_127_ladderLengthTest {
    private final Test_127_ladderLength ladderLength = new Test_127_ladderLength();
    //    @ParameterizedTest
    @MethodSource("generateRightCase")
    public void test(String beginWord, String endWord, List<String> wordList, int expectedResult) {
        int actResult = ladderLength.ladderLength(beginWord, endWord, wordList);
        Assertions.assertEquals(expectedResult, actResult);
    }

    public static Stream<Arguments> generateRightCase() {
        return Stream.of(
                arguments(new int[]{1,8,6,2,5,4,8,3,7}, 49),
                arguments(new int[]{1,1}, 1)
        );
    }
}