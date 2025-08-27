package filter.service;

import java.util.*;

public class FilterParameters {
    private String writePath;
    private String namePrefix;
    private String writeType;
    private String statisticType;
    private List<String> files;

    public FilterParameters(String[] args) {
        this.writePath = "";
        this.namePrefix = "";
        this.writeType = "";
        this.statisticType = "";
        this.files = new ArrayList<>();
        initParameters(args);
    }

    private void initParameters(String[] args) {
        for (int i = 0; i < args.length; i++) {
            if (args[i].equalsIgnoreCase("-o") && !args[i + 1].startsWith("-")) {
                this.writePath = args[i + 1];
            }
            if (args[i].equalsIgnoreCase("-p") && !args[i + 1].startsWith("-")) {
                this.namePrefix = args[i + 1];
            }
            if (args[i].equalsIgnoreCase("-a")) {
                this.writeType = args[i];
            }
            if (args[i].equalsIgnoreCase("-s") || args[i].equalsIgnoreCase("-f")) {
                this.statisticType = args[i];
            }
            if (args[i].endsWith(".txt")) {
                this.files.add(args[i]);
            }
        }
    }

    public String getWritePath() {
        return writePath;
    }

    public String getNamePrefix() {
        return namePrefix;
    }

    public String getWriteType() {
        return writeType;
    }

    public String getStatisticType() {
        return statisticType;
    }

    public List<String> getFiles() {
        return files;
    }
}