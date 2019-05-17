package com.techybazaar.wordpressapp.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class CategoryName {

    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("count")
    @Expose
    private Integer count;
    @SerializedName("name")
    @Expose
    private String name;

    public CategoryName(Integer id, Integer count, String name) {
        this.id = id;
        this.count = count;
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}