package com.ikhokha.commentanalize.service;

import java.util.Map;

public interface ICommentAnalyzer {
    /**
     * start analyzing process and reading the files
     * @param resultsMap
     * @return
     */
    Map<String, Integer> analyze(Map<String, Integer> resultsMap);

}
