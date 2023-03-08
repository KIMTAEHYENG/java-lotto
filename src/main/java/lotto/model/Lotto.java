package lotto.model;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class Lotto {

    public static final int START_NUMBER = 1;
    public static final int END_NUMBER = 45;
    public static final int LOTTO_SIZE = 6;
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        validateRange(numbers);
        validateDuplicate(numbers);

        this.numbers = numbers;
    }

    public boolean isContains(int number) {
        return numbers.contains(number);
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != LOTTO_SIZE) {
            throw new IllegalArgumentException("로또 목록의 사이즈는 6 이여야 합니다.");
        }
    }

    // TODO: 추가 기능 구현
    public List<Integer> getNumbers() {
        return List.copyOf(numbers);
    }

    private void validateRange(List<Integer> numbers) {
        if (hasOutOfRange(numbers)) {
            throw new IllegalArgumentException(
                    String.format("로또 범위는 %d ~ %d사이 숫자여야 합니다.", START_NUMBER, END_NUMBER));
        }
    }

    private void validateDuplicate(List<Integer> numbers) {
        Set<Integer> uniqueNumbers = new HashSet<>(numbers);

        if (uniqueNumbers.size() < numbers.size()) {
            throw new IllegalArgumentException("입력하신 로또 번호가 중복됩니다.");
        }
    }

    private boolean isInRange(int number) {
        return START_NUMBER <= number && number <= END_NUMBER;
    }

    private boolean outOfRange(int number) {
        return !isInRange(number);
    }

    private boolean hasOutOfRange(List<Integer> numbers) {
        return numbers.stream().anyMatch(this::outOfRange);
    }

    @Override
    public String toString() {
        return numbers.stream().sorted()
                .collect(Collectors.toList())
                .toString();
    }
}
