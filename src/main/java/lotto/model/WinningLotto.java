package lotto.model;

import static lotto.model.Lotto.END_NUMBER;
import static lotto.model.Lotto.START_NUMBER;

public class WinningLotto {

    private Lotto winningLotto;
    private int bonusNumber;

    public WinningLotto(Lotto winningLotto, int bonusNumber) {
        validateRange(bonusNumber);
        validateDuplicate(winningLotto, bonusNumber);

        this.winningLotto = winningLotto;
        this.bonusNumber = bonusNumber;
    }

    public int calculateMatchCount(Lotto lotto) {
        return (int) winningLotto.getNumbers().stream()
                .filter(lotto::isContains)
                .count();
    }

    public Rank calculateRank(Lotto lotto) {
        return Rank.valueOf(calculateMatchCount(lotto), lotto.isContains(bonusNumber));
    }

    private void validateRange(int bonusNumber) {
        if (outOfRange(bonusNumber)) {
            throw new IllegalArgumentException(
                    String.format("로또 범위는 %d ~ %d사이 숫자여야 합니다.", START_NUMBER, END_NUMBER));
        }
    }

    private void validateDuplicate(Lotto lotto, int bonusNumber) {
        if (lotto.isContains(bonusNumber)) {
            throw new IllegalArgumentException("입력하신 로또 번호가 중복됩니다.");
        }
    }

    private boolean isInRange(int bonusNumber) {
        return START_NUMBER <= bonusNumber && bonusNumber <= END_NUMBER;
    }

    private boolean outOfRange(int number) {
        return !isInRange(number);
    }
}
