package com.qiin.pmsys.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * fee_property
 * @author 
 */
@ApiModel(value="com.qiin.pmsys.entity.FeeProperty")
@Data
public class FeeProperty implements Serializable {
    /**
     * 物业费id
     */
    @ApiModelProperty(value="物业费id")
    private Integer propertyid;

    /**
     * 业主id
     */
    @ApiModelProperty(value="业主id")
    private Integer ownerid;

    /**
     * 缴费月份
     */
    @ApiModelProperty(value="缴费月份")
    private String paymonth;

    /**
     * 物业费金额
     */
    @ApiModelProperty(value="物业费金额")
    private Double paymoney;

    /**
     * 是否缴费
     */
    @ApiModelProperty(value="是否缴费")
    private Integer ispay;

    /**
     * 缴费时间
     */
    @ApiModelProperty(value="缴费时间")
    private Date paytime;

    private Owner owner;
    private static final long serialVersionUID = 1L;
}