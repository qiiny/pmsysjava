package com.qiin.pmsys.dao;

import com.qiin.pmsys.entity.Repair;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * (Repair)表数据库访问层
 *
 * @author Qin
 * @since 2022-03-09 17:11:45
 */
public interface RepairDao {

    /**
     * 通过ID查询单条数据
     *
     * @param repairid 主键
     * @return 实例对象
     */
    Repair queryById(Integer repairid);

    /**
     * 查询指定行数据
     *
     * @return 对象列表
     */
    List<Repair> queryAllByLimit(String createtime,int repairtype, int pageStart,int pageSize);

    /**
     * 统计总行数
     *
     * @param repair 查询条件
     * @return 总行数
     */
    int count(Repair repair);

    /**
     * 新增数据
     *
     * @param repair 实例对象
     * @return 影响行数
     */
    int insert(Repair repair);

    /**
     * 批量新增数据（MyBatis原生foreach方法）
     *
     * @param entities List<Repair> 实例对象列表
     * @return 影响行数
     */
    int insertBatch(@Param("entities") List<Repair> entities);

    /**
     * 批量新增或按主键更新数据（MyBatis原生foreach方法）
     *
     * @param entities List<Repair> 实例对象列表
     * @return 影响行数
     * @throws org.springframework.jdbc.BadSqlGrammarException 入参是空List的时候会抛SQL语句错误的异常，请自行校验入参
     */
    int insertOrUpdateBatch(@Param("entities") List<Repair> entities);

    /**
     * 修改数据
     *
     * @param repair 实例对象
     * @return 影响行数
     */
    int update(Repair repair);

    /**
     * 通过主键删除数据
     *
     * @param repairid 主键
     * @return 影响行数
     */
    int deleteById(Integer repairid);

}

