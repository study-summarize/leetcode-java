package leetcode;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.params.provider.Arguments.arguments;

@DisplayName("XXXX")
class Test_706_MyHashMapTest {
    private final Test_706_MyHashMap myHashMap = new Test_706_MyHashMap();

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