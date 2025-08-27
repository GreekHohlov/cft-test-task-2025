package filter.service;

import filter.Filter;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public final class ReadWriteFile {
    private final static String INTEGERS_OUTPUT_FILE_NAME = "integers.txt";
    private final static String FLOATS_OUTPUT_FILE_NAME = "floats.txt";
    private final static String STRINGS_OUTPUT_FILE_NAME = "strings.txt";
    private static boolean appendSymbol = false;

    public static List<String> readFile(List<String> fileNames) {
        List<String> toRead = new ArrayList<>();
        for (String fileName : fileNames) {
            try (FileReader file = new FileReader(fileName);
                 BufferedReader buffer = new BufferedReader(file)) {
                while (buffer.ready()) {
                    toRead.add(buffer.readLine());
                }
            } catch (IOException e) {
                System.out.println("File not found: " + fileName);
            }
        }
        return toRead;
    }
    public static void writeFile(Filter filter, FilterParameters param) {
        int countElemWrite = 0;
        if (!new File(param.getWritePath()).exists()) {
            new File(param.getWritePath()).mkdirs();
        }
        if (param.getWriteType().equals("-a")) {
            appendSymbol = true;
        }
        if (!filter.getIntegerList().isEmpty()) {
            try (FileWriter writer = new FileWriter(param.getWritePath() + param.getNamePrefix() + INTEGERS_OUTPUT_FILE_NAME, appendSymbol)) {
                for (Long elem: filter.getIntegerList()) {
                    writer.write(elem + "\n");
                    countElemWrite++;
                }
            } catch (IOException e) {
                System.out.println("File not created: " + param.getWritePath() + param.getNamePrefix() + INTEGERS_OUTPUT_FILE_NAME);
            }
        }
        if (!filter.getFloatList().isEmpty()) {
            try (FileWriter writer = new FileWriter(param.getWritePath() + param.getNamePrefix() + FLOATS_OUTPUT_FILE_NAME, appendSymbol)) {
                for (Double elem: filter.getFloatList()) {
                    writer.write(elem + "\n");
                    countElemWrite++;
                }
            } catch (IOException e) {
                System.out.println("File not created: " + param.getWritePath() + param.getNamePrefix() + FLOATS_OUTPUT_FILE_NAME);
            }
        }
        if (!filter.getStringList().isEmpty()) {
            try (FileWriter writer = new FileWriter(param.getWritePath() + param.getNamePrefix() + STRINGS_OUTPUT_FILE_NAME, appendSymbol)) {
                for (String elem: filter.getStringList()) {
                    writer.write(elem + "\n");
                    countElemWrite++;
                }
            } catch (IOException e) {
                System.out.println("File not created: " + param.getWritePath() + param.getNamePrefix() + STRINGS_OUTPUT_FILE_NAME);
            }
        }
        if (param.getStatisticType().equals("-s")) {
            System.out.printf("Количество записанных элементов: %d\n", countElemWrite);
        }
        if (param.getStatisticType().equals("-f")) {
            System.out.println(filter.getFullStatistic());
        }
    }
}