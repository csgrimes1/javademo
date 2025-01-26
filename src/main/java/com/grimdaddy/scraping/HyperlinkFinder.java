package com.grimdaddy.scraping;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Stream;

public class HyperlinkFinder {
    private static final Pattern _pattern = Pattern.compile(
        "<a\\s+[^>]*\\s+href\\s*=\\s*[\"']([^\"']+)[\"'][^>]*>", 
        Pattern.CASE_INSENSITIVE | Pattern.MULTILINE);
    
    private static Stream<String> getGroups(Matcher matt) {
        return Stream.iterate(0, i -> i + 1)
              .limit(matt.groupCount())
              .map(i -> matt.group(i));
    }

    public static String[] findLinks(String body) {
        final Matcher matt = _pattern.matcher(body);
        if (!matt.find()) {
            System.out.println("Nope.");
            return new String[0];
        }
        matt.results()
            .forEach(mr -> System.out.println(mr.group(1) +  mr.groupCount()));
        return getGroups(matt)
            .toList()
            .toArray(new String[0]);
    }
}
