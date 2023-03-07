package lotto.model;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class LottoRequest {

    private List<Integer> numbers;
    private int bonusNumber;

    public LottoRequest(List<Integer> numbers, int bonusNumber) {
        validate(numbers);
        validateDuplicate(numbers);
        validateRange(bonusNumber);
        validateContains(numbers, bonusNumber);

        this.numbers = numbers;
        this.bonusNumber = bonusNumber;
    }

    public List<Integer> getNumbers() {
        return numbers;
    }

    public int getBonusNumber() {
        return bonusNumber;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException("로또 목록의 사이즈는 6 이여야 합니다.");
        }

        for (int number : numbers) {
            validateRange(number);
        }
    }

    private void validateDuplicate(List<Integer> numbers) {
        Set<Integer> uniqueNumbers = new HashSet<>(numbers);

        if (uniqueNumbers.size() < numbers.size()) {
            throw new IllegalArgumentException("입력하신 로또 번호가 중복됩니다.");
        }
    }

    private void validateRange(int number) {
        if (isNotInRange(number)) {
            throw new IllegalArgumentException("로또 번호는 1부터 45 사이의 숫자여야 합니다.");
        }
    }

    private void validateContains(List<Integer> numbers, int bonusNumber) {
        if (numbers.contains(bonusNumber)) {
            throw new IllegalArgumentException("로또 번호와 보너스 번호가 중복됩니다.");
        }
    }

    private boolean isRangeValid(int number) {
        return 1 <= number && number <= 45;
    }

    private boolean isNotInRange(int number) {
        return !isRangeValid(number);
    }
}
