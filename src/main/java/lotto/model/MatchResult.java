package lotto.model;

import java.text.DecimalFormat;
import java.util.Optional;

public enum MatchResult {

    THREE(3, false, 5_000, 0),
    FOUR(4, false, 50_000, 0),
    FIVE(5, false, 1_500_000, 0),
    FIVE_HALF(5, true, 30_000_000, 0),
    SIX(6, false, 2_000_000_000, 0);

    private static DecimalFormat DECIMAL_FORMAT = new DecimalFormat("###,###");
    private static String MATCH_MESSAGE = "%d개 일치 (%s원) - %d개";
    private static String BONUS_MATCH_MESSAGE = "%d개 일치, 보너스 볼 일치 (%s원) - %d개";

    private int matchCount;
    private boolean isMatchBonusNumber;
    private int winningMoney;
    private int quantity;

    MatchResult(int matchCount, boolean isMatchBonusNumber, int winningMoney, int quantity) {
        this.matchCount = matchCount;
        this.isMatchBonusNumber = isMatchBonusNumber;
        this.winningMoney = winningMoney;
        this.quantity = quantity;
    }

    public int calculateTotalWinningMoney() {
        return winningMoney * quantity;
    }

    public void increaseQuantity() {
        this.quantity++;
    }

    public static Optional<MatchResult> valueOf(int matchCount, boolean isMatchBonusNumber) {
        for (MatchResult matchResult : MatchResult.values()) {
            if (isMatch(matchResult, matchCount, isMatchBonusNumber)) {
                return Optional.ofNullable(matchResult);
            }
        }

        return Optional.empty();
    }

    private static boolean isMatch(MatchResult matchResult, int matchCount, boolean isMatchBonusNumber) {
        return matchResult.isMatchBonusNumber == isMatchBonusNumber && matchResult.matchCount == matchCount;
    }

    @Override
    public String toString() {
        if (isMatchBonusNumber) {
            return print(BONUS_MATCH_MESSAGE);
        }

        return print(MATCH_MESSAGE);
    }

    public String print(String message) {
        return String.format(message, matchCount, DECIMAL_FORMAT.format(winningMoney), quantity);
    }
}
