package com.qiin.pmsys.service;

import com.qiin.pmsys.entity.FeePower;

import java.util.List;

/**
 * (FeePower)表服务接口
 *
 * @author qiin
 * @since 2022-02-23 01:31:05
 */
public interface FeePowerService {

    /**
     * 通过ID查询单条数据
     *
     * @param powerid 主键
     * @return 实例对象
     */
    FeePower queryById(Integer powerid);



    /**
     * 新增数据
     *
     * @param feePower 实例对象
     * @return 实例对象
     */
    int insert(FeePower feePower);

    /**
     * 修改数据
     *
     * @param feePower 实例对象
     * @return 实例对象
     */
    int update(FeePower feePower);

    /**
     * 通过主键删除数据
     *
     * @param powerid 主键
     * @return 是否成功
     */
    boolean deleteById(Integer powerid);

    List<FeePower> getAllFeeWater(int ownerid, String payMonth, int pageNum, int pageSize);

    int getFeeCount(int ownerid);
}
