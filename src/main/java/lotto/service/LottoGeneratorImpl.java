package lotto.service;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.model.Lotto;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LottoGeneratorImpl implements LottoGenerator {

    public List<Lotto> createLottoList(int count) {
        return IntStream.range(0, count)
                .mapToObj(i -> new Lotto(
                        Randoms.pickUniqueNumbersInRange(Lotto.START_NUMBER, Lotto.END_NUMBER, Lotto.LOTTO_SIZE)))
                .collect(Collectors.toList());
    }
}