package lotto.controller;

import lotto.model.Lotto;
import lotto.model.LottoRequest;
import lotto.model.Money;
import lotto.service.LottoGenerator;
import lotto.service.LottoMatcher;
import java.util.List;

import static lotto.view.InputView.*;
import static lotto.view.OutputView.*;

public class LottoController extends LottoControllerTemplate {

    private static final LottoMatcher matcher = new LottoMatcher();
    private static final LottoGenerator generator = new LottoGenerator();

    @Override
    protected void runImpl() {
        Money money = new Money(inputMoney());

        List<Lotto> lottoList = generator.createLottoList(money.getCount());
        printLottoList(lottoList);

        LottoRequest request = new LottoRequest(inputLottoNumber(), inputBonusNumber());
        printMatchResult(money.getMoney(), matcher.calculateMatch(lottoList, request));
    }
}
