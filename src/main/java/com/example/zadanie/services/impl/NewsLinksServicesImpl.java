package com.example.zadanie.services.impl;

import com.example.zadanie.dob.NewsLinks;
import com.example.zadanie.repository.NewsLinksRepository;
import com.example.zadanie.services.NewsLinksServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NewsLinksServicesImpl implements NewsLinksServices {

    @Autowired
    NewsLinksRepository newsLinksRepository;

    @Override
    public NewsLinks getLink(Long Id) {
        return newsLinksRepository.getOne(2L);
    }




}
