package com.qiin.pmsys.entity;

import java.io.Serializable;
import lombok.Data;

/**
 * user
 * @author 
 */
@Data
public class User implements Serializable {
    /**
     * 用户主键
     */
    private Integer userid;

    /**
     * 用户名
     */
    private String username;

    /**
     * 密码
     */
    private String password;

    /**
     * 业主id
     */
    private Integer ownerid;

    private Owner owner;
    private House house;
    /**
     * 用户头像
     */
    private String avatar;
    private int status;
    private static final long serialVersionUID = 1L;
}