package racingcar.validator;

import java.util.Arrays;
import java.util.List;

public class CarNameValidator {
    private static final int MIN_NAME_LENGTH = 1;
    private static final int MAX_NAME_LENGTH = 5;

    public List<String> validateCarNames(String input) {
        validateInputNotEmpty(input);
        List<String> carNames = splitCarNames(input);
        validateCarNames(carNames);
        return carNames;
    }

    private void validateInputNotEmpty(String input) {
        if (input == null || input.trim().isEmpty()) {
            throw new IllegalArgumentException("자동차 이름을 입력해주세요.");
        }
    }

    private List<String> splitCarNames(String input) {
        return Arrays.asList(input.split(","));
    }

    private void validateCarNames(List<String> carNames) {
        for (String carName : carNames) {
            validateSingleCarName(carName);
        }
    }

    private void validateSingleCarName(String carName) {
        String trimmedName = carName.trim();
        validateNameNotEmpty(trimmedName);
        validateNameLength(trimmedName);
    }

    private void validateNameNotEmpty(String carName) {
        if (carName.isEmpty()) {
            throw new IllegalArgumentException("자동차 이름은 비어있을 수 없습니다.");
        }
    }

    private void validateNameLength(String carName) {
        if (carName.length() > MAX_NAME_LENGTH) {
            throw new IllegalArgumentException("자동차 이름은 5자를 초과할 수 없습니다.");
        }
    }
}
