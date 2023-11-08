package leetcode;

import org.github.fourth.leetcode.LeetCode_049_groupAnagrens;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.junit.jupiter.params.provider.Arguments.arguments;

@DisplayName("字母异位词分组测试")
class Test_049_groupAnagrensTest {
    private final LeetCode_049_groupAnagrens groupAnagrens = new LeetCode_049_groupAnagrens();

    @ParameterizedTest
    @MethodSource("generateRightCase")
    public void test(String[] strs, List<List<String>> expectedResult) {
        Set<Set<String>> finalExpectResult = expectedResult.stream().map(HashSet::new).collect(Collectors.toSet());

        Set<Set<String>> actResult1 = groupAnagrens.groupAnagrams(strs).stream().map(HashSet::new).collect(Collectors.toSet());
        actResult1.removeAll(finalExpectResult);
        Assertions.assertEquals(0, actResult1.size());


        Set<Set<String>> actResult2 = groupAnagrens.groupAnagrams2(strs).stream().map(HashSet::new).collect(Collectors.toSet());
        actResult2.removeAll(finalExpectResult);
        Assertions.assertEquals(0, actResult2.size());
    }

    public static Stream<Arguments> generateRightCase() {
        return Stream.of(
                        arguments(new String[]{"eat", "tea", "tan", "ate", "nat", "bat"}, Arrays.asList(List.of("bat"), Arrays.asList("nat", "tan"), Arrays.asList("ate", "eat", "tea")),
                        arguments(new String[]{""}, List.of(List.of("")))
                )
        );
    }
}