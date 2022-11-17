package com.ikhokha.commentanalize.factory;

import com.ikhokha.commentanalize.contact.CommentAbstractFactory;
import com.ikhokha.commentanalize.metric.Metric;
import com.ikhokha.commentanalize.metric.Shorter15;
import com.ikhokha.commentanalize.util.Constants;
import org.apache.commons.lang3.StringUtils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * factory to create concrete classes with operations related to lengths of comment lines
 */
public class LengthFactory implements CommentAbstractFactory<List<Metric>> {

    static Map<Integer, Metric> metricsMapper = new HashMap<>();
    static {
        metricsMapper.put(Constants.LENGTH_15, new Shorter15());
        // more lengths can be added here
    }

    /**
     * compare the length of the input comment lines
     * @param line
     * @return map with spawned concrete classes
     */
    public List<Metric> getLengthClass(CharSequence line) {
        List<Metric> lengthMetrics = new ArrayList<>();
        metricsMapper.forEach((length, value) -> {
            if(StringUtils.length(line) < length) {
                lengthMetrics.add(value);
            }}
        );
        return lengthMetrics;
    }


    @Override
    public List<Metric> create(CharSequence line) {
        return getLengthClass(line);
    }
}
