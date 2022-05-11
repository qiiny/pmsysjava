package com.qiin.pmsys.dao;

import com.qiin.pmsys.entity.FeeProperty;
import com.qiin.pmsys.entity.FeeWater;
import org.apache.ibatis.annotations.Param;
import org.springframework.data.domain.Pageable;
import java.util.List;

/**
 * (FeeProperty)表数据库访问层
 *
 * @author Qin
 * @since 2022-03-09 17:11:45
 */
public interface FeePropertyDao {

    /**
     * 通过ID查询单条数据
     *
     * @param propertyid 主键
     * @return 实例对象
     */
    FeeProperty queryById(Integer propertyid);


    List<FeeProperty> queryAllByLimit(int ownerId, String payMonth, int pageStar, int pageSize);

    /**
     * 统计总行数
     *
     * @param feeProperty 查询条件
     * @return 总行数
     */
    int count(FeeProperty feeProperty);

    /**
     * 新增数据
     *
     * @param feeProperty 实例对象
     * @return 影响行数
     */
    int insert(FeeProperty feeProperty);

    /**
     * 批量新增数据（MyBatis原生foreach方法）
     *
     * @param entities List<FeeProperty> 实例对象列表
     * @return 影响行数
     */
    int insertBatch(@Param("entities") List<FeeProperty> entities);

    /**
     * 批量新增或按主键更新数据（MyBatis原生foreach方法）
     *
     * @param entities List<FeeProperty> 实例对象列表
     * @return 影响行数
     * @throws org.springframework.jdbc.BadSqlGrammarException 入参是空List的时候会抛SQL语句错误的异常，请自行校验入参
     */
    int insertOrUpdateBatch(@Param("entities") List<FeeProperty> entities);

    /**
     * 修改数据
     *
     * @param feeProperty 实例对象
     * @return 影响行数
     */
    int update(FeeProperty feeProperty);

    /**
     * 通过主键删除数据
     *
     * @param propertyid 主键
     * @return 影响行数
     */
    int deleteById(Integer propertyid);

}

