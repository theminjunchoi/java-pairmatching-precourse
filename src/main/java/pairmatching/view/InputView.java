package pairmatching.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.List;
import pairmatching.domain.Stage;
import pairmatching.util.validation.InputValidator;

public class InputView {
    private final String INPUT_FUNCTION = "기능을 선택하세요.\n"
            + "1. 페어 매칭\n"
            + "2. 페어 조회\n"
            + "3. 페어 초기화\n"
            + "Q. 종료";
    private final String INPUT_STAGE_INFO = "과정, 레벨, 미션을 선택하세요.\n"
            + "ex) 백엔드, 레벨1, 자동차경주";

    public String getFuction() {
        System.out.println(INPUT_FUNCTION);
        String inputFuncion = Console.readLine();
        InputValidator.validateChooseFuntion(inputFuncion);
        return inputFuncion;
    }

    public String getStageInfo(List<Stage> stageInfo) {
        System.out.println(INPUT_STAGE_INFO);
        String inputStageInfo = Console.readLine();
        InputValidator.validateStageInfo(stageInfo, inputStageInfo);
        return inputStageInfo;
    }
}
