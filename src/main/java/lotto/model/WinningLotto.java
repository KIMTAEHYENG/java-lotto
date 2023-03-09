package lotto.model;

import java.util.Arrays;
import java.util.function.Predicate;

import static lotto.model.Rank.NONE;

public class WinningLotto {

    private final Lotto winningLotto;
    private final LottoNumber bonusNumber;

    public WinningLotto(final Lotto winningLotto, final LottoNumber bonusNumber) {
        validateDuplicate(winningLotto, bonusNumber);

        this.winningLotto = winningLotto;
        this.bonusNumber = bonusNumber;
    }

    public Rank calculateRank(final Lotto lotto) {
        return findRank(lotto.matchCount(winningLotto), lotto.contains(bonusNumber));
    }

    private Rank findRank(final int matchCount, final boolean isMatchBonusNumber) {
        return Arrays.stream(Rank.values())
                .filter(isMatch(matchCount, isMatchBonusNumber))
                .findFirst()
                .orElse(NONE);
    }

    private Predicate<Rank> isMatch(final int matchCount, final boolean isMatchBonusNumber) {
        return r -> r.getMatchCount() == matchCount && r.isMatchBonusNumber() == isMatchBonusNumber;
    }

    private void validateDuplicate(final Lotto lotto, final LottoNumber bonusNumber) {
        if (lotto.contains(bonusNumber)) {
            throw new IllegalArgumentException("입력하신 로또 번호가 중복됩니다.");
        }
    }
}
