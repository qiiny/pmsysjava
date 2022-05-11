package com.qiin.pmsys.dao;

import com.qiin.pmsys.entity.FeeWater;
import org.apache.ibatis.annotations.Param;
import org.springframework.data.domain.Pageable;

import java.util.Date;
import java.util.List;

/**
 * (FeeWater)表数据库访问层
 *
 * @author Qin
 * @since 2022-03-09 17:11:45
 */
public interface FeeWaterDao {

    /**
     * 通过ID查询单条数据
     *
     * @param waterid 主键
     * @return 实例对象
     */
    FeeWater queryById(Integer waterid);

    /**
     * 分页查询
     * @param payMonth
     * @param pageStar
     * @param pageSize
     * @return
     */
    List<FeeWater> queryAllByLimit(int ownerId,String payMonth,int pageStar,int pageSize);

    /**
     * 统计总行数
     *
     * @param feeWater 查询条件
     * @return 总行数
     */
    int count(FeeWater feeWater);

    /**
     * 新增数据
     *
     * @param feeWater 实例对象
     * @return 影响行数
     */
    int insert(FeeWater feeWater);

    /**
     * 批量新增数据（MyBatis原生foreach方法）
     *
     * @param entities List<FeeWater> 实例对象列表
     * @return 影响行数
     */
    int insertBatch(@Param("entities") List<FeeWater> entities);

    /**
     * 批量新增或按主键更新数据（MyBatis原生foreach方法）
     *
     * @param entities List<FeeWater> 实例对象列表
     * @return 影响行数
     * @throws org.springframework.jdbc.BadSqlGrammarException 入参是空List的时候会抛SQL语句错误的异常，请自行校验入参
     */
    int insertOrUpdateBatch(@Param("entities") List<FeeWater> entities);

    /**
     * 修改数据
     *
     * @param feeWater 实例对象
     * @return 影响行数
     */
    int update(FeeWater feeWater);

    /**
     * 通过主键删除数据
     *
     * @param waterid 主键
     * @return 影响行数
     */
    int deleteById(Integer waterid);

}

