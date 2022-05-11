package com.qiin.pmsys.entity;

import java.util.Date;
import java.io.Serializable;

/**
 * 评论(Comment)实体类
 *
 * @author qiin
 * @since 2022-03-28 00:51:29
 */
public class Comment implements Serializable {
    private static final long serialVersionUID = 308993479956886226L;
    /**
     * 主键id
     */
    private Integer id;
    /**
     * 用户昵称
     */
    private String name;
    /**
     * 评论内容
     */
    private String content;
    /**
     * 父级评论id
     */
    private String parentId;
    /**
     * 评论创建时间
     */
    private Date time;
    /**
     * 回复人名称
     */
    private String fromName;
    /**
     * 创建时间
     */
    private Date gmtCreate;


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

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getParentId() {
        return parentId;
    }

    public void setParentId(String parentId) {
        this.parentId = parentId;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    public String getFromName() {
        return fromName;
    }

    public void setFromName(String fromName) {
        this.fromName = fromName;
    }

    public Date getGmtCreate() {
        return gmtCreate;
    }

    public void setGmtCreate(Date gmtCreate) {
        this.gmtCreate = gmtCreate;
    }

}

