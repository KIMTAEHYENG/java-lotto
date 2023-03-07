package lotto.controller;

public abstract class LottoControllerTemplate {

    private static final String ERROR_MESSAGE = "[ERROR] ";

    public final void run() {
        try {
            runImpl();
        } catch (IllegalArgumentException e) {
            System.out.println(ERROR_MESSAGE + e.getMessage());
        }
    }

    protected abstract void runImpl();
}
