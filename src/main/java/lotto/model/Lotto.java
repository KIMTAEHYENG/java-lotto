package lotto.model;

import java.util.List;
import java.util.stream.Collectors;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException("로또 목록의 사이즈는 6 이여야 합니다.");
        }
    }

    // TODO: 추가 기능 구현
    public int calculateMatchCount(List<Integer> pickNumbers) {
        int matchCount = 0;

        for (Integer number : numbers) {
            matchCount = getMatchCount(matchCount, pickNumbers, number);
        }

        return matchCount;
    }

    public boolean isMatchBonusNumber(int bonusNumber) {
        boolean isMatchBonusNumber = false;

        for (Integer number : numbers) {
            if (isEqualNumber(number, bonusNumber)) isMatchBonusNumber = true;
        }

        return isMatchBonusNumber;
    }

    private int getMatchCount(int result, List<Integer> pickNumbers, Integer number) {
        for (Integer pickNumber : pickNumbers) {
            if (isEqualNumber(number, pickNumber)) {
                result++;
            }
        }
        return result;
    }

    private boolean isEqualNumber(int number1, int number2) {
        return number1 == number2;
    }

    @Override
    public String toString() {
        return numbers.stream()
                .sorted()
                .collect(Collectors.toList())
                .toString();
    }
}
