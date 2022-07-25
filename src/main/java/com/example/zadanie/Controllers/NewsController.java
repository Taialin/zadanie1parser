package com.example.zadanie.Controllers;

import com.example.zadanie.Com.RssFeedView;
import com.example.zadanie.dob.News;
import com.example.zadanie.services.NewsLinksServices;
import com.example.zadanie.services.NewsServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(value = "/news")
public class NewsController {

    @Autowired
    NewsServices newsServices;
    @Autowired
    NewsLinksServices newsLinksServices;

    @GetMapping("/value")
    public List<News> getAllNews() {
        return newsServices.getAllNews();
    }

    @RequestMapping("/news.html")
    public String loginAfter() {
        return "news.html";
    }

    @GetMapping("/save")
    @CrossOrigin(origins = "*")
    public String all() throws Exception {
        List<News> list = new RssFeedView(newsLinksServices.getLink(2L).getLinkRSS()).getAll();
        for (News item : list) {
            newsServices.save(item);
        }
        return "done";
    }


    @RequestMapping("/v")
    @ResponseBody
    public List<News> getFeed() throws Exception {
        return new RssFeedView("https://s13.ru/rss").getAll();
    }
}
