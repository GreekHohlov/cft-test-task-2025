package filter.Statistic;

import java.util.List;
import java.util.Objects;

public final class StringStatistic {
    private static Integer shortString;
    private static Integer longString;

    public static Integer getShortString(List<String> list) {
        if (!Objects.isNull(shortString)) {
            return shortString;
        }
        shortString = Integer.MAX_VALUE;
        for (String elem: list) {
            shortString = Math.min(shortString, elem.length());
        }
        return shortString;
    }

    public static Integer getLongString(List<String> list) {
        if (!Objects.isNull(longString)) {
            return longString;
        }
        longString = 0;
        for (String elem: list) {
            longString = Math.max(longString, elem.length());
        }
        return longString;
    }
}