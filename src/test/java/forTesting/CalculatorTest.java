package forTesting;

import forTesting.provider.MyArgumentProvider;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.*;

import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.params.provider.Arguments.arguments;

@SuppressWarnings("CommentedOutCode")
class CalculatorTest {
    private final Calculator calculator = new Calculator();

    @Test
    void testAddition() {
        assertEquals(5, calculator.add(3, 2));
        assertEquals(-4, calculator.add(-1, -3));
        assertEquals(12, calculator.add(0, 12));
        assertEquals(-12, calculator.add(0, -12));
        assertEquals(10, calculator.add(-2, 12));
    }

    //    @Test
    //    void willFail() {
    //        // will fail no matter what
    //        Assertions.assertEquals(1, calculator.add(1, 2, 3));
    //    }

    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3})
    void testWithMultipleValues(int argument) {
        assertTrue(argument > 0 && argument < 4);
    }


    // two method, one testing, second providing parameters (same method name)
    @ParameterizedTest
    @MethodSource
    void returnArguments(int result, int a, int b) {
        assertEquals(result, calculator.add(a, b));
    }

    static Stream<Arguments> returnArguments() {
        return Stream.of(
                arguments(5, 1, 4),
                arguments(7, 0, 7),
                arguments(-2, 0, -2),
                arguments(-12, -5, -7),
                arguments(0, 0, 0)
        );
    }


    @ParameterizedTest
    @CsvSource({"5, 1, 4", "7, 0, 7"})
    void returnArgumentsFromCSV(int result, int a, int b) {
        assertEquals(result, calculator.add(a, b));
    }

    @DisplayName("Testing calculator addition from CSV file reading")
    @ParameterizedTest
    @CsvFileSource(resources = "/csv/test.csv")
    void returnArgumentsFromCSVFile(int result, int a, int b) {
        assertEquals(result, calculator.add(a, b));
    }

    @ParameterizedTest
    @ArgumentsSource(MyArgumentProvider.class)
    void testWithArgumentsSource(String argument) {
        assertNotNull(argument);
    }


    @RepeatedTest(10)
    void testRepeated() {
        int min = 1;
        int max = 10;
        int random = ThreadLocalRandom.current().nextInt(min, max + 1);

        System.out.println("random number generated random: " + random);
        // will always success
        assertTrue(random < 11);
    }
}