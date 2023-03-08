package lotto.model;

import java.text.DecimalFormat;

public enum Rank {

    FIRST(6, false, 2_000_000_000),
    SECOND(5, true, 30_000_000),
    THIRD(5, false, 1_500_000),
    FOURTH(4, false, 50_000),
    FIFTH(3, false, 5_000),
    NONE(0, false, 0);

    private static DecimalFormat DECIMAL_FORMAT = new DecimalFormat("###,###");
    private static String MATCH_MESSAGE = "%d개 일치 (%s원)";
    private static String BONUS_MATCH_MESSAGE = "%d개 일치, 보너스 볼 일치 (%s원)";

    private boolean isMatchBonusNumber;
    private int matchCount;
    private int winningMoney;

    Rank(int matchCount, boolean isMatchBonusNumber, int winningMoney) {
        this.matchCount = matchCount;
        this.isMatchBonusNumber = isMatchBonusNumber;
        this.winningMoney = winningMoney;
    }

    public int getWinningMoney() {
        return winningMoney;
    }

    public static Rank valueOf(int matchCount, boolean isMatchBonusNumber) {
        for (Rank rank : Rank.values()) {
            if (isMatch(rank, matchCount, isMatchBonusNumber)) {
                return rank;
            }
        }

        return NONE;
    }

    private static boolean isMatch(Rank rank, int matchCount, boolean isMatchBonusNumber) {
        return rank.isMatchBonusNumber == isMatchBonusNumber && rank.matchCount == matchCount;
    }

    @Override
    public String toString() {
        if (isMatchBonusNumber) {
            return print(BONUS_MATCH_MESSAGE);
        }

        return print(MATCH_MESSAGE);
    }



    public String print(String message) {
        return String.format(message, matchCount, DECIMAL_FORMAT.format(winningMoney));
    }
}
