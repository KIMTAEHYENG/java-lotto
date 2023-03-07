package lotto;

import lotto.controller.LottoController;
import lotto.controller.LottoControllerTemplate;

public class Application {

    private static final LottoControllerTemplate controller = new LottoController();

    public static void main(String[] args) {
        // TODO: 프로그램 구현
        controller.run();
    }
}
