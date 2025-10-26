package racingcar.validator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class AttemptCountValidatorTest {

    private final AttemptCountValidator attemptCountValidator = new AttemptCountValidator();

    @Test
    @DisplayName("정상적인 시도 횟수를 검증한다")
    void validateNormalAttemptCount() {
        // given
        String input = "5";

        // when
        int result = attemptCountValidator.validateAttemptCount(input);

        // then
        assertThat(result).isEqualTo(5);
    }

    @Test
    @DisplayName("공백이 포함된 시도 횟수를 정리하여 검증한다")
    void validateAttemptCountWithSpaces() {
        // given
        String input = " 5 ";

        // when
        int result = attemptCountValidator.validateAttemptCount(input);

        // then
        assertThat(result).isEqualTo(5);
    }

    @ParameterizedTest
    @ValueSource(strings = {"", "   ", "\t", "\n"})
    @DisplayName("빈 입력에 대해 예외를 발생시킨다")
    void validateEmptyInput(String input) {
        // when & then
        assertThatThrownBy(() -> attemptCountValidator.validateAttemptCount(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("시도 횟수를 입력해주세요.");
    }

    @Test
    @DisplayName("null 입력에 대해 예외를 발생시킨다")
    void validateNullInput() {
        // when & then
        assertThatThrownBy(() -> attemptCountValidator.validateAttemptCount(null))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("시도 횟수를 입력해주세요.");
    }

    @ParameterizedTest
    @ValueSource(strings = {"0", "-1", "-5"})
    @DisplayName("0 이하의 시도 횟수에 대해 예외를 발생시킨다")
    void validateZeroOrNegativeAttemptCount(String input) {
        // when & then
        assertThatThrownBy(() -> attemptCountValidator.validateAttemptCount(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("시도 횟수는 1 이상이어야 합니다.");
    }

    @ParameterizedTest
    @ValueSource(strings = {"abc", "3a", "five", "1.5"})
    @DisplayName("숫자가 아닌 입력에 대해 예외를 발생시킨다")
    void validateNonNumericInput(String input) {
        // when & then
        assertThatThrownBy(() -> attemptCountValidator.validateAttemptCount(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("시도 횟수는 숫자여야 합니다.");
    }
}
