package racingcar.service;

import racingcar.domain.Car;

import java.util.ArrayList;
import java.util.List;

public class WinnerDeterminationService {

    public List<String> determineWinners(List<Car> cars) {
        int maxPosition = findMaxPosition(cars);
        return findCarsWithMaxPosition(cars, maxPosition);
    }

    private int findMaxPosition(List<Car> cars) {
        int maxPosition = 0;
        for (Car car : cars) {
            maxPosition = Math.max(maxPosition, car.getPosition());
        }
        return maxPosition;
    }

    private List<String> findCarsWithMaxPosition(List<Car> cars, int maxPosition) {
        List<String> winners = new ArrayList<>();
        for (Car car : cars) {
            if (car.getPosition() == maxPosition) {
                winners.add(car.getName());
            }
        }
        return winners;
    }
}
