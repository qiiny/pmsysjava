package com.qiin.pmsys.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import lombok.Data;

/**
 * building
 * @author 
 */
@ApiModel(value="com.qiin.pmsys.entity.Building")
@Data
public class Building implements Serializable {
    /**
     * 楼栋主键
     */
    @ApiModelProperty(value="楼栋主键")
    private Integer buildingid;

    /**
     * 楼栋名称
     */
    @ApiModelProperty(value="楼栋名称")
    private String buildingname;

    private static final long serialVersionUID = 1L;
}