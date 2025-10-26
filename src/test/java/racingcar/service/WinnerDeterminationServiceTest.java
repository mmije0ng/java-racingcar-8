package racingcar.service;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.domain.Car;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class WinnerDeterminationServiceTest {

    private final WinnerDeterminationService winnerDeterminationService = new WinnerDeterminationService();

    @Test
    @DisplayName("단독 우승자를 판별한다")
    void determineSingleWinner() {
        // given
        Car car1 = new Car("pobi");
        Car car2 = new Car("woni");
        Car car3 = new Car("jun");
        
        car1.move();
        car1.move();
        car1.move();
        car2.move();
        car2.move();
        car3.move();
        
        List<Car> cars = Arrays.asList(car1, car2, car3);

        // when
        List<String> winners = winnerDeterminationService.determineWinners(cars);

        // then
        assertThat(winners).containsExactly("pobi");
    }

    @Test
    @DisplayName("공동 우승자를 판별한다")
    void determineMultipleWinners() {
        // given
        Car car1 = new Car("pobi");
        Car car2 = new Car("woni");
        Car car3 = new Car("jun");
        
        car1.move();
        car1.move();
        car2.move();
        car2.move();
        car3.move();
        
        List<Car> cars = Arrays.asList(car1, car2, car3);

        // when
        List<String> winners = winnerDeterminationService.determineWinners(cars);

        // then
        assertThat(winners).containsExactlyInAnyOrder("pobi", "woni");
    }

    @Test
    @DisplayName("모든 자동차가 동일한 위치일 때 모든 자동차가 우승자다")
    void determineAllWinners() {
        // given
        Car car1 = new Car("pobi");
        Car car2 = new Car("woni");
        Car car3 = new Car("jun");
        
        car1.move();
        car2.move();
        car3.move();
        
        List<Car> cars = Arrays.asList(car1, car2, car3);

        // when
        List<String> winners = winnerDeterminationService.determineWinners(cars);

        // then
        assertThat(winners).containsExactlyInAnyOrder("pobi", "woni", "jun");
    }

    @Test
    @DisplayName("모든 자동차가 이동하지 않았을 때 모든 자동차가 우승자다")
    void determineWinnersWhenNoMovement() {
        // given
        Car car1 = new Car("pobi");
        Car car2 = new Car("woni");
        Car car3 = new Car("jun");
        
        List<Car> cars = Arrays.asList(car1, car2, car3);

        // when
        List<String> winners = winnerDeterminationService.determineWinners(cars);

        // then
        assertThat(winners).containsExactlyInAnyOrder("pobi", "woni", "jun");
    }
}
