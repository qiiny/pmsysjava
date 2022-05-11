package com.qiin.pmsys.service;

import com.qiin.pmsys.entity.FeeProperty;

import java.util.List;

/**
 * (FeeProperty)表服务接口
 *
 * @author qiin
 * @since 2022-02-23 01:31:05
 */
public interface FeePropertyService {

    /**
     * 通过ID查询单条数据
     *
     * @param propertyid 主键
     * @return 实例对象
     */
    FeeProperty queryById(Integer propertyid);

    /**
     * 分页查询
     *
     * @param feeProperty 筛选条件
     * @param pageRequest      分页对象
     * @return 查询结果
     */


    /**
     * 新增数据
     *
     * @param feeProperty 实例对象
     * @return 实例对象
     */
    int insert(FeeProperty feeProperty);

    /**
     * 修改数据
     *
     * @param feeProperty 实例对象
     * @return 实例对象
     */
    int update(FeeProperty feeProperty);

    /**
     * 通过主键删除数据
     *
     * @param propertyid 主键
     * @return 是否成功
     */
    boolean deleteById(Integer propertyid);

    List<FeeProperty> getAllFeeWater(int ownerid, String payMonth, int pageNum, int pageSize);

    int getFeeCount(int ownerid);
}
