package lotto;

import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import lotto.ui.Guide;

public class Application {

    public static void main(String[] args) {
        // TODO: 프로그램 구현
    }

    private static int askPurchaseAmount() {
        Guide.ASK_PURCHASE_AMOUNT.print();
        return Integer.parseInt(Console.readLine());
    }

    private static List<Integer> askWinningNumbers() {
        Guide.ASK_WINNING_NUMBER.print();

        String[] winningNumbers = Console.readLine().split(",");
        return Arrays.stream(winningNumbers)
            .map(Integer::parseInt)
            .collect(Collectors.toList());
    }

    private static Integer askBonusNumber() {
        Guide.ASK_BONUS_NUMBER.print();

        String bonusNumber = Console.readLine();
        validate(bonusNumber);
        return Integer.parseInt(bonusNumber);
    }

    private static void validate(String bonusNumber) {
        Pattern correctInputPattern = Pattern.compile("^([1-9]|1[0-9]|2[0-9]|3[0-9]|4[0-5])$");
        if (!correctInputPattern.matcher(bonusNumber).find()) {
            throw new IllegalArgumentException(Error.IS_NOT_CORRECT_NUMBER.getMessage());
        }
    }
}
