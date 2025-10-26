package racingcar;

import racingcar.service.RacingGameService;

public class Application {
    public static void main(String[] args) {
        try {
            RacingGameService racingGameService = new RacingGameService();
            racingGameService.run();
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            throw e;
        }
    }
}
