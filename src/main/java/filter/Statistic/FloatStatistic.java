package filter.Statistic;

import java.util.List;
import java.util.Objects;

public final class FloatStatistic {

    public static Double getMin(List<Double> list) {
        Double min = Double.MAX_VALUE;
        for (Double elem: list) {
            min = Math.min(min, elem);
        }
        return min;
    }

    public static Double getMax(List<Double> list) {
        Double max = Double.MIN_VALUE;
        for (Double elem: list) {
            max = Math.max(max, elem);
        }
        return max;
    }

    public static Double getSum(List<Double> list) {
        Double sum = 0d;
        for (Double elem: list) {
            sum += elem;
        }
        return sum;
    }

    public static Double getAverage(List<Double> list) {
        return getSum(list) / list.size();
    }
}