package com.ikhokha.commentanalize.metric;

import com.ikhokha.commentanalize.util.Constants;

public class QuestionMark implements Metric {

    @Override
    public String getMetricName() {
        return Constants.METRIC_QUESTION_MENTIONS ;
    }
}
