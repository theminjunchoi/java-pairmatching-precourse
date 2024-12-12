package pairmatching.domain;

import java.util.ArrayList;
import java.util.List;

public class Stage {
    private final String track;
    private final int level;
    private final String mission;
    private final List<List<String>> pairs;

    public Stage(String track, int level, String mission) {
        this.track = track;
        this.level = level;
        this.mission = mission;
        this.pairs = new ArrayList<>();
    }

    public String getTrack() {
        return track;
    }

    public int getLevel() {
        return level;
    }

    public String getMission() {
        return mission;
    }

    @Override
    public boolean equals(Object obj) {
        if(!(obj instanceof Stage)) {
            return false;
        }
        Stage stage = (Stage) obj;
        return stage.track.equals(track) && stage.level == level && stage.mission.equals(mission);
    }
}

