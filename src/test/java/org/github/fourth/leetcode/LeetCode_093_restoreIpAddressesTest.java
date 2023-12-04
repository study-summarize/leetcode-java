package org.github.fourth.leetcode;

import org.github.fourth.VerifyUtils;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.params.provider.Arguments.arguments;

@DisplayName("复原 IP 地址")
class LeetCode_093_restoreIpAddressesTest {
    private final LeetCode_093_restoreIpAddresses leetCode093RestoreIpAddresses = new LeetCode_093_restoreIpAddresses();

    //    @ParameterizedTest
    @MethodSource("generateRightCase")
    public void test01(String s, List<String> expectedResult) {
        List<String> actResult = leetCode093RestoreIpAddresses.restoreIpAddresses(s);
        Assertions.assertTrue(VerifyUtils.assertListEquals(expectedResult, actResult));
    }

    public static Stream<Arguments> generateRightCase() {
        return Stream.of(
                arguments("25525511135", List.of("255.255.11.135", "255.255.111.35")),
                arguments("0000", List.of("0.0.0.0"))
        );
    }


}