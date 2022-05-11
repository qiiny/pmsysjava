package com.qiin.pmsys.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * fee_power
 * @author 
 */
@ApiModel(value="com.qiin.pmsys.entity.FeePower")
@Data
public class FeePower implements Serializable {
    /**
     * 电费主键
     */
    @ApiModelProperty(value="电费主键")
    private Integer powerid;

    /**
     * 用户id
     */
    @ApiModelProperty(value="用户id")
    private Integer ownerid;

    /**
     * 缴费年月
     */
    @ApiModelProperty(value="缴费年月")
    private String paymonth;

    /**
     * 缴费金额
     */
    @ApiModelProperty(value="缴费金额")
    private Double paymoney;

    /**
     * 电表度数
     */
    @ApiModelProperty(value="电表度数")
    private String powernum;

    /**
     * 是否已缴费
     */
    @ApiModelProperty(value="是否已缴费")
    private Integer ispay;

    /**
     * 缴费时间
     */
    @ApiModelProperty(value="缴费时间")
    private Date paytime;

    private Owner owner;

    private static final long serialVersionUID = 1L;
}