package filter;

import filter.service.FilterParameters;
import filter.service.ReadWriteFile;

public class Main {
    public static void main(String[] args) {
        FilterParameters param = new FilterParameters(args);
        Filter filter = new Filter(param.getStatisticType());
        filter.startFilter(param.getFiles());
        ReadWriteFile.writeFile(filter, param);
        System.out.println(filter);
    }
}