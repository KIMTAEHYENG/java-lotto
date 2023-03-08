package lotto.controller;

import lotto.model.*;
import lotto.service.LottoGenerator;

import java.util.List;

import static lotto.view.InputView.*;
import static lotto.view.OutputView.printLottoList;
import static lotto.view.OutputView.printResult;

public class LottoController extends LottoControllerTemplate {

    private final LottoGenerator generator;

    public LottoController(LottoGenerator generator) {
        this.generator = generator;
    }

    @Override
    protected void runImpl() {
        Money money = new Money(inputMoney());

        List<Lotto> lottoList = generator.createLottoList(money.getCount());
        printLottoList(lottoList);

        WinningLotto winningLotto = getWinningLotto();
        printResult(getResult(winningLotto, lottoList));
    }

    private ResultMap getResult(WinningLotto winningLotto, List<Lotto> lottoList) {
        return new ResultMap(winningLotto, lottoList);
    }

    private WinningLotto getWinningLotto() {
        List<Integer> numbers = inputLottoNumber();
        int bonusNumber = inputBonusNumber();

        return new WinningLotto(Lotto.valueOf(numbers), new LottoNumber(bonusNumber));
    }

}
