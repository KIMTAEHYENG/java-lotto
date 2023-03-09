package lotto.controller;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.model.*;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static lotto.model.Lotto.LOTTO_SIZE;
import static lotto.model.LottoNumber.END_NUMBER;
import static lotto.model.LottoNumber.START_NUMBER;
import static lotto.view.InputView.*;
import static lotto.view.OutputView.printLottoList;
import static lotto.view.OutputView.printResult;

public class LottoController extends LottoControllerTemplate {

    @Override
    protected void runImpl() {
        final Money money = new Money(inputMoney());
        makeResult(publishLottos(money.getLottoTicketCount()), makeWinningLotto());
    }

    private List<Lotto> publishLottos(final int count) {
        final List<Lotto> lottos = IntStream.range(0, count)
                .mapToObj(i -> Randoms.pickUniqueNumbersInRange(START_NUMBER, END_NUMBER, LOTTO_SIZE))
                .map(Lotto::of)
                .collect(Collectors.toList());

        printLottoList(lottos);

        return lottos;
    }

    private WinningLotto makeWinningLotto() {
        final List<Integer> numbers = inputLottoNumber();
        final int bonusNumber = inputBonusNumber();

        return new WinningLotto(Lotto.of(numbers), new LottoNumber(bonusNumber));
    }

    private void makeResult(final List<Lotto> lottos, final WinningLotto winningLotto) {
        printResult(new ResultMap(lottos, winningLotto));
    }

}
