package com.qiin.pmsys.entity;

import java.io.Serializable;

/**
 * (Test)实体类
 *
 * @author qiin
 * @since 2022-03-19 14:47:32
 */
public class Test implements Serializable {
    private static final long serialVersionUID = 482662558791239171L;
    
    private Integer id;
    
    private String context;
    
    private String image;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getContext() {
        return context;
    }

    public void setContext(String context) {
        this.context = context;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

}

