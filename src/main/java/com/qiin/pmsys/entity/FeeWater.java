package com.qiin.pmsys.entity;



import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import java.util.Date;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;


/**
 * fee_water
 * @author 
 */
@ApiModel(value="com.qiin.pmsys.entity.FeeWater")
@Data
public class FeeWater implements Serializable {
    /**
     * 水费id
     */
    @ApiModelProperty(value="水费id")
    private Integer waterid;

    /**
     * 业主id
     */
    @ApiModelProperty(value="业主id")
    private Integer ownerid;

    /**
     * 缴费年月
     */
    @ApiModelProperty(value="缴费年月")
    @JsonFormat(pattern = "yyyy-MM-dd",timezone = "GMT+08")
    @DateTimeFormat( pattern = "yyyy-MM-dd HH:mm" )
    private Date paymonth;

    /**
     * 缴费金额
     */
    @ApiModelProperty(value="缴费金额")
    private Double paymoney;

    /**
     * 水表数
     */
    @ApiModelProperty(value="水表数")
    private String waternum;

    /**
     * 是否缴费
     */
    @ApiModelProperty(value="是否缴费")
    private Integer ispay;
    private Owner owner;
    private House house;
    /**
     * 缴费时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd",timezone = "GMT+08")
    @ApiModelProperty(value="缴费时间")
    private Date paytime;
    private String remarks;
    private static final long serialVersionUID = 1L;
}