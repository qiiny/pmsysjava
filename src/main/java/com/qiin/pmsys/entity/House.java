package com.qiin.pmsys.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import lombok.Data;

/**
 * house
 * @author 
 */
@ApiModel(value="com.qiin.pmsys.entity.House")
@Data
public class House implements Serializable {
    /**
     * 房屋id
     */
    @ApiModelProperty(value="房屋id")
    private Integer houseid;

    /**
     * 楼栋id
     */
    @ApiModelProperty(value="楼栋id")
    private Integer buildingid;

    /**
     * 单位名称
     */
    @ApiModelProperty(value="单位名称")
    private String housename;

    /**
     * 是否有人入住
     */
    @ApiModelProperty(value="是否有人入住")
    private Integer ownerid;

    private Owner owner;

    private Building building;

    private static final long serialVersionUID = 1L;
}