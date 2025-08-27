package filter.Statistic;

import java.util.List;

public final class IntegerStatistic{

    public static Long getMin(List<Long> list) {
        Long min = Long.MAX_VALUE;
        for (Long elem: list) {
            min = Math.min(min, elem);
        }
        return min;
    }

    public static Long getMax(List<Long> list) {
        Long max = Long.MIN_VALUE;
        for (Long elem: list) {
            max = Math.max(max, elem);
        }
        return max;
    }

    public static Long getSum(List<Long> list) {
        Long sum = 0L;
        for (Long elem: list) {
            sum += elem;
        }
        return sum;
    }

    public static Long getAverage(List<Long> list) {
        return getSum(list) / list.size();
    }
}