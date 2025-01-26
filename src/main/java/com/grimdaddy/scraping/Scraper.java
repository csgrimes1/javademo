package com.grimdaddy.scraping;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpClient.Redirect;
import java.net.http.HttpClient.Version;
import java.net.http.HttpResponse.BodyHandlers;
import java.util.Arrays;

public class Scraper {
    private static final HttpClient _client = HttpClient.newBuilder()
        .version(Version.HTTP_1_1)
        .followRedirects(Redirect.NORMAL)
        .build();

    public static long scrapePage(String url) {
        try {
            final HttpRequest r = HttpRequest.newBuilder()
                .uri(new URI(url))
                .build();
            final HttpResponse res = _client.send(r, BodyHandlers.ofString());
            if (res.statusCode() < 400) {
                final String[] links = HyperlinkFinder.findLinks(res.body().toString());
                Arrays.stream(links)
                    .forEach(link -> System.out.println(link));
            }
            return 0;
        }
        catch(Exception e) {
            System.err.println(e.getMessage());
            return 0;
        }
    }
}
