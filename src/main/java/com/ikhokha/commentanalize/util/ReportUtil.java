package com.ikhokha.commentanalize.util;

import java.util.Map;

public class ReportUtil {
    /**
     * This method adds the result counts from a source map to the target map
     * @param source the source map
     * @param target the target map
     */
    public static void addReportResults(Map<String, Integer> source, Map<String, Integer> target) {

        for (Map.Entry<String, Integer> entry : source.entrySet()) {
            target.put(entry.getKey(), entry.getValue());
        }

    }
}
