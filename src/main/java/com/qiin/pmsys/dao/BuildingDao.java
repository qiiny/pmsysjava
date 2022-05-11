package com.qiin.pmsys.dao;

import com.qiin.pmsys.entity.Building;
import org.apache.ibatis.annotations.Param;
import org.springframework.data.domain.Pageable;
import java.util.List;

/**
 * (Building)表数据库访问层
 *
 * @author Qin
 * @since 2022-03-09 17:11:45
 */
public interface BuildingDao {

    /**
     * 通过ID查询单条数据
     *
     * @param buildingid 主键
     * @return 实例对象
     */
    Building queryById(Integer buildingid);

    /**
     * 查询指定行数据
     *
     * @param building 查询条件
     * @param pageable         分页对象
     * @return 对象列表
     */
    List<Building> queryAllByLimit(Building building, @Param("pageable") Pageable pageable);

    /**
     * 统计总行数
     *
     * @param building 查询条件
     * @return 总行数
     */
    long count(Building building);

    /**
     * 新增数据
     *
     * @param building 实例对象
     * @return 影响行数
     */
    int insert(Building building);

    /**
     * 批量新增数据（MyBatis原生foreach方法）
     *
     * @param entities List<Building> 实例对象列表
     * @return 影响行数
     */
    int insertBatch(@Param("entities") List<Building> entities);

    /**
     * 批量新增或按主键更新数据（MyBatis原生foreach方法）
     *
     * @param entities List<Building> 实例对象列表
     * @return 影响行数
     * @throws org.springframework.jdbc.BadSqlGrammarException 入参是空List的时候会抛SQL语句错误的异常，请自行校验入参
     */
    int insertOrUpdateBatch(@Param("entities") List<Building> entities);

    /**
     * 修改数据
     *
     * @param building 实例对象
     * @return 影响行数
     */
    int update(Building building);

    /**
     * 通过主键删除数据
     *
     * @param buildingid 主键
     * @return 影响行数
     */
    int deleteById(Integer buildingid);

    /**
     * 获取全部楼栋信息
     * @return
     */
    List<Building> getAllbuilding();
}

