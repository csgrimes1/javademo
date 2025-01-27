package com.grimdaddy.scraping;

import org.junit.Assert;
import org.junit.Test;

public class HyperlinkFinderTest {
    public HyperlinkFinderTest() {
    }

    @Test
    public void scrapePageTest1() {
        final String html = """
                <body>
                    <a  href="https://www.github.com" target="foo">click<a/>
                    <a href="https://www.google.com" onclick="window.alert('?')">click<a/>
                    <a href="https://www.yahoo.com">click</a>
                    <a href="https://www.facebook.com/officialstackoverflow/" class="-link js-gps-track" data-gps-track="footer.click({ location: 1, link: 31 })">fb</a>
                </body>
                """;
        final String[] links = HyperlinkFinder.findLinks(html);
        final String[] expected = {
                "https://www.github.com",
                "https://www.google.com",
                "https://www.yahoo.com",
                "https://www.facebook.com/officialstackoverflow/",
        };
        Assert.assertArrayEquals(links, expected);
    }
}
