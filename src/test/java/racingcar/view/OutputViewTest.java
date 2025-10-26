package racingcar.view;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.domain.Car;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class OutputViewTest {

    private final OutputView outputView = new OutputView();

    @Test
    @DisplayName("실행 결과 헤더를 출력한다")
    void printResultHeader() {
        // given
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));

        // when
        outputView.printResultHeader();

        // then
        assertThat(outputStream.toString()).contains("실행 결과");
        
        // cleanup
        System.setOut(System.out);
    }

    @Test
    @DisplayName("자동차들의 위치를 출력한다")
    void printCarPositions() {
        // given
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));
        
        Car car1 = new Car("pobi");
        Car car2 = new Car("woni");
        car1.move();
        car1.move();
        car2.move();
        List<Car> cars = Arrays.asList(car1, car2);

        // when
        outputView.printCarPositions(cars);

        // then
        String output = outputStream.toString();
        assertThat(output).contains("pobi : --", "woni : -", "");
        
        // cleanup
        System.setOut(System.out);
    }

    @Test
    @DisplayName("이동하지 않은 자동차의 위치를 출력한다")
    void printUnmovedCarPositions() {
        // given
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));
        
        Car car1 = new Car("pobi");
        Car car2 = new Car("woni");
        List<Car> cars = Arrays.asList(car1, car2);

        // when
        outputView.printCarPositions(cars);

        // then
        String output = outputStream.toString();
        assertThat(output).contains("pobi : ", "woni : ", "");
        
        // cleanup
        System.setOut(System.out);
    }

    @Test
    @DisplayName("여러 번 이동한 자동차의 위치를 출력한다")
    void printMultipleMovedCarPositions() {
        // given
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));
        
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
        String output = outputStream.toString();
        assertThat(output).contains("pobi : -----", "");
        
        // cleanup
        System.setOut(System.out);
    }

    @Test
    @DisplayName("단독 우승자를 출력한다")
    void printSingleWinner() {
        // given
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));
        
        List<String> winners = Arrays.asList("pobi");

        // when
        outputView.printWinners(winners);

        // then
        String output = outputStream.toString();
        assertThat(output).contains("최종 우승자 : pobi");
        
        // cleanup
        System.setOut(System.out);
    }

    @Test
    @DisplayName("공동 우승자를 출력한다")
    void printMultipleWinners() {
        // given
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));
        
        List<String> winners = Arrays.asList("pobi", "jun");

        // when
        outputView.printWinners(winners);

        // then
        String output = outputStream.toString();
        assertThat(output).contains("최종 우승자 : pobi, jun");
        
        // cleanup
        System.setOut(System.out);
    }

    @Test
    @DisplayName("여러 명의 공동 우승자를 출력한다")
    void printManyWinners() {
        // given
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));
        
        List<String> winners = Arrays.asList("pobi", "woni", "jun");

        // when
        outputView.printWinners(winners);

        // then
        String output = outputStream.toString();
        assertThat(output).contains("최종 우승자 : pobi, woni, jun");
        
        // cleanup
        System.setOut(System.out);
    }
}
