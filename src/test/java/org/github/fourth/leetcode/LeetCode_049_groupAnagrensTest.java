package org.github.fourth.leetcode;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.junit.jupiter.params.provider.Arguments.arguments;

@DisplayName("字母异位词分组")
class LeetCode_049_groupAnagrensTest {
    private final LeetCode_049_groupAnagrams groupAnagrens = new LeetCode_049_groupAnagrams();

    @ParameterizedTest
    @MethodSource("generateRightCase")
    public void test(String[] strs, List<List<String>> expectedResult) {
        commonTest(expectedResult, x -> x.groupAnagrams(strs));
    }
    @ParameterizedTest
    @MethodSource("generateRightCase")
    public void test02(String[] strs, List<List<String>> expectedResult) {
        commonTest(expectedResult, x -> x.groupAnagrams2(strs));
    }

    private void commonTest(List<List<String>> expectedResult, Function<LeetCode_049_groupAnagrams, List<List<String>>> function) {
        Set<Set<String>> finalExpectResult = expectedResult.stream().map(HashSet::new).collect(Collectors.toSet());
        Set<Set<String>> actResult = function.apply(groupAnagrens).stream().map(HashSet::new).collect(Collectors.toSet());
        actResult.removeAll(finalExpectResult);
        Assertions.assertEquals(0, actResult.size());

    }

    public static Stream<Arguments> generateRightCase() {
        return Stream.of(
                        arguments(new String[]{"eat", "tea", "tan", "ate", "nat", "bat"}, Arrays.asList(List.of("bat"), Arrays.asList("nat", "tan"), Arrays.asList("ate", "eat", "tea")),
                        arguments(new String[]{""}, List.of(List.of("")))
                )
        );
    }
}