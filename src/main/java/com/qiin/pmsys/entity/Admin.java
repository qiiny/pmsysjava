package com.qiin.pmsys.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import lombok.Data;

/**
 * admin
 * @author 
 */
@ApiModel(value="com.qiin.pmsys.entity.Admin")
@Data
public class Admin implements Serializable {
    /**
     * 管理员id
     */
    @ApiModelProperty(value="管理员id")
    private Integer adminid;

    /**
     * 管理员用户名
     */
    @ApiModelProperty(value="管理员用户名")
    private String username;

    /**
     * 管理员密码
     */
    @ApiModelProperty(value="管理员密码")
    private String password;

    private static final long serialVersionUID = 1L;
}