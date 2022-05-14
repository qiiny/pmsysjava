package com.qiin.pmsys.entity;

import lombok.Data;

import java.util.Date;
import java.io.Serializable;
import java.util.List;

/**
 * 评论(Comment)实体类
 *
 * @author makejava
 * @since 2022-05-15 00:51:36
 */
@Data
public class Comment implements Serializable {
    private static final long serialVersionUID = 683510940854638280L;
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
     * 评论创建时间
     */
    private Date time;
    /**
     * 父级评论id

     */
    private String toId;
    /**
     * 回复人名称

     */
    private String to;
    /**
     * 评论数
     */
    private Integer commentNum;
    /**
     * 头像
     */
    private String avater;
    /**
     * 评论框显示
     */
    private Integer inputShow;
    /**
     * 点赞数
     */
    private Integer like;

    private List<Comment> reply;


}

