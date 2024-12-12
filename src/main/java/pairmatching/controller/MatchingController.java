package pairmatching.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import pairmatching.domain.Stage;
import pairmatching.service.MatchingService;
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
        String stageinfo = inputView.getStageInfo();
    }

    private void view() {
        System.out.println("2번고름");
        outputView.printTrackAndMission();

    }

    private void reset() {
        System.out.println("3번고름");
    }

    private void quit() {
        return ;
    }

//    private void checkAction(Runnable action) {
//        if (action == null) {
//            throw new IllegalArgumentException("hi");
//        }
//    }
}
