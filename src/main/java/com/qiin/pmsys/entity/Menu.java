package com.qiin.pmsys.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import java.util.List;

import lombok.Data;

/**
 * menu
 * @author 
 */
@ApiModel(value="com.qiin.pmsys.entity.Menu")
@Data
public class Menu implements Serializable {
    /**
     * 主键
     */
    @ApiModelProperty(value="主键")
    private Integer id;

    /**
     * 标题
     */
    @ApiModelProperty(value="标题")
    private String title;

    /**
     * 路径
     */
    @ApiModelProperty(value="路径")
    private String path;

    /**
     * 父id
     */
    @ApiModelProperty(value="父id")
    private Integer parentid;

    /**
     * 等级
     */
    @ApiModelProperty(value="等级")
    private Integer level;

    private List<Menu> list;

    private static final long serialVersionUID = 1L;
}