package com.ikhokha.commentanalize.util;

import org.apache.commons.lang3.StringUtils;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringUtil {

    public static final String URL_REGEX = "^(https?|ftp|file)://[-a-zA-Z0-9+&@#/%?=~_|!:,.;]*[-a-zA-Z0-9+&@#/%=~_|]";

    /**
     * this method breaks the line to parts and check if the url is contains
     * @param charSequence input comment line
     * @return
     */
    public static boolean isUrlMatched(CharSequence charSequence) {

        Pattern p = Pattern.compile(URL_REGEX);
        List<String> matchList = Arrays.asList(StringUtils.split(charSequence.toString(), " "));
        boolean isUrlMatched = matchList.stream().anyMatch(s -> p.matcher(s).find());
        return isUrlMatched;
    }
}
