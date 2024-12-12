package pairmatching.view;

import camp.nextstep.edu.missionutils.Console;
import pairmatching.util.validation.FunctionValidator;

public class InputView {
    private final String INPUT_FUNCTION = "기능을 선택하세요.\n"
            + "1. 페어 매칭\n"
            + "2. 페어 조회\n"
            + "3. 페어 초기화\n"
            + "Q. 종료";

    public String getFuction() {
        System.out.println(INPUT_FUNCTION);
        String inputFuncion = Console.readLine();
        FunctionValidator.validateChooseFuntion(inputFuncion);
        return inputFuncion;
    }
}
