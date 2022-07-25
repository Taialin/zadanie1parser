package com.example.zadanie.Controllers;

import com.example.zadanie.Com.RssFeedView;
import com.example.zadanie.dob.News;
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

    @GetMapping("/value")
    public List<News> getAllNews() {
        return newsServices.getAllNews();
    }


    @GetMapping("/save")
    @CrossOrigin(origins = "*")
    public String all() throws Exception {
        List<News> list = new RssFeedView("https://people.onliner.by/feed").getAll();
        for (News item : list) {
            newsServices.save(item);
        }
        return "done";
    }

    @RequestMapping(value = "task", method = RequestMethod.GET)
    public String taskList(Map<String, Object> model) {
        model.put("task", newsServices.getAllNews());
        return "/tasks/list";
    }

    @RequestMapping("/v")
    @ResponseBody
    public List<News> getFeed() throws Exception {
        return new RssFeedView("https://people.onliner.by/feed").getAll();
    }
}
