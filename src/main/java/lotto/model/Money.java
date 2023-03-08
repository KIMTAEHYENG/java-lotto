package lotto.model;

public class Money {

    private final int money;
    public static final int LOTTO_PRICE = 1000;

    public Money(String money) {
        this(Integer.parseInt(money));
    }

    public Money(int money) {
        validate(money);

        this.money = money;
    }

    public int getCount() {
        return money / LOTTO_PRICE;
    }

    private void validate(int money) {
        if (isNegative(money)) {
            throw new IllegalArgumentException("로또 구입 금액은 0 이상의 숫자여야 합니다.");
        }

        if (isBuyLotto(money)) {
            throw new IllegalArgumentException("로또를 구입할 수 없습니다.");
        }

        if (isRestNonZero(money)) {
            throw new IllegalArgumentException(String.format("로또 구입 금액이 %d 으로 나누어 떨이져야 합니다.", LOTTO_PRICE));
        }
    }

    private boolean isNegative(int value) {
        return value < 0;
    }

    private boolean isBuyLotto(int money) {
        return money < LOTTO_PRICE;
    }

    private boolean isRestNonZero(int value) {
        return value % LOTTO_PRICE != 0;
    }
}
