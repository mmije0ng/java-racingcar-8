package racingcar.view;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.domain.Car;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class OutputViewTest extends NsTest {

    private final OutputView outputView = new OutputView();

    @Test
    @DisplayName("실행 결과 헤더를 출력한다")
    void printResultHeader() {
        // when
        outputView.printResultHeader();

        // then
        assertThat(output()).contains("실행 결과");
    }

    @Test
    @DisplayName("자동차들의 위치를 출력한다")
    void printCarPositions() {
        // given
        Car car1 = new Car("pobi");
        Car car2 = new Car("woni");
        car1.move();
        car1.move();
        car2.move();
        List<Car> cars = Arrays.asList(car1, car2);

        // when
        outputView.printCarPositions(cars);

        // then
        assertThat(output()).contains("pobi : --", "woni : -", "");
    }

    @Test
    @DisplayName("이동하지 않은 자동차의 위치를 출력한다")
    void printUnmovedCarPositions() {
        // given
        Car car1 = new Car("pobi");
        Car car2 = new Car("woni");
        List<Car> cars = Arrays.asList(car1, car2);

        // when
        outputView.printCarPositions(cars);

        // then
        assertThat(output()).contains("pobi : ", "woni : ", "");
    }

    @Test
    @DisplayName("여러 번 이동한 자동차의 위치를 출력한다")
    void printMultipleMovedCarPositions() {
        // given
        Car car1 = new Car("pobi");
        car1.move();
        car1.move();
        car1.move();
        car1.move();
        car1.move();
        List<Car> cars = Arrays.asList(car1);

        // when
        outputView.printCarPositions(cars);

        // then
        assertThat(output()).contains("pobi : -----", "");
    }

    @Override
    public void runMain() {
        // 테스트용 메인 메서드 - 사용하지 않음
    }
}
