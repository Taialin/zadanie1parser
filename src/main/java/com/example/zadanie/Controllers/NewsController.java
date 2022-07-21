package com.example.zadanie.Controllers;

import com.example.zadanie.Com.RssFeedView;
import com.example.zadanie.dob.News;
import com.example.zadanie.services.NewsServices;
import com.rometools.rome.feed.synd.*;
import com.rometools.rome.io.FeedException;
import com.rometools.rome.io.SyndFeedInput;
import com.rometools.rome.io.SyndFeedOutput;
import com.rometools.rome.io.XmlReader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.persistence.Access;
import javax.swing.text.View;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@RestController
public class NewsController {

    @Autowired
    NewsServices newsServices;




    @GetMapping("/value")
    public List<News> getAllNews(){
        return newsServices.getAllNews();
    }

    @GetMapping("/save")
    @CrossOrigin(origins = "*")
    public String all() throws Exception{
       List<News> list = new RssFeedView("https://people.onliner.by/feed").getAll();
        for (News item: list) {
            newsServices.save(item);
        }
        return "done";
    }

    @RequestMapping("/v")
    @ResponseBody

    public List<News>  getFeed () throws Exception {
        return  new RssFeedView("https://people.onliner.by/feed").getAll();
    }
}
