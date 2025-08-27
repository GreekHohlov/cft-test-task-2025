package filter;

import filter.Statistic.FloatStatistic;
import filter.Statistic.IntegerStatistic;
import filter.Statistic.StringStatistic;
import filter.service.ReadWriteFile;

import java.util.ArrayList;
import java.util.List;

public class Filter {
    private List<String> stringList;
    private List<Long> integerList;
    private List<Double> floatList;
    private String statisticType;

    public Filter(String statisticType) {
        stringList = new ArrayList<>();
        integerList = new ArrayList<>();
        floatList = new ArrayList<>();
        this.statisticType = statisticType;
    }

    public List<String> getStringList() {
        return stringList;
    }

    public List<Long> getIntegerList() {
        return integerList;
    }

    public List<Double> getFloatList() {
        return floatList;
    }

    public void startFilter(List<String> files) {
        List<String> allString = ReadWriteFile.readFile(files);
        for (String elem : allString) {
            try {
                integerList.add(Long.parseLong(elem));
            } catch (IllegalArgumentException integers) {
                try {
                    floatList.add(Double.parseDouble(elem));
                } catch (IllegalArgumentException floats) {
                    stringList.add(elem);
                }
            }
        }
    }


    public String toString() {
        if (statisticType.isEmpty()) {
            return "";
        }
        StringBuilder string = new StringBuilder();
        string.append("Количество целых чисел: ").append(integerList.size()).append("\n");
        if (statisticType.equals("-f") && !(integerList.isEmpty())) {
            string.append("Минимальное число: ").append(IntegerStatistic.getMin(integerList)).append("\n");
            string.append("Максимальное число: ").append(IntegerStatistic.getMax(integerList)).append("\n");
            string.append("Сумма: ").append(IntegerStatistic.getSum(integerList)).append("\n");
            string.append("Среднее ").append(IntegerStatistic.getAverage(integerList)).append("\n\n");
        }

        string.append("Количество дробных чисел: ").append(floatList.size()).append("\n");
        if (statisticType.equals("-f") && !(floatList.isEmpty())) {
            string.append("Минимальное число: ").append(FloatStatistic.getMin(floatList)).append("\n");
            string.append("Максимальное число: ").append(FloatStatistic.getMax(floatList)).append("\n");
            string.append("Сумма: ").append(FloatStatistic.getSum(floatList)).append("\n");
            string.append("Среднее ").append(FloatStatistic.getAverage(floatList)).append("\n\n");
        }

        string.append("Количество строк: ").append(stringList.size()).append("\n");
        if (statisticType.equals("-f") && !(stringList.isEmpty())) {
            string.append("Самая короткая строка - символов: ").append(StringStatistic.getShortString(stringList)).append("\n");
            string.append("Самая длинная строка - символов: ").append(StringStatistic.getLongString(stringList)).append("\n\n");
        }
        return string.toString();
    }
}