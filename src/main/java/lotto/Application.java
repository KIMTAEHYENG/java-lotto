package lotto;

import lotto.controller.LottoController;
import lotto.controller.LottoControllerTemplate;

public class Application {

    public static void main(String[] args) {
        // TODO: 프로그램 구현
        final LottoControllerTemplate controller = new LottoController();
        controller.run();
    }
}
