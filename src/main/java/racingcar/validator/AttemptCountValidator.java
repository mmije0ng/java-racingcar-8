package racingcar.validator;

public class AttemptCountValidator {
    private static final int MIN_ATTEMPT_COUNT = 1;

    public int validateAttemptCount(String input) {
        validateInputNotEmpty(input);
        int attemptCount = parseAttemptCount(input);
        validateAttemptCountRange(attemptCount);
        return attemptCount;
    }

    private void validateInputNotEmpty(String input) {
        if (input == null || input.trim().isEmpty()) {
            throw new IllegalArgumentException("시도 횟수를 입력해주세요.");
        }
    }

    private int parseAttemptCount(String input) {
        try {
            return Integer.parseInt(input.trim());
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("시도 횟수는 숫자여야 합니다.");
        }
    }

    private void validateAttemptCountRange(int attemptCount) {
        if (attemptCount < MIN_ATTEMPT_COUNT) {
            throw new IllegalArgumentException("시도 횟수는 1 이상이어야 합니다.");
        }
    }
}
