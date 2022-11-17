package com.ikhokha.commentanalize.factory;

import com.ikhokha.commentanalize.contact.CommentAbstractFactory;
import com.ikhokha.commentanalize.metric.*;
import com.ikhokha.commentanalize.util.Constants;
import com.ikhokha.commentanalize.util.StringUtil;
import org.apache.commons.lang3.StringUtils;

import java.util.*;

/**
 * factory to create concrete classes with operations related to words of comment lines
 */
public class WordsFactory implements CommentAbstractFactory<List<Metric>> {

    static Map<String, Metric> metricsMapper = new HashMap<>();

    static {
        metricsMapper.put(Constants.METRIC_MOVER, new Mover());
        metricsMapper.put(Constants.METRIC_SHAKER, new Shaker());
        metricsMapper.put(Constants.METRIC_QUESTION, new QuestionMark());
        metricsMapper.put(Constants.METRIC_URL, new Url());
        // more operators
    }

    /**
     * compare the strings of the input comment lines
     * @param line
     * @return map with spawned concrete classes
     */
    public List<Metric> getMetricsList(CharSequence line) {
        List<Metric> operations = new ArrayList<>();
        metricsMapper.forEach((word, value) -> {
                    if (StringUtils.containsIgnoreCase(line, word)) {
                        operations.add(value);
                    }
                    if(word.equals(Constants.METRIC_URL) && StringUtil.isUrlMatched(line)){
                        operations.add(metricsMapper.get(Constants.METRIC_URL));
                    }
                }
        );
        return operations;
    }


    @Override
    public List<Metric> create(CharSequence line) {
        return getMetricsList(line);
    }
}
