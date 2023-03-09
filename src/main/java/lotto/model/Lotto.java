package lotto.model;

import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class Lotto {

    public static final int LOTTO_SIZE = 6;
    private final List<LottoNumber> numbers;

    public Lotto(final List<LottoNumber> numbers) {
        validateSize(numbers);
        validateDuplicate(numbers);
        Collections.sort(numbers);

        this.numbers = numbers;
    }

    public static Lotto of(final List<Integer> numbers) {
        return new Lotto(numbers
                .stream()
                .map(LottoNumber::new)
                .collect(Collectors.toList()));
    }

    public int matchCount(final Lotto lotto) {
        return (int) numbers.stream()
                .filter(lotto::contains)
                .count();
    }

    public boolean contains(final LottoNumber number) {
        return numbers.contains(number);
    }

    private void validateSize(final List<LottoNumber> numbers) {
        if (numbers.size() != LOTTO_SIZE) {
            throw new IllegalArgumentException(String.format("로또 목록의 사이즈는 %d 이여야 합니다.", LOTTO_SIZE));
        }
    }

    private void validateDuplicate(final List<LottoNumber> numbers) {
        Set<LottoNumber> uniqueNumbers = new HashSet<>(numbers);

        if (uniqueNumbers.size() < numbers.size()) {
            throw new IllegalArgumentException("입력하신 로또 번호가 중복됩니다.");
        }
    }

    @Override
    public String toString() {
        return numbers.toString();
    }
}
