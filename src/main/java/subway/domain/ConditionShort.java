package subway.domain;

import java.util.Arrays;

public enum ConditionShort {
    DISTANCE("1"), TIME("2");

    private final String value;

    ConditionShort(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public static ConditionShort getByValue(String value) {
        return Arrays.stream(ConditionShort.values())
                .filter(conditionShort -> conditionShort.getValue().equals(value))
                .findFirst().orElseThrow(IllegalArgumentException::new);
    }
}
