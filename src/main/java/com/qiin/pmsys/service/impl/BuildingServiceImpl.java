package com.qiin.pmsys.service.impl;

import com.qiin.pmsys.entity.Building;
import com.qiin.pmsys.dao.BuildingDao;
import com.qiin.pmsys.service.BuildingService;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;

import javax.annotation.Resource;
import java.util.List;

/**
 * (Building)表服务实现类
 *
 * @author qiin
 * @since 2022-02-23 01:31:05
 */
@Service
public class BuildingServiceImpl implements BuildingService {
    @Resource
    private BuildingDao buildingDao;

    /**
     * 通过ID查询单条数据
     *
     * @param buildingid 主键
     * @return 实例对象
     */
    @Override
    public Building queryById(Integer buildingid) {
        return this.buildingDao.queryById(buildingid);
    }

    /**
     * 分页查询
     *
     * @param building 筛选条件
     * @param pageRequest      分页对象
     * @return 查询结果
     */
    @Override
    public Page<Building> queryByPage(Building building, PageRequest pageRequest) {
        long total = this.buildingDao.count(building);
        return new PageImpl<>(this.buildingDao.queryAllByLimit(building, pageRequest), pageRequest, total);
    }

    /**
     * 新增数据
     *
     * @param building 实例对象
     * @return 实例对象
     */
    @Override
    public Building insert(Building building) {
        this.buildingDao.insert(building);
        return building;
    }

    /**
     * 修改数据
     *
     * @param building 实例对象
     * @return 实例对象
     */
    @Override
    public Building update(Building building) {
        this.buildingDao.update(building);
        return this.queryById(building.getBuildingid());
    }

    /**
     * 通过主键删除数据
     *
     * @param buildingid 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Integer buildingid) {
        return this.buildingDao.deleteById(buildingid) > 0;
    }

    /**
     * 获取全部楼栋信息
     *
     * @return
     */
    @Override
    public List<Building> getAllBuilding() {
        return this.buildingDao.getAllbuilding();
    }
}
