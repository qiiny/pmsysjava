package com.qiin.pmsys.service;

import com.qiin.pmsys.entity.House;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import java.util.List;

/**
 * (House)表服务接口
 *
 * @author Qin
 * @since 2022-03-10 15:28:55
 */
public interface HouseService {

    /**
     * 通过ID查询单条数据
     *
     * @param houseid 主键
     * @return 实例对象
     */
    House queryById(Integer houseid);



    /**
     * 新增数据
     *
     * @param house 实例对象
     * @return 实例对象
     */
    int insert(House house);

    /**
     * 修改数据
     *
     * @param house 实例对象
     * @return 实例对象
     */
    int update(House house);

    /**
     * 通过主键删除数据
     *
     * @param houseid 主键
     * @return 是否成功
     */
    boolean deleteById(Integer houseid);

    /**
     * 根据楼栋编号获取房间
     * @return
     */
    List<House> queryByBuildingId(Integer BuildingId);

    int getUserCount();

    List<House> getAllOwner(String housename, int pageNum, int pageSize);
}
