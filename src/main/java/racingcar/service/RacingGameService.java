package racingcar.service;

import racingcar.domain.Car;
import racingcar.view.InputView;
import racingcar.view.OutputView;

import java.util.List;

public class RacingGameService {
    private final InputView inputView;
    private final OutputView outputView;
    private final CarMovementService carMovementService;
    private final WinnerDeterminationService winnerDeterminationService;

    public RacingGameService() {
        this.inputView = new InputView();
        this.outputView = new OutputView();
        this.carMovementService = new CarMovementService();
        this.winnerDeterminationService = new WinnerDeterminationService();
    }

    public void run() {
        List<Car> cars = inputView.getCars();
        int attemptCount = inputView.getAttemptCount();
        
        outputView.printResultHeader();
        
        for (int i = 0; i < attemptCount; i++) {
            carMovementService.moveCars(cars);
            outputView.printCarPositions(cars);
        }
        
        List<String> winners = winnerDeterminationService.determineWinners(cars);
        outputView.printWinners(winners);
    }
}
