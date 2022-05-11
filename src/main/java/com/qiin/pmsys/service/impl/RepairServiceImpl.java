package com.qiin.pmsys.service.impl;

import com.qiin.pmsys.entity.Repair;
import com.qiin.pmsys.dao.RepairDao;
import com.qiin.pmsys.service.RepairService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * (Repair)表服务实现类
 *
 * @author qiin
 * @since 2022-02-23 01:31:06
 */
@Service
public class RepairServiceImpl implements RepairService {
    @Resource
    private RepairDao repairDao;

    /**
     * 通过ID查询单条数据
     *
     * @param repairid 主键
     * @return 实例对象
     */
    @Override
    public Repair queryById(Integer repairid) {
        return this.repairDao.queryById(repairid);
    }


    /**
     * 新增数据
     *
     * @param repair 实例对象
     * @return 实例对象
     */
    @Override
    public Repair insert(Repair repair) {
        this.repairDao.insert(repair);
        return repair;
    }

    /**
     * 修改数据
     *
     * @param repair 实例对象
     * @return 实例对象
     */
    @Override
    public Repair update(Repair repair) {
        this.repairDao.update(repair);
        return this.queryById(repair.getRepairid());
    }

    /**
     * 通过主键删除数据
     *
     * @param repairid 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Integer repairid) {
        return this.repairDao.deleteById(repairid) > 0;
    }

    @Override
    public int getUserCount() {
        return this.repairDao.count(new Repair());
    }

    @Override
    public List<Repair> getAllOwner(String createtime, int repairtype,int pageNum, int pageSize) {
        return this.repairDao.queryAllByLimit(createtime, repairtype, pageNum,pageSize);
    }
}
