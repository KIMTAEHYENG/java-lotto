package lotto;

import lotto.controller.LottoController;
import lotto.controller.LottoControllerTemplate;
import lotto.service.LottoGeneratorImpl;

public class Application {

    public static void main(String[] args) {
        // TODO: 프로그램 구현
        LottoControllerTemplate controller = new LottoController(new LottoGeneratorImpl());
        controller.run();
    }
}
