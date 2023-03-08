package lotto.model;

public class WinningLotto {

    private final Lotto winningLotto;
    private final LottoNumber bonusNumber;

    public WinningLotto(Lotto winningLotto, LottoNumber bonusNumber) {
        validateDuplicate(winningLotto, bonusNumber);

        this.winningLotto = winningLotto;
        this.bonusNumber = bonusNumber;
    }

    public int calculateMatchCount(Lotto lotto) {
        return (int) winningLotto.getNumbers().stream()
                .filter(lotto::contains)
                .count();
    }

    public Rank calculateRank(Lotto lotto) {
        return Rank.valueOf(calculateMatchCount(lotto), lotto.contains(bonusNumber));
    }

    private void validateDuplicate(Lotto lotto, LottoNumber bonusNumber) {
        if (lotto.contains(bonusNumber)) {
            throw new IllegalArgumentException("입력하신 로또 번호가 중복됩니다.");
        }
    }
}
