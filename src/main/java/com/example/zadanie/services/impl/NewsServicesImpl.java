package com.example.zadanie.services.impl;

import com.example.zadanie.dob.News;
import com.example.zadanie.repository.NewsRepository;
import com.example.zadanie.services.NewsServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;
import java.util.Map;

@Service
public class NewsServicesImpl implements NewsServices {

    @Autowired
    NewsRepository repository;

    @Override
    public News save(News news) {
        return  repository.save(news);

    }

    @Override
    public boolean isExist(String newsTitle) {
        List<News> news = repository.findAll();
        for(News n: news){
            if(n.getTitle().equals(newsTitle)){
                return true;
            }
        }
        return false;
    }

    @Override
    public List<News> getAllNews() {
        return repository.findAll();

    }


}
