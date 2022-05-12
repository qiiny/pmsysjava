package com.qiin.pmsys.entity;

import io.swagger.models.auth.In;
import lombok.Data;

import java.util.Date;

/**
 * @author: Qin
 * @Date: 2022/3/12.
 */
@Data
public class QueryInfo {
    private Integer ownerid;
    private String PayMonth;
    private Integer pageNum;
    private Integer pageSize;
    private boolean isPayMonth;
    private String createTime;
    private Integer repairtype;
    private String complaints;
}
