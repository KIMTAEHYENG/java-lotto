package lotto.view;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class InputView {

    private static final Scanner SCANNER = new Scanner(System.in);
    private static final String SEPARATOR = ",";

    public static int inputMoney() {
        System.out.println("구입금액을 입력해 주세요.");
        final int result = parseInt(SCANNER.nextLine());
        System.out.println();

        return result;
    }

    public static List<Integer> inputLottoNumber() {
        System.out.println("당첨 번호를 입력해 주세요.");
        final List<Integer> result = StringArrayToIntegerList(split(SCANNER.nextLine()));
        System.out.println();

        return result;
    }

    public static int inputBonusNumber() {
        System.out.println("보너스 번호를 입력해 주세요.");
        final int result = parseInt(SCANNER.nextLine());
        System.out.println();

        return result;
    }

    private static List<Integer> StringArrayToIntegerList(String[] arr) {
        return Arrays.stream(arr)
                .mapToInt(Integer::parseInt)
                .boxed()
                .collect(Collectors.toList());
    }

    private static String[] split(String line) {
        return line.split(SEPARATOR);
    }

    private static int parseInt(String line) {
        return Integer.parseInt(line);
    }
}
