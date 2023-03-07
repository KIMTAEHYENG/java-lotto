package lotto.service;

import lotto.model.Lotto;
import lotto.model.LottoRequest;
import lotto.model.MatchResult;

import java.util.List;

public class LottoMatcher {

    public MatchResult[] calculateMatch(List<Lotto> lottoList, LottoRequest request) {
        MatchResult[] result = MatchResult.values();

        for (Lotto lotto : lottoList) {
            int matchCount = lotto.calculateMatchCount(request.getNumbers());
            boolean isMatchBonusNumber = lotto.isMatchBonusNumber(request.getBonusNumber());

            MatchResult.valueOf(matchCount, isMatchBonusNumber)
                    .ifPresent((match) -> match.increaseQuantity());
        }

        return result;
    }
}
