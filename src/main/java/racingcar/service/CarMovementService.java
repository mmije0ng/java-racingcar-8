package racingcar.service;

import camp.nextstep.edu.missionutils.Randoms;
import racingcar.domain.Car;

import java.util.List;

public class CarMovementService {
    private static final int MIN_RANDOM_VALUE = 0;
    private static final int MAX_RANDOM_VALUE = 9;
    private static final int MOVEMENT_THRESHOLD = 4;

    public void moveCars(List<Car> cars) {
        for (Car car : cars) {
            if (shouldMove()) {
                car.move();
            }
        }
    }

    private boolean shouldMove() {
        int randomValue = Randoms.pickNumberInRange(MIN_RANDOM_VALUE, MAX_RANDOM_VALUE);
        return randomValue >= MOVEMENT_THRESHOLD;
    }
}
