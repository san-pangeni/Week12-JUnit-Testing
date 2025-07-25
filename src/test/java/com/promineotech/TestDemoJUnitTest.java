package com.promineotech;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.params.provider.Arguments.arguments;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.spy;

import java.util.stream.Stream;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class TestDemoJUnitTest {

    private TestDemo testDemo;

    @BeforeEach
    void setUp() throws Exception {
        testDemo = new TestDemo();
    }

    @ParameterizedTest
    @MethodSource("com.promineotech.TestDemoJUnitTest#argumentsForAddPositive")
    void assertThatTwoPositiveNumbersAreAddedCorrectly(int a, int b, int expected, boolean expectException) {
        if (!expectException) {
            assertThat(testDemo.addPositive(a, b)).isEqualTo(expected);
        } else {
            assertThatThrownBy(() -> testDemo.addPositive(a, b))
                .isInstanceOf(IllegalArgumentException.class);
        }
    }

    static Stream<Arguments> argumentsForAddPositive() {
        // @formatter:off
        return Stream.of(
            arguments(2, 4, 6, false),    // Test case for two positive numbers
            arguments(1, 1, 2, false),     // Another test case for two positive numbers
            arguments(0, 4, 0, true),     // Test case where 'a' is zero
            arguments(2, -4, 0, true),    // Test case where 'b' is negative
            arguments(-1, -1, 0, true)    // Test case where both are negative
        );
        // @formatter:on
    }

    @Test
    void assertThatNumberSquaredIsCorrect() {
        // Use spy to create a partial mock of the testDemo object
        TestDemo mockDemo = spy(testDemo);

        // Tell the spy to return 5 whenever getRandomInt() is called
        doReturn(5).when(mockDemo).getRandomInt();

        // Call the method on the mocked object
        int fiveSquared = mockDemo.randomNumberSquared();

        // Assert that the result is 25 (5 * 5)
        assertThat(fiveSquared).isEqualTo(25);
    }
}