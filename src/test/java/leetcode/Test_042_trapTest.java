package leetcode;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.params.provider.Arguments.arguments;

@DisplayName("接雨水测试")
public class Test_042_trapTest {

    private final Test_042_trap trapTest = new Test_042_trap();

    @ParameterizedTest
    @MethodSource("generateRightCase")
    public void test01(int[] height, int waterCount) {
        Assertions.assertEquals(waterCount, trapTest.trap1(height));
        Assertions.assertEquals(waterCount, trapTest.trap1Refine(height));
        Assertions.assertEquals(waterCount, trapTest.trap2(height));
        Assertions.assertEquals(waterCount, trapTest.trap3(height));
    }

    public static Stream<Arguments> generateRightCase() {
        return Stream.of(
                arguments(new int[]{0,1,0,2,1,0,1,3,2,1,2,1}, 6),
                arguments(new int[]{4,2,0,3,2,5}, 9)
        );
    }
}
