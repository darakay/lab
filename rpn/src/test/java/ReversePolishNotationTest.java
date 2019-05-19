import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class ReversePolishNotationTest {

    @ParameterizedTest
    @CsvSource({"'8 9 ?', '?'", "'9 0 = ', '='", "'4 2 %', '%'", "'8 : 9', ':'"})
    void calculate_ShouldThrowCalculateException_ThenValueContainsInvalidSymbols
            (final String calculatedValue, String unexpectedSymbol) {

        Throwable exception = assertThrows(CalculateException.class,
                () -> { ReversePolishNotation.calculate(calculatedValue);});

        assertThat(exception).hasMessage("Unexpected symbol "+unexpectedSymbol+".");
    }

    @Test
    void calculate_ShouldReturnZero_ThenValueIsEmpty() throws CalculateException {
        assertThat(ReversePolishNotation.calculate("")).isEqualTo(0);
    }

    @ParameterizedTest
    @CsvSource({"'2 3 ^ 2 /', 4", "'6 5 +', 11", "'6 7 + 3 *', 39",
            "'8',8", "'15 7 1 1 + - / 3 * 2 1 1 + + -', 5"})
    void calculate_ShouldReturnCorrectDoubleAnswer(String value, double result) throws CalculateException {
        assertThat(ReversePolishNotation.calculate(value)).isEqualTo(result);
    }

    @ParameterizedTest
    @ValueSource(strings = {"2 3 ^ 2 / 6", "6 5 + -"})
    void calculate_ShouldThrowCalculateException_ThenCalculatedValueIsInvalid(String value) throws CalculateException {
        Throwable exception = assertThrows(CalculateException.class,
                () -> { ReversePolishNotation.calculate(value);});

        assertThat(exception).hasMessage("Invalid calculate value.");
    }
}