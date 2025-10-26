package racingcar.view;

import racingcar.domain.Car;

import java.util.List;

public class OutputView {
    private static final String RESULT_HEADER = "실행 결과";
    private static final String WINNER_PREFIX = "최종 우승자 : ";

    public void printResultHeader() {
        System.out.println(RESULT_HEADER);
    }

    public void printCarPositions(List<Car> cars) {
        for (Car car : cars) {
            System.out.println(car.getName() + " : " + car.getPositionString());
        }
        System.out.println();
    }

    public void printWinners(List<String> winnerNames) {
        String winnerString = String.join(", ", winnerNames);
        System.out.println(WINNER_PREFIX + winnerString);
    }
}
