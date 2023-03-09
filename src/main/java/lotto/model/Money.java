package lotto.model;

public class Money {

    public static final int LOTTO_PRICE = 1000;
    private final int amount;

    public Money(final String amount) {
        this(Integer.parseInt(amount));
    }

    public Money(final int amount) {
        validate(amount);

        this.amount = amount;
    }

    public int getTicketCount() {
        return amount / LOTTO_PRICE;
    }

    private void validate(final int amount) {
        if (isNegative(amount)) {
            throw new IllegalArgumentException("로또 구입 금액은 0 이상의 숫자여야 합니다.");
        }

        if (canBuyLotto(amount)) {
            throw new IllegalArgumentException("로또를 구입할 수 없습니다.");
        }

        if (divisible(amount)) {
            throw new IllegalArgumentException(String.format("로또 구입 금액이 %d 으로 나누어 떨이져야 합니다.", LOTTO_PRICE));
        }
    }

    private boolean isNegative(final int value) {
        return value < 0;
    }

    private boolean canBuyLotto(final int amount) {
        return amount < LOTTO_PRICE;
    }

    private boolean divisible(final int value) {
        return value % LOTTO_PRICE != 0;
    }
}
