package com.example.zadanie.Com;


import com.example.zadanie.dob.News;
import com.example.zadanie.services.NewsLinksServices;
import com.rometools.rome.feed.synd.SyndCategory;
import com.rometools.rome.feed.synd.SyndEntry;
import com.rometools.rome.feed.synd.SyndFeed;
import com.rometools.rome.io.FeedException;
import com.rometools.rome.io.SyndFeedInput;
import com.rometools.rome.io.XmlReader;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class RssFeedView  {


    private String url;

    public RssFeedView(String url){
        this.url = url;
    }

    public List<News> getAll() throws IOException, FeedException {

        URL feedSource = new URL(url);
        SyndFeedInput input = new SyndFeedInput();
        SyndFeed feed = input.build(new XmlReader(feedSource));

        List<News> entries = new ArrayList<>();

        for (SyndEntry entry: feed.getEntries()) {
            List<String> categories = new ArrayList<>();
            for ( SyndCategory category: entry.getCategories()) {
                categories.add(category.getName());
            }
            entries.add(
                    new News(
                            entry.getTitle(),
                            entry.getLink(),
                            entry.getPublishedDate().toString(),
                            entry.getAuthor().toString(),
                            String.join(", ", categories),
                            entry.getUri(),
                            entry.getDescription().getValue()
                    )
            );
        }

        return entries;
    }



}
