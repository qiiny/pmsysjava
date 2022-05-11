package com.qiin.pmsys.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * repair
 * @author 
 */
@ApiModel(value="com.qiin.pmsys.entity.Repair")
@Data
public class Repair implements Serializable {
    /**
     * 维修编号
     */
    @ApiModelProperty(value="维修编号")
    private Integer repairid;

    /**
     * 维修类型
     */
    @ApiModelProperty(value="维修类型")
    private Integer repairtype;

    /**
     * 报修人
     */
    @ApiModelProperty(value="报修人")
    private Integer ownerid;

    /**
     * 维修地点
     */
    @ApiModelProperty(value="维修地点")
    private String place;

    /**
     * 报修时间
     */
    @ApiModelProperty(value="报修时间")
    private Date createtime;

    /**
     * 维修员工
     */
    @ApiModelProperty(value="维修员工")
    private Integer staff;

    /**
     * 维修时间
     */
    @ApiModelProperty(value="维修时间")
    private Date repairtime;

    /**
     * 是否已维修
     */
    @ApiModelProperty(value="是否已维修")
    private Integer isrepair;

    /**
     * 备注
     */
    @ApiModelProperty(value="备注")
    private String remarks;
    private Owner owner;

    private static final long serialVersionUID = 1L;
}