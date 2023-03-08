package lotto.model;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class ResultMap {

    private final Map<Rank, Integer> resultMap;
    private static final int HUNDRED = 100;

    public ResultMap(WinningLotto winningLotto, List<Lotto> lottoList) {
        this.resultMap = initResultMap();
        calculateResultMap(winningLotto, lottoList);
    }

    public float calculateRateOfReturn() {
        return (getTotalWinningMoney() / getAmount()) * HUNDRED;
    }

    private float getTotalWinningMoney() {
        return resultMap.entrySet().stream()
                .map(entry -> (float) entry.getKey().getWinningMoney() * entry.getValue())
                .reduce(0f, Float::sum);
    }

    private int getAmount() {
        return resultMap.entrySet().stream()
                .mapToInt(entry -> entry.getValue() * Money.LOTTO_PRICE)
                .sum();
    }

    private Map<Rank, Integer> initResultMap() {
        Map<Rank, Integer> result = new HashMap<>();

        Arrays.stream(Rank.values())
                .forEach(rank -> result.put(rank, 0));

        return result;
    }

    private Map<Rank, Integer> calculateResultMap(WinningLotto winningLotto, List<Lotto> lottoList) {
        lottoList.stream()
                .map(lotto -> winningLotto.calculateRank(lotto))
                .forEach(rank -> resultMap.replace(rank, resultMap.get(rank) + 1));

        return resultMap;
    }

    @Override
    public String toString() {
        return resultMap.entrySet().stream()
                .sorted(Map.Entry.<Rank, Integer>comparingByKey().reversed())
                .filter(entry -> entry.getKey() != Rank.NONE)
                .map(entry -> entry.getKey() + " - " + entry.getValue())
                .collect(Collectors.joining("\n"));
    }
}
