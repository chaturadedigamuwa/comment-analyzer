package com.ikhokha.commentanalize.metric;

import com.ikhokha.commentanalize.util.Constants;

public class Shaker implements Metric {

    @Override
    public String getMetricName() {
        return Constants.METRIC_SHAKER_MENTIONS;
    }
}
