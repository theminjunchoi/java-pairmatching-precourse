package pairmatching.domain;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Level {
    public final static String LEVEL_ONE = "자동차경주, 로또, 숫자야구게임";
    public final static String LEVEL_TWO = "장바구니, 결제, 지하철노선도";
    public final static String LEVEL_THREE = "";
    public final static String LEVEL_FOUR = "성능개선, 배포";
    public final static String LEVEL_FIVE = "";

    private static final Map<Integer, String> LEVEL_MAP = new HashMap<>();

    public static List<String> findMissions(int level) {
        String missions = intToLevel(level);
        List<String> missionNames = List.of(missions.replace(" ", "").split(","));
        return missionNames;
    }

    public static String intToLevel(int level) {
        LEVEL_MAP.put(1, LEVEL_ONE);
        LEVEL_MAP.put(2, LEVEL_TWO);
        LEVEL_MAP.put(3, LEVEL_THREE);
        LEVEL_MAP.put(4, LEVEL_FOUR);
        LEVEL_MAP.put(5, LEVEL_FIVE);
        return LEVEL_MAP.get(level);
    }
}
