package com.example.zadanie.repository;

import com.example.zadanie.dob.NewsLinks;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NewsLinksRepository extends JpaRepository<NewsLinks, Long> {
}
