package com.qiin.pmsys.entity;

import java.util.Date;
import java.io.Serializable;

/**
 * (Notice)实体类
 *
 * @author qiin
 * @since 2022-03-21 16:04:29
 */
public class Notice implements Serializable {
    private static final long serialVersionUID = -37921007840309366L;
    /**
     * 发布时间
     */
    private Date noticetime;
    /**
     * 公告内容
     */
    private String content;
    /**
     * 公告状态
     */
    private Integer status;
    /**
     * 公告编号
     */
    private Integer noticeid;
    /**
     * 公告标题
     */
    private String noticetitle;


    public Date getNoticetime() {
        return noticetime;
    }

    public void setNoticetime(Date noticetime) {
        this.noticetime = noticetime;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer getNoticeid() {
        return noticeid;
    }

    public void setNoticeid(Integer noticeid) {
        this.noticeid = noticeid;
    }

    public String getNoticetitle() {
        return noticetitle;
    }

    public void setNoticetitle(String noticetitle) {
        this.noticetitle = noticetitle;
    }

}

