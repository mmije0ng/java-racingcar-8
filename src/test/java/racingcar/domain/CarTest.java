package racingcar.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class CarTest {

    @Test
    @DisplayName("자동차 이름을 반환한다")
    void getName() {
        // given
        String name = "pobi";
        Car car = new Car(name);

        // when
        String result = car.getName();

        // then
        assertThat(result).isEqualTo(name);
    }

    @Test
    @DisplayName("초기 위치는 0이다")
    void getInitialPosition() {
        // given
        Car car = new Car("pobi");

        // when
        int position = car.getPosition();

        // then
        assertThat(position).isEqualTo(0);
    }

    @Test
    @DisplayName("자동차가 이동하면 위치가 증가한다")
    void move() {
        // given
        Car car = new Car("pobi");

        // when
        car.move();

        // then
        assertThat(car.getPosition()).isEqualTo(1);
    }

    @Test
    @DisplayName("여러 번 이동하면 위치가 누적된다")
    void moveMultipleTimes() {
        // given
        Car car = new Car("pobi");

        // when
        car.move();
        car.move();
        car.move();

        // then
        assertThat(car.getPosition()).isEqualTo(3);
    }

    @Test
    @DisplayName("위치 문자열을 반환한다")
    void getPositionString() {
        // given
        Car car = new Car("pobi");

        // when
        car.move();
        car.move();
        String positionString = car.getPositionString();

        // then
        assertThat(positionString).isEqualTo("--");
    }

    @Test
    @DisplayName("이동하지 않은 자동차의 위치 문자열은 빈 문자열이다")
    void getPositionStringForUnmovedCar() {
        // given
        Car car = new Car("pobi");

        // when
        String positionString = car.getPositionString();

        // then
        assertThat(positionString).isEqualTo("");
    }
}
