package racingcar.service;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.domain.Car;

import java.util.Arrays;
import java.util.List;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static org.assertj.core.api.Assertions.assertThat;

class CarMovementServiceTest extends NsTest {

    private final CarMovementService carMovementService = new CarMovementService();

    @Test
    @DisplayName("랜덤 값이 4 이상일 때 자동차가 전진한다")
    void moveCarsWhenRandomValueIsFourOrMore() {
        // given
        Car car1 = new Car("pobi");
        Car car2 = new Car("woni");
        List<Car> cars = Arrays.asList(car1, car2);

        // when
        assertRandomNumberInRangeTest(
            () -> {
                carMovementService.moveCars(cars);
                assertThat(car1.getPosition()).isEqualTo(1);
                assertThat(car2.getPosition()).isEqualTo(1);
            },
            4, 4
        );
    }

    @Test
    @DisplayName("랜덤 값이 3 이하일 때 자동차가 멈춘다")
    void stopCarsWhenRandomValueIsThreeOrLess() {
        // given
        Car car1 = new Car("pobi");
        Car car2 = new Car("woni");
        List<Car> cars = Arrays.asList(car1, car2);

        // when
        assertRandomNumberInRangeTest(
            () -> {
                carMovementService.moveCars(cars);
                assertThat(car1.getPosition()).isEqualTo(0);
                assertThat(car2.getPosition()).isEqualTo(0);
            },
            3, 3
        );
    }

    @Test
    @DisplayName("여러 자동차가 각각 다른 랜덤 값에 따라 이동한다")
    void moveCarsWithDifferentRandomValues() {
        // given
        Car car1 = new Car("pobi");
        Car car2 = new Car("woni");
        List<Car> cars = Arrays.asList(car1, car2);

        // when
        assertRandomNumberInRangeTest(
            () -> {
                carMovementService.moveCars(cars);
                assertThat(car1.getPosition()).isEqualTo(1); // 4 이상
                assertThat(car2.getPosition()).isEqualTo(0); // 3 이하
            },
            4, 3
        );
    }

    @Test
    @DisplayName("여러 번 이동하면 위치가 누적된다")
    void moveCarsMultipleTimes() {
        // given
        Car car1 = new Car("pobi");
        List<Car> cars = Arrays.asList(car1);

        // when
        assertRandomNumberInRangeTest(
            () -> {
                carMovementService.moveCars(cars);
                carMovementService.moveCars(cars);
                assertThat(car1.getPosition()).isEqualTo(2);
            },
            4, 4
        );
    }

    @Override
    public void runMain() {
        racingcar.Application.main(new String[]{});
    }
}
