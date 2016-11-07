package com.blog.entity;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

/**
 * Created by LamanLu on 2016/11/7.
 */
@Entity
@Table(name = "type")
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @NotNull
    private String name;

    @NotNull
    private Integer sort;

    public Category() {
    }

    public Category(String name, Integer sort) {
        this.name = name;
        this.sort = sort;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getSort() {
        return sort;
    }

    public void setSort(Integer sort) {
        this.sort = sort;
    }
}
