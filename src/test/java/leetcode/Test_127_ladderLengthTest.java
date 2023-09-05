package leetcode;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.params.provider.Arguments.arguments;

@DisplayName("单词接龙 测试")
class Test_127_ladderLengthTest {
    private final Test_127_ladderLength ladderLength = new Test_127_ladderLength();

    @ParameterizedTest
    @MethodSource("generateRightCase")
    public void test(String beginWord, String endWord, List<String> wordList, int expectedResult) {
        int actResult = ladderLength.ladderLength(beginWord, endWord, wordList);
        Assertions.assertEquals(expectedResult, actResult);
    }

    public static Stream<Arguments> generateRightCase() {
        return Stream.of(
                arguments("hit", "cog", List.of("hot", "dot", "dog", "lot", "log", "cog"), 5),
                arguments("hit", "cog", List.of("hot", "dot", "dog", "lot", "log"), 0)
        );
    }
}