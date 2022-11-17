package com.ikhokha.commentanalize.metric;

import com.ikhokha.commentanalize.util.Constants;

public class Mover implements Metric {

    @Override
    public String getMetricName() {
        return Constants.METRIC_MOVER_MENTIONS;
    }

}
