package com.qiin.pmsys.entity;

import lombok.Data;

import java.io.Serializable;

/**
 * (Complaint)实体类
 *
 * @author qiin
 * @since 2022-03-25 14:46:58
 */
@Data
public class Complaint implements Serializable {
    private static final long serialVersionUID = -66739083659024558L;
    /**
     * 投诉主键
     */
    private Integer complaintid;

    private Integer ownerid;
    /**
     * 投诉内容
     */
    private String complaints;
    /**
     * 回复
     */
    private String reply;
    /**
     * 撤销投诉
     */
    private Integer revoke;

    private Owner owner;

}

