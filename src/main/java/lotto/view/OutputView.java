package lotto.view;

import lotto.model.Lotto;
import lotto.model.MatchResult;

import java.util.List;

public class OutputView {

    private static final String RATE_OF_RETURN_MESSAGE = "총 수익률은 %.1f%%입니다.";
    private static final int HUNDRED = 100;

    public static void printLottoList(List<Lotto> lottoList) {
        System.out.println(lottoList.size() + "개를 구매했습니다.");

        for (Lotto lotto : lottoList) {
            System.out.println(lotto);
        }

        System.out.println();
    }

    public static void printMatchResult(int amount, MatchResult[] matchResults) {
        System.out.println("당첨 통계");
        System.out.println("---");

        float totalAmount = 0f;

        for (MatchResult matchResult : matchResults) {
            totalAmount += matchResult.calculateTotalWinningMoney();
            System.out.println(matchResult);
        }

        System.out.printf(RATE_OF_RETURN_MESSAGE, calculateMargin(totalAmount, amount));
    }

    private static float calculateMargin(float totalAmount, int amount) {
        return (totalAmount / amount) * HUNDRED;
    }
}
