package com.grimdaddy.scraping;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class HyperlinkFinder {
    // Had chatgpt generate the pattern and needed
    // to troubleshoot it.
    private static final Pattern _pattern = Pattern.compile(
        "<a\\s+[^>]*\\s*href\\s*=\\s*[\"']([^\"']+)[\"'][^>]*>", 
        Pattern.CASE_INSENSITIVE | Pattern.MULTILINE
    );

    public static String[] findLinks(String body) {
        final Matcher matt = _pattern.matcher(body);
        // System.out.println(body);
        // if (!matt.find()) {
        //     System.out.println( "\nNope.");
        //     return new String[0];
        // }
        // matt.results()
        //     .forEach(mr -> System.out.println(mr.group(1) +  mr.groupCount()));
        return matt.results()
            .map(mres -> mres.group(1))
            .toList()
            .toArray(new String[0]);
    }
}
