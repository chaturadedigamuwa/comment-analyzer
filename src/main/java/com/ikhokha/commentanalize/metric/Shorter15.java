package com.ikhokha.commentanalize.metric;

import com.ikhokha.commentanalize.util.Constants;

public class Shorter15 implements Metric {
    @Override
    public String getMetricName() {
        return Constants.METRIC_LENGTH_SHORTER_THAN_15;
    }
}
