package lotto.service;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.model.Lotto;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static lotto.model.LottoNumber.END_NUMBER;
import static lotto.model.LottoNumber.START_NUMBER;

public class LottoGeneratorImpl implements LottoGenerator {

    @Override
    public List<Lotto> createLottoList(int count) {
        return IntStream.range(0, count)
                .mapToObj(i -> Randoms.pickUniqueNumbersInRange(START_NUMBER, END_NUMBER, Lotto.LOTTO_SIZE))
                .map(Lotto::valueOf)
                .collect(Collectors.toList());
    }
}