package com.qiin.pmsys.dao;

import com.qiin.pmsys.entity.Owner;
import org.apache.ibatis.annotations.Param;
import org.springframework.data.domain.Pageable;
import java.util.List;

/**
 * (Owner)表数据库访问层
 *
 * @author Qin
 * @since 2022-03-09 17:11:45
 */
public interface OwnerDao {

    /**
     * 通过ID查询单条数据
     *
     * @param ownerid 主键
     * @return 实例对象
     */
    Owner queryById(Integer ownerid);

    /**
     * 查询指定行数据
     *
     * @param ownername 查询条件
     * @return 对象列表
     */
    List<Owner> queryAllByLimit(String ownername, int pageStart,int pageSize);

    /**
     * 统计总行数
     *
     * @param owner 查询条件
     * @return 总行数
     */
    int count(Owner owner);

    /**
     * 新增数据
     *
     * @param owner 实例对象
     * @return 影响行数
     */
    int insert(Owner owner);

    /**
     * 批量新增数据（MyBatis原生foreach方法）
     *
     * @param entities List<Owner> 实例对象列表
     * @return 影响行数
     */
    int insertBatch(@Param("entities") List<Owner> entities);

    /**
     * 批量新增或按主键更新数据（MyBatis原生foreach方法）
     *
     * @param entities List<Owner> 实例对象列表
     * @return 影响行数
     * @throws org.springframework.jdbc.BadSqlGrammarException 入参是空List的时候会抛SQL语句错误的异常，请自行校验入参
     */
    int insertOrUpdateBatch(@Param("entities") List<Owner> entities);

    /**
     * 修改数据
     *
     * @param owner 实例对象
     * @return 影响行数
     */
    int update(Owner owner);

    /**
     * 通过主键删除数据
     *
     * @param ownerid 主键
     * @return 影响行数
     */
    int deleteById(Integer ownerid);

    /**
     * 不分页获取全部数据
     * @return
     */
    List<Owner> queryAll();

    Owner getOwnerId(Owner owner);
}

