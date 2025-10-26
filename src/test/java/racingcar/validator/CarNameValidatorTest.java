package racingcar.validator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class CarNameValidatorTest {

    private final CarNameValidator carNameValidator = new CarNameValidator();

    @Test
    @DisplayName("정상적인 자동차 이름들을 검증한다")
    void validateNormalCarNames() {
        // given
        String input = "pobi,woni,jun";

        // when
        List<String> result = carNameValidator.validateCarNames(input);

        // then
        assertThat(result).containsExactly("pobi", "woni", "jun");
    }

    @Test
    @DisplayName("공백이 포함된 자동차 이름들을 정리하여 검증한다")
    void validateCarNamesWithSpaces() {
        // given
        String input = " pobi , woni , jun ";

        // when
        List<String> result = carNameValidator.validateCarNames(input);

        // then
        assertThat(result).containsExactly("pobi", "woni", "jun");
    }

    @ParameterizedTest
    @ValueSource(strings = {"", "   ", "\t", "\n"})
    @DisplayName("빈 입력에 대해 예외를 발생시킨다")
    void validateEmptyInput(String input) {
        // when & then
        assertThatThrownBy(() -> carNameValidator.validateCarNames(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("자동차 이름을 입력해주세요.");
    }

    @Test
    @DisplayName("null 입력에 대해 예외를 발생시킨다")
    void validateNullInput() {
        // when & then
        assertThatThrownBy(() -> carNameValidator.validateCarNames(null))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("자동차 이름을 입력해주세요.");
    }

    @Test
    @DisplayName("빈 자동차 이름이 포함된 경우 예외를 발생시킨다")
    void validateEmptyCarName() {
        // given
        String input = "pobi,,jun";

        // when & then
        assertThatThrownBy(() -> carNameValidator.validateCarNames(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("자동차 이름은 비어있을 수 없습니다.");
    }

    @Test
    @DisplayName("5자를 초과하는 자동차 이름에 대해 예외를 발생시킨다")
    void validateLongCarName() {
        // given
        String input = "pobi,wonijun";

        // when & then
        assertThatThrownBy(() -> carNameValidator.validateCarNames(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("자동차 이름은 5자를 초과할 수 없습니다.");
    }

    @Test
    @DisplayName("공백으로만 구성된 자동차 이름에 대해 예외를 발생시킨다")
    void validateSpaceOnlyCarName() {
        // given
        String input = "pobi,   ,jun";

        // when & then
        assertThatThrownBy(() -> carNameValidator.validateCarNames(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("자동차 이름은 비어있을 수 없습니다.");
    }
}
