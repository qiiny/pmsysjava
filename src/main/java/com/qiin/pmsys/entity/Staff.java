package com.qiin.pmsys.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import lombok.Data;

/**
 * staff
 * @author 
 */
@ApiModel(value="com.qiin.pmsys.entity.Staff")
@Data
public class Staff implements Serializable {
    /**
     * 员工id
     */
    @ApiModelProperty(value="员工id")
    private Integer staffid;

    /**
     * 员工姓名
     */
    @ApiModelProperty(value="员工姓名")
    private String staffname;

    /**
     * 员工手机
     */
    @ApiModelProperty(value="员工手机")
    private Long staffphone;

    /**
     * 员工岗位
     */
    @ApiModelProperty(value="员工岗位")
    private String staffpost;

    private static final long serialVersionUID = 1L;
}