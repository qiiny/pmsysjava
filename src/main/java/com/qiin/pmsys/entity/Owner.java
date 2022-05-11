package com.qiin.pmsys.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

import lombok.Data;

/**
 * owner
 * @author 
 */
@ApiModel(value="com.qiin.pmsys.entity.Owner")
@Data
public class Owner implements Serializable {
    /**
     * 业主编号
     */
    @ApiModelProperty(value="业主编号")
    private Integer ownerid;

    /**
     * 业主姓名
     */
    @ApiModelProperty(value="业主姓名")
    private String ownername;

    /**
     * 楼栋编号
     */
    @ApiModelProperty(value="楼栋编号")
    private Integer buildingid;

    private Building  building;
    /**
     * 门牌号
     */
    @ApiModelProperty(value="门牌号")
    private Integer houseid;

    private House houses;

    /**
     * 业主性别
     */
    @ApiModelProperty(value="业主性别")
    private Integer sex;

    /**
     * 业主电话
     */
    @ApiModelProperty(value="业主电话")
    private Long phone;

    /**
     * 业主邮箱
     */
    @ApiModelProperty(value="业主邮箱")
    private String email;

    /**
     * 入住时间
     */
    @ApiModelProperty(value="入住时间")
    private Date createtime;

    /**
     * 备注
     */
    @ApiModelProperty(value="备注")
    private String remarks;

    private static final long serialVersionUID = 1L;
}