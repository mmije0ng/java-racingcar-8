package racingcar.view;

import camp.nextstep.edu.missionutils.Console;
import racingcar.validator.CarNameValidator;
import racingcar.validator.AttemptCountValidator;
import racingcar.domain.Car;

import java.util.ArrayList;
import java.util.List;

public class InputView {
    private static final String CAR_NAME_PROMPT = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
    private static final String ATTEMPT_COUNT_PROMPT = "시도할 횟수는 몇 회인가요?";
    
    private final CarNameValidator carNameValidator;
    private final AttemptCountValidator attemptCountValidator;

    public InputView() {
        this.carNameValidator = new CarNameValidator();
        this.attemptCountValidator = new AttemptCountValidator();
    }

    public List<Car> getCars() {
        System.out.println(CAR_NAME_PROMPT);
        String carNamesInput = Console.readLine();
        List<String> carNames = carNameValidator.validateCarNames(carNamesInput);
        return createCars(carNames);
    }

    public int getAttemptCount() {
        System.out.println(ATTEMPT_COUNT_PROMPT);
        String attemptCountInput = Console.readLine();
        return attemptCountValidator.validateAttemptCount(attemptCountInput);
    }

    private List<Car> createCars(List<String> carNames) {
        List<Car> cars = new ArrayList<>();
        for (String carName : carNames) {
            cars.add(new Car(carName.trim()));
        }
        return cars;
    }
}
