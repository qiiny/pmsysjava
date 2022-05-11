package com.qiin.pmsys.dao;

import com.qiin.pmsys.entity.FeePower;
import org.apache.ibatis.annotations.Param;
import org.springframework.data.domain.Pageable;
import java.util.List;

/**
 * (FeePower)表数据库访问层
 *
 * @author Qin
 * @since 2022-03-09 17:11:45
 */
public interface FeePowerDao {

    /**
     * 通过ID查询单条数据
     *
     * @param powerid 主键
     * @return 实例对象
     */
    FeePower queryById(Integer powerid);

    /**
     * 查询指定行数据
     *
     */
    List<FeePower> queryAllByLimit(int ownerId,String payMonth,int pageStar,int pageSize);

    /**
     * 统计总行数
     *
     * @param feePower 查询条件
     * @return 总行数
     */
    int count(FeePower feePower);

    /**
     * 新增数据
     *
     * @param feePower 实例对象
     * @return 影响行数
     */
    int insert(FeePower feePower);

    /**
     * 批量新增数据（MyBatis原生foreach方法）
     *
     * @param entities List<FeePower> 实例对象列表
     * @return 影响行数
     */
    int insertBatch(@Param("entities") List<FeePower> entities);

    /**
     * 批量新增或按主键更新数据（MyBatis原生foreach方法）
     *
     * @param entities List<FeePower> 实例对象列表
     * @return 影响行数
     * @throws org.springframework.jdbc.BadSqlGrammarException 入参是空List的时候会抛SQL语句错误的异常，请自行校验入参
     */
    int insertOrUpdateBatch(@Param("entities") List<FeePower> entities);

    /**
     * 修改数据
     *
     * @param feePower 实例对象
     * @return 影响行数
     */
    int update(FeePower feePower);

    /**
     * 通过主键删除数据
     *
     * @param powerid 主键
     * @return 影响行数
     */
    int deleteById(Integer powerid);

}

