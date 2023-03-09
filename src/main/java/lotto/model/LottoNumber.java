package lotto.model;

public class LottoNumber implements Comparable<LottoNumber> {

    public static final int START_NUMBER = 1;
    public static final int END_NUMBER = 45;
    private final int number;

    public LottoNumber(final int number) {
        validateRange(number);

        this.number = number;
    }

    private void validateRange(final int number) {
        if (outOfRange(number)) {
            throw new IllegalArgumentException(
                    String.format("로또 범위는 %d ~ %d사이 숫자여야 합니다.", START_NUMBER, END_NUMBER));
        }
    }

    private boolean isInRange(final int number) {
        return START_NUMBER <= number && number <= END_NUMBER;
    }

    private boolean outOfRange(final int number) {
        return !isInRange(number);
    }

    @Override
    public String toString() {
        return String.valueOf(number);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        LottoNumber that = (LottoNumber) o;

        return number == that.number;
    }

    @Override
    public int hashCode() {
        return number;
    }

    @Override
    public int compareTo(LottoNumber o) {
        return number - o.number;
    }
}
