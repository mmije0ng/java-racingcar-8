package racingcar.view;

import racingcar.domain.Car;

import java.util.List;

public class OutputView {
    private static final String RESULT_HEADER = "실행 결과";

    public void printResultHeader() {
        System.out.println(RESULT_HEADER);
    }

    public void printCarPositions(List<Car> cars) {
        for (Car car : cars) {
            System.out.println(car.getName() + " : " + car.getPositionString());
        }
        System.out.println();
    }
}
