package lotto.model;

import java.text.DecimalFormat;

public enum Rank {

    FIRST(6, false, 2_000_000_000),
    SECOND(5, true, 30_000_000),
    THIRD(5, false, 1_500_000),
    FOURTH(4, false, 50_000),
    FIFTH(3, false, 5_000),
    NONE(0, false, 0);

    private static final DecimalFormat DECIMAL_FORMAT = new DecimalFormat("###,###");
    private static final String MATCH_MESSAGE = "%d개 일치 (%s원)";
    private static final String BONUS_MATCH_MESSAGE = "%d개 일치, 보너스 볼 일치 (%s원)";

    private final boolean isMatchBonusNumber;
    private final int matchCount;
    private final int winningAmount;

    Rank(final int matchCount, final boolean isMatchBonusNumber, final int winningAmount) {
        this.matchCount = matchCount;
        this.isMatchBonusNumber = isMatchBonusNumber;
        this.winningAmount = winningAmount;
    }

    public int getWinningAmount() {
        return winningAmount;
    }

    public boolean isMatchBonusNumber() {
        return isMatchBonusNumber;
    }

    public int getMatchCount() {
        return matchCount;
    }

    @Override
    public String toString() {
        if (isMatchBonusNumber) {
            return print(BONUS_MATCH_MESSAGE);
        }

        return print(MATCH_MESSAGE);
    }


    public String print(String message) {
        return String.format(message, matchCount, DECIMAL_FORMAT.format(winningAmount));
    }
}
