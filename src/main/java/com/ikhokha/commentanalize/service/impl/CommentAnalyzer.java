package com.ikhokha.commentanalize.service.impl;

import com.ikhokha.commentanalize.contact.CommentAbstractFactory;
import com.ikhokha.commentanalize.factory.CommentFactoryProvider;
import com.ikhokha.commentanalize.metric.Metric;
import com.ikhokha.commentanalize.service.ICommentAnalyzer;
import com.ikhokha.commentanalize.util.Action;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.*;
import java.util.*;

public class CommentAnalyzer implements ICommentAnalyzer {

    private static final Logger LOGGER = LoggerFactory.getLogger(CommentAnalyzer.class);
    private final File file;

    public CommentAnalyzer(File file) {
        this.file = file;
    }

    @Override
    public Map<String, Integer> analyze(Map<String, Integer> resultsMap) {

        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {

            String line = null;
            while ((line = reader.readLine()) != null) {
                List<Action> actions = Arrays.asList(Action.values());
                String finalLine = line;
                actions.forEach(s -> {
                            CommentAbstractFactory factory = CommentFactoryProvider.getFactory(s.name());
                            List<Metric> operationList = (List<Metric>) factory.create(finalLine);
                            if (!operationList.isEmpty()) {
                                operationList.forEach(operation ->
                                        Metric.incOccurrence(resultsMap, operation.getMetricName())
                                );
                            }
                        }
                );

            }

        } catch (FileNotFoundException e) {
            LOGGER.error("File not found: " + file.getAbsolutePath(),e);
        } catch (IOException e) {
            LOGGER.error("IO Error processing file: " + file.getAbsolutePath(),e);
        }

        return resultsMap;

    }

}
