package com.qiin.pmsys.service;

import com.qiin.pmsys.entity.FeeWater;
import io.swagger.models.auth.In;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import java.util.List;

/**
 * (FeeWater)表服务接口
 *
 * @author qiin
 * @since 2022-02-23 01:31:05
 */
public interface FeeWaterService {

    /**
     * 通过ID查询单条数据
     *
     * @param waterid 主键
     * @return 实例对象
     */
    FeeWater queryById(Integer waterid);

    /**
     * 分页查询
     *
     * @param feeWater 筛选条件
     * @param pageRequest      分页对象
     * @return 查询结果
     */
    Page<FeeWater> queryByPage(FeeWater feeWater, PageRequest pageRequest);

    /**
     * 新增数据
     *
     * @param feeWater 实例对象
     * @return 实例对象
     */
    int insert(FeeWater feeWater);

    /**
     * 修改数据
     *
     * @param feeWater 实例对象
     * @return 实例对象
     */
    int update(FeeWater feeWater);

    /**
     * 通过主键删除数据
     *
     * @param waterid 主键
     * @return 是否成功
     */
    boolean deleteById(Integer waterid);

    List<FeeWater> getAllFeeWater(int ownerId,String payMonth, int pageNum, int pageSize);

    int getFeeCount(int ownerId);
}
