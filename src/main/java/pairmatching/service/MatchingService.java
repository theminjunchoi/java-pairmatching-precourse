package pairmatching.service;

import java.util.ArrayList;
import java.util.List;
import pairmatching.domain.Level;
import pairmatching.domain.Stage;
import pairmatching.domain.Track;


public class MatchingService {
    private final List<Stage> stageInfo;

    public MatchingService() {
        this.stageInfo = new ArrayList<>();
    }

    public List<Stage> makeStages() {
       makeStageOfTrack(Track.FE);
       makeStageOfTrack(Track.BE);
       return stageInfo;
    }

    private void makeStageOfTrack(String track) {
        for (int i = 1; i <= 5 ; i++) {
            List<String> missionsOfLevel = Level.findMissions(i);
            int missionCount = missionsOfLevel.size();;
            if (missionCount == 1) {
                missionCount = 0;
            }
            for (int j = 0; j < missionCount; j++) {
                stageInfo.add(new Stage(track, i, missionsOfLevel.get(j)));
            }
        }
    }




}
