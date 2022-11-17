import com.ikhokha.commentanalize.service.impl.CommentAnalyzer;
import com.ikhokha.commentanalize.util.Constants;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.*;

import static com.ikhokha.commentanalize.util.ReportUtil.addReportResults;

public class Main {
    private static final Logger LOGGER = LoggerFactory.getLogger(Main.class);

    public static void main(String[] args) {

        Map<String, Integer> totalResults = new HashMap<>();

        File docPath = new File(Constants.FOLDER_PATH);
        File[] commentFiles = docPath.listFiles((d, n) -> n.endsWith(Constants.FILE_EXTENSION_TXT));
        Map<String, Integer> resultsMap = new HashMap<>();
        /**
         * init thread pool size - values of may vary depend on the CPU utilization and IO calls of the server
         */
        ExecutorService executor = Executors.newFixedThreadPool(Constants.THREAD_POOL_SIZE);

        List<CompletableFuture<Void>> futures = new ArrayList<>();
        for (File commentFile : commentFiles) {
            /**
             * with the supply async start processing files parallel way.
             */
            futures.add(CompletableFuture.runAsync(() -> {
                        LOGGER.info("Start processing.... : ");

                        try {
                            CommentAnalyzer commentAnalyzer = new CommentAnalyzer(commentFile);
                            commentAnalyzer.analyze(resultsMap);
                        } catch (Exception e) {
                            throw new CompletionException(e);
                        }

                    }
                    , executor));
        }
        try {
            CompletableFuture.allOf(futures.toArray(new CompletableFuture[0])).join();
        } catch (CompletionException e) {

            LOGGER.error("An exception occurred", e.getCause());
        }

        addReportResults(resultsMap, totalResults);
        LOGGER.info("RESULTS\n=======");
        totalResults.forEach((k, v) -> LOGGER.info(k + " : " + v));
        executor.shutdown();
    }
}
