package com.blog.entity;

import org.hibernate.annotations.GeneratorType;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;

/**
 * Created by LamanLu on 2016/11/8.
 */
@Entity
@Table(name = "category")
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    private String name;

    private int sort;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "category", cascade = CascadeType.REMOVE, targetEntity = Article.class)
    private Collection<Article> articles = new ArrayList<Article>();

    public Category() {
    }

    public Category(String name, int sort) {
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
}
