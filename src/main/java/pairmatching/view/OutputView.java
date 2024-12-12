package pairmatching.view;

import java.util.List;
import pairmatching.domain.Stage;

public class OutputView {
    private final String LINE = "#############################################";
    private final String INFO = "과정: 백엔드 | 프론트엔드\n"
            + "미션:\n"
            + "  - 레벨1: 자동차경주 | 로또 | 숫자야구게임\n"
            + "  - 레벨2: 장바구니 | 결제 | 지하철노선도\n"
            + "  - 레벨3: \n"
            + "  - 레벨4: 성능개선 | 배포\n"
            + "  - 레벨5: ";

    public void printStageInfo(List<Stage> stageInfo) {
        for (Stage stage : stageInfo) {
            System.out.printf("%s %d %s\n", stage.getTrack(), stage.getLevel(), stage.getMission());
        }

    }

    public void printErrorMessage(Exception e) {
        System.out.println(e);
    }

    public void printTrackAndMission() {
        System.out.println(LINE);
        System.out.println(INFO);
        System.out.println(LINE);
    }


}
