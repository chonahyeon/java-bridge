package bridge.Controller;

import bridge.BridgeMaker;
import bridge.BridgeRandomNumberGenerator;
import bridge.bridgeGame.BridgeGame;
import bridge.view.InputView;
import bridge.view.OutputView;

public class BridgeGameController {
    private final BridgeMaker bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());
    private final InputView inputView = new InputView();
    private final OutputView outputView = new OutputView();
    private BridgeGame bridgeGame;
    String retry = "R";

    public void gameStart() {
        outputView.printStartMessage();
        makeBridge(inputView.readBridgeSize());
    }

    public void makeBridge(int size) {
        bridgeGame = new BridgeGame(bridgeMaker.makeBridge(size));
    }

    public void printGameMessage() {
        outputView.printMapMessage();
    }

    public void printGameMap() {
        outputView.printMap(bridgeGame.renderBridgeMap().getResultUp());
        outputView.printMap(bridgeGame.renderBridgeMap().getResultDown());
    }

    public void printGameResult(boolean isSuccess) {
        outputView.printResult(isSuccess, bridgeGame.getReGameCount());
    }

}
