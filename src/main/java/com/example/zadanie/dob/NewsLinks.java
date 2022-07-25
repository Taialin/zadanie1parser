package com.example.zadanie.dob;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

@Entity
@Table(name = "link_news")
public class NewsLinks {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private long id;
    private String linkRSS;

    public NewsLinks(){}

    public NewsLinks(String linkRSS){
        this.linkRSS = linkRSS;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getLinkRSS() {
        return linkRSS;
    }

    public void setLinkRSS(String linkRSS) {
        this.linkRSS = linkRSS;
    }
}
