package subway;

import subway.domain.GraphRepository;

public class Validator {

    public static boolean isDifferentNames(String name1, String name2) {
        if (name1.equals(name2)) {
            System.out.println("[ERROR] 출발역과 도착역은 다른 역이어야 합니다.");
            return false;
        }
        return true;
    }

    public static boolean canGoThere(String startStation, String endStation) {
        return true;
    }
}
