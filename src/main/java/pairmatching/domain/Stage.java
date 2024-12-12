package pairmatching.domain;

import java.util.ArrayList;
import java.util.List;

public class Stage {
    private final Track track;
    private final Level level;
    private final String mission;
    private final List<List<String>> pairs;

    public Stage(Track track, Level level, String mission) {
        this.track = track;
        this.level = level;
        this.mission = mission;
        this.pairs = new ArrayList<>();
    }
}
