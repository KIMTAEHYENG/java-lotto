package lotto.service;

import lotto.model.Lotto;

import java.util.List;

public interface LottoGenerator {

    List<Lotto> createLottoList(int count);
}
