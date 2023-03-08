package lotto.view;

import lotto.model.Lotto;
import lotto.model.ResultMap;

import java.util.List;

public class OutputView {

    private static final String RATE_OF_RETURN_MESSAGE = "총 수익률은 %.1f%%입니다.";

    public static void printLottoList(List<Lotto> lottoList) {
        System.out.println(lottoList.size() + "개를 구매했습니다.");

        lottoList.stream()
                .forEach(System.out::println);

        System.out.println();
    }

    public static void printResult(ResultMap resultMap) {
        System.out.println("당첨 통계");
        System.out.println("---");
        System.out.println(resultMap);
        System.out.printf(RATE_OF_RETURN_MESSAGE, resultMap.calculateRateOfReturn());
    }
}
