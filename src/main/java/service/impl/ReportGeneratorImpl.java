package service.impl;

import db.Storage;
import service.ReportGenerator;

public class ReportGeneratorImpl implements ReportGenerator {
    private static final String HEADER = "fruit,quantity";

    @Override
    public String getReport() {
        StringBuilder sb = new StringBuilder(HEADER).append("\n");
        Storage.getFruits().forEach((key, value) ->
                sb.append(key).append(",")
                .append(value).append("\n"));
        return sb.toString();
    }
}
