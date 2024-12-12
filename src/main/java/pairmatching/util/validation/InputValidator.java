package pairmatching.util.validation;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import pairmatching.domain.Stage;
import pairmatching.util.exception.InputException;

public class InputValidator {
    private static final Set<String> validOptions = new HashSet<>(Arrays.asList("1", "2", "3", "Q"));

    public static void validateChooseFuntion(String uncheckFunction) {
        if (!validOptions.contains(uncheckFunction)) {
            throw new IllegalArgumentException(InputException.INVALID_CHOOSE.getExceptionMessage());
        }
    }

    public static void validateStageInfo(List<Stage> stageInfo, String inputStageInfo) {
        List<String> stageValues = List.of(inputStageInfo.replace(" ", "").split(","));
        String track = stageValues.get(0);
        int level = Integer.parseInt(stageValues.get(1).replace("레벨", ""));
        String mission = stageValues.get(2);
        Stage stage = new Stage(track, level, mission);
        if (!stageInfo.contains(stage)) {
            throw new IllegalArgumentException(InputException.INVALID_STAGE.getExceptionMessage());
        }
    }
}
