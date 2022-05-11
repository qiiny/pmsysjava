package com.qiin.pmsys.service.impl;

import com.qiin.pmsys.entity.House;
import com.qiin.pmsys.dao.HouseDao;
import com.qiin.pmsys.service.HouseService;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;

import javax.annotation.Resource;
import java.util.List;

/**
 * (House)表服务实现类
 *
 * @author Qin
 * @since 2022-03-10 15:28:55
 */
@Service("houseService")
public class HouseServiceImpl implements HouseService {
    @Resource
    private HouseDao houseDao;

    /**
     * 通过ID查询单条数据
     *
     * @param houseid 主键
     * @return 实例对象
     */
    @Override
    public House queryById(Integer houseid) {
        return this.houseDao.queryById(houseid);
    }



    /**
     * 新增数据
     *
     * @param house 实例对象
     * @return 实例对象
     */
    @Override
    public int insert(House house) {
        return this.houseDao.insert(house);
    }

    /**
     * 修改数据
     *
     * @param house 实例对象
     * @return 实例对象
     */
    @Override
    public int update(House house) {
       return this.houseDao.update(house);
    }

    /**
     * 通过主键删除数据
     *
     * @param houseid 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Integer houseid) {
        return this.houseDao.deleteById(houseid) > 0;
    }

    @Override
    public List<House> queryByBuildingId(Integer BuildingId) {
        return this.houseDao.queryByBuildingId(BuildingId);
    }

    @Override
    public int getUserCount() {
        return this.houseDao.count(new House());
    }

    @Override
    public List<House> getAllOwner(String housename, int pageNum, int pageSize) {
        return this.houseDao.queryAllByLimit(housename,pageNum,pageSize);
    }
}
