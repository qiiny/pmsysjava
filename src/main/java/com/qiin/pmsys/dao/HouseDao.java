package com.qiin.pmsys.dao;

import com.qiin.pmsys.entity.FeeProperty;
import com.qiin.pmsys.entity.House;
import org.apache.ibatis.annotations.Param;
import org.springframework.data.domain.Pageable;
import java.util.List;

/**
 * (House)表数据库访问层
 *
 * @author Qin
 * @since 2022-03-09 17:11:45
 */
public interface HouseDao {

    /**
     * 通过ID查询单条数据
     *
     * @param houseid 主键
     * @return 实例对象
     */
    House queryById(Integer houseid);

    /**
     * 查询指定行数据
     *
     */
    List<House> queryAllByLimit(String housename, int pageStar, int pageSize);

    /**
     * 统计总行数
     *
     * @param house 查询条件
     * @return 总行数
     */
    int count(House house);

    /**
     * 新增数据
     *
     * @param house 实例对象
     * @return 影响行数
     */
    int insert(House house);

    /**
     * 批量新增数据（MyBatis原生foreach方法）
     *
     * @param entities List<House> 实例对象列表
     * @return 影响行数
     */
    int insertBatch(@Param("entities") List<House> entities);

    /**
     * 批量新增或按主键更新数据（MyBatis原生foreach方法）
     *
     * @param entities List<House> 实例对象列表
     * @return 影响行数
     * @throws org.springframework.jdbc.BadSqlGrammarException 入参是空List的时候会抛SQL语句错误的异常，请自行校验入参
     */
    int insertOrUpdateBatch(@Param("entities") List<House> entities);

    /**
     * 修改数据
     *
     * @param house 实例对象
     * @return 影响行数
     */
    int update(House house);

    /**
     * 通过主键删除数据
     *
     * @param houseid 主键
     * @return 影响行数
     */
    int deleteById(Integer houseid);

    /**
     * 根据楼栋获取房间
     * @return
     */
    List<House> queryByBuildingId(Integer BuildingId);
}

