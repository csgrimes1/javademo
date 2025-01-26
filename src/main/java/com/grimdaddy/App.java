package com.grimdaddy;

import java.util.Arrays;

import com.grimdaddy.scraping.Scraper;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        final String argstr = Arrays.stream(args)
            .reduce("", (s1, s2) -> s1
                .concat(s1.length() <= 0 ? "" : ",")
                .concat(s2)
            );
        System.out.println( "Hello World: " + argstr);
        Arrays.stream(args)
            .forEach(arg -> Scraper.scrapePage(arg));
    }
}
