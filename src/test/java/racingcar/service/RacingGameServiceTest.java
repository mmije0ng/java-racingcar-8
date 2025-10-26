package racingcar.service;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static org.assertj.core.api.Assertions.assertThat;

class RacingGameServiceTest extends NsTest {

    @Test
    @DisplayName("전체 게임 흐름이 정상적으로 동작한다")
    void runCompleteGame() {
        // when
        assertRandomNumberInRangeTest(
            () -> {
                run("pobi,woni", "1");
                assertThat(output()).contains(
                    "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)",
                    "시도할 횟수는 몇 회인가요?",
                    "실행 결과",
                    "pobi : -",
                    "woni : ",
                    "최종 우승자 : pobi"
                );
            },
            4, 3
        );
    }

    @Override
    public void runMain() {
        racingcar.Application.main(new String[]{});
    }
}
