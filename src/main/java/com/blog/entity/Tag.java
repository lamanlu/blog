package com.blog.entity;

import jdk.nashorn.internal.objects.annotations.Getter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by LamanLu on 2016/11/8.
 */
@Entity
@Table(name = "tag")
public class Tag {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;

    private int sort;

    @ManyToMany(fetch = FetchType.LAZY, mappedBy = "tags",cascade = CascadeType.ALL)
    private Set<Article> articles = new HashSet<Article>();

    public Tag() {
    }

    public Tag(String name) {
        this.name = name;
    }

    public Tag(String name, int sort) {
        this.name = name;
        this.sort = sort;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getSort() {
        return sort;
    }

    public void setSort(int sort) {
        this.sort = sort;
    }

    public Set<Article> getArticles() {
        return articles;
    }

    public void setArticles(Set<Article> articles) {
        this.articles = articles;
    }
}
