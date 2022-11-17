package com.ikhokha.commentanalize.metric;

import java.util.Map;

/**
 * interface to contain contracts for concrete classes
 */
public interface Metric {

    /**
     * get the name of the metric to later add to results map
      * @return
     */
    String getMetricName();

    /**
     * This method increments a counter by 1 for a match type on the countMap. Uninitialized keys will be set to 1
     *
     * @param countMap the map that keeps track of counts
     * @param key      the key for the value to increment
     */
    static void incOccurrence(Map<String, Integer> countMap, String key) {
        countMap.putIfAbsent(key, 0);
        countMap.put(key, countMap.get(key) + 1);
    }
}
