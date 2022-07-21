package com.example.zadanie.pars;

import com.example.zadanie.services.NewsServices;
import com.rometools.rome.feed.synd.SyndEntry;
import com.rometools.rome.feed.synd.SyndFeed;
import com.rometools.rome.io.FeedException;
import com.rometools.rome.io.SyndFeedInput;
import com.rometools.rome.io.XmlReader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;

import java.io.IOException;
import java.net.URL;


public class parsText {

    @Autowired
    NewsServices newsServices;

    @Scheduled(fixedDelay = 10000)
    public void parsNewNews() throws IOException, FeedException {


        try {
            String url = "http://localhost:8087/rss";

            try (XmlReader reader = new XmlReader(new URL(url))) {
                SyndFeed feed = new SyndFeedInput().build(reader);
                System.out.println(feed.getTitle());
                System.out.println("***********************************");
                for (SyndEntry entry : feed.getEntries()) {
                    System.out.println(entry);
                    System.out.println("***********************************");
                }
                System.out.println("Done");
            }
        }  catch (Exception e) {
            e.printStackTrace();
        }

       /* SyndFeedInput input = new SyndFeedInput();
        int pageNumber = 1;

        try{
            do {
                URL feedSource = new URL("https://people.onliner.by/feed" + pageNumber);
                SyndFeed feed = input.build(new XmlReader(feedSource));
                pageNumber++;
            }
            while (pageNumber <= 27);
        } catch (IOException ex){
            System.out.println("IO exception occurred due to: "+ ex);
            //Handle this exception accordingly
        } catch (FeedException ex) {
            System.out.println("Feed exception occurred due to: "+ ex);*/
            //Handle this exception accordingly
        }

       /* String url = "https://people.onliner.by/feed";*/
       /* SyndFeedInput input = new SyndFeedInput();
        URL feedSource = new URL("https://people.onliner.by/feed" );
        SyndFeed feed = input.build(new XmlReader(feedSource));
*/


    }

