package com.ikhokha.commentanalize.metric;

import com.ikhokha.commentanalize.util.Constants;

public class Url implements Metric {

    @Override
    public String getMetricName() {
        return Constants.METRIC_URL_MENTIONS ;
    }
}
