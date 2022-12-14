package collections;

import org.testng.annotations.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class ListTest {

    @Test(description = "List should be reversed")
    void listShouldBeReversed() {
        List<String> data = List.of("Hello", "world", "!");
        List<String> expectedData = List.of("!", "world", "Hello");

        assertThat(ListUtils.reverse(data))
                .isEqualTo(expectedData);
    }

    @Test(description = "List should not have duplicates")
    void listShouldNotHaveDuplicates() {
        List<Integer> data = List.of(1, 2, 3, 5, 1, 10, 2);
        List<Integer> expectedData = List.of(1, 2, 3, 5, 10);

        assertThat(ListUtils.removeDuplicates(data))
                .isEqualTo(expectedData);
    }

    @Test(description = "getElementIndex method should return message with element index")
    void elementIndex() {
        String expectedMessage = "Element index is 1";

        assertThat(ListUtils.getElementIndex(List.of("Hello", "world", "!"), "world"))
                .isEqualTo(expectedMessage);
    }

    @Test(description = "Get arithmetic mean value")
    void arithmeticMeanValue() {
        assertThat(ListUtils.getArithmeticMeanValue(List.of(2, 13, 11)))
                .isEqualTo(8);
    }

    @Test(description = "Get min value from list")
    void maxValue() {
        assertThat(ListUtils.getMinValue(List.of(2, 13, 11)))
                .isEqualTo(2);
    }

    @Test(description = "Get max value from list")
    void minValue() {
        assertThat(ListUtils.getMaxValue(List.of(2, 13, 11)))
                .isEqualTo(13);
    }
}
