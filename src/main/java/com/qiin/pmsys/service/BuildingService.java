package com.qiin.pmsys.service;

import com.qiin.pmsys.entity.Building;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import java.util.List;

/**
 * (Building)表服务接口
 *
 * @author qiin
 * @since 2022-02-23 01:31:05
 */
public interface BuildingService {

    /**
     * 通过ID查询单条数据
     *
     * @param buildingid 主键
     * @return 实例对象
     */
    Building queryById(Integer buildingid);

    /**
     * 分页查询
     *
     * @param building 筛选条件
     * @param pageRequest      分页对象
     * @return 查询结果
     */
    Page<Building> queryByPage(Building building, PageRequest pageRequest);

    /**
     * 新增数据
     *
     * @param building 实例对象
     * @return 实例对象
     */
    Building insert(Building building);

    /**
     * 修改数据
     *
     * @param building 实例对象
     * @return 实例对象
     */
    Building update(Building building);

    /**
     * 通过主键删除数据
     *
     * @param buildingid 主键
     * @return 是否成功
     */
    boolean deleteById(Integer buildingid);

    /**
     * 获取全部楼栋信息
     * @return
     */
    List<Building> getAllBuilding();
}
