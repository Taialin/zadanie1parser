package com.example.zadanie.services;

import com.example.zadanie.dob.News;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;
import java.util.Map;

@Service
public interface NewsServices {
     News save(News news);
     boolean isExist(String newsTitle);
     List<News> getAllNews();

}
