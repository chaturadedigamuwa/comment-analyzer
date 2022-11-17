package com.ikhokha.commentanalize.util;

public class Constants {

    /**
     * Names of the totals to show in the results map
     */
    public static final String METRIC_MOVER_MENTIONS = "MOVER_MENTIONS";
    public static final String METRIC_SHAKER_MENTIONS = "SHAKER_MENTIONS";
    public static final String METRIC_LENGTH_SHORTER_THAN_15 = "SHORTER_THAN_15";
    public static final String METRIC_QUESTION_MENTIONS = "QUESTION_MARK_MENTIONS";
    public static final String METRIC_URL_MENTIONS = "SPAM";


    /**
     * metric names to map with concrete classes in the factory classes
     */
    public static final String METRIC_MOVER = "mover";
    public static final String METRIC_SHAKER = "shaker";
    public static final String METRIC_QUESTION = "?";
    public static final String METRIC_URL = "uri";


    public static final int LENGTH_15 = 15;

    public static final String FOLDER_PATH = "docs";
    public static final String FILE_EXTENSION_TXT = ".txt";

    /**
     * init thread pool size - values of may vary depend on the CPU utilization and IO calls of the server
     */
    public static final int THREAD_POOL_SIZE = 4;





}
