package com.qiin.pmsys.service;

import com.qiin.pmsys.entity.Repair;

import java.util.List;

/**
 * (Repair)表服务接口
 *
 * @author qiin
 * @since 2022-02-23 01:31:06
 */
public interface RepairService {

    /**
     * 通过ID查询单条数据
     *
     * @param repairid 主键
     * @return 实例对象
     */
    Repair queryById(Integer repairid);


    /**
     * 新增数据
     *
     * @param repair 实例对象
     * @return 实例对象
     */
    Repair insert(Repair repair);

    /**
     * 修改数据
     *
     * @param repair 实例对象
     * @return 实例对象
     */
    Repair update(Repair repair);

    /**
     * 通过主键删除数据
     *
     * @param repairid 主键
     * @return 是否成功
     */
    boolean deleteById(Integer repairid);

    int getUserCount(Integer ownerid);

    List<Repair> getAllRepair(String createtime, Integer repairtype, Integer pageNum, Integer pageSize,Integer ownerid);
}
