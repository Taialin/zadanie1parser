package com.example.zadanie.services;

import com.example.zadanie.dob.NewsLinks;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface NewsLinksServices {


    NewsLinks getLink(Long Id);
}
