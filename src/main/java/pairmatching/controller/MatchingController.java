package pairmatching.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import pairmatching.domain.Stage;
import pairmatching.service.MatchingService;
import pairmatching.util.exception.InputException;
import pairmatching.view.InputView;
import pairmatching.view.OutputView;

public class MatchingController {
    private final InputView inputView;
    private final OutputView outputView;
    private List<Stage> stageInfo;

    public MatchingController() {
        this.inputView = new InputView();
        this.outputView = new OutputView();
    }

    public void run() {
        MatchingService matchingService = new MatchingService();
        stageInfo = matchingService.makeStages();
        Map<String, Runnable> functionMap = makeFuntionMap();
        String functionNumber = getFunctionNumber();
        Runnable action = functionMap.get(functionNumber);
        action.run();
    }

    private String getFunctionNumber() {
        try {
            return inputView.getFuction();
        } catch (IllegalArgumentException e) {
            outputView.printErrorMessage(e);
            return getFunctionNumber();
        }
    }

    private Map<String, Runnable> makeFuntionMap() {
        Map<String, Runnable> functionMap = new HashMap<>();
        functionMap.put("1", this::match);
        functionMap.put("2", this::view);
        functionMap.put("3", this::reset);
        functionMap.put("Q", this::quit);
        return functionMap;
    }

    private void match() {
        System.out.println("1번고름");
        outputView.printTrackAndMission();
        String stageinfo = getStage();
        // 매칭 이력 있는지 확인, 없으면 생성, 있으면 다시 할건지 물어보고 판단
        if (findStage(stageinfo)) {
            if (askAgain()) {
                generatePair();
            }
            getInput();
        }
        generatePair();
    }

    private boolean askAgain() {
        try {
            String answer = inputView.getAgainMatch();
            return answer.equals("네");
        } catch (IllegalArgumentException e) {
            return askAgain();
        }
    }

    private boolean findStage(String stageinfo) {
        List<String> stageValues = List.of(stageinfo.replace(" ", "").split(","));
        String track = stageValues.get(0);
        int level = Integer.parseInt(stageValues.get(1).replace("레벨", ""));
        String mission = stageValues.get(2);
        Stage stage = new Stage(track, level, mission);
        if (stageInfo.contains(stage)) {
            return true;
        }
        return false;
    }

    private void view() {
        System.out.println("2번고름");
        outputView.printTrackAndMission();
        String stageinfo = getStage();
    }

    private void reset() {
        System.out.println("3번고름");
    }

    private void quit() {
        return ;
    }

    private String getStage() {
        try {
            return inputView.getStageInfo(stageInfo);
        } catch (IllegalArgumentException e) {
            outputView.printErrorMessage(e);
            return inputView.getStageInfo(stageInfo);
        }
    }
}
