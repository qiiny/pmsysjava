package com.qiin.pmsys.service.impl;

import com.qiin.pmsys.entity.FeePower;
import com.qiin.pmsys.dao.FeePowerDao;
import com.qiin.pmsys.service.FeePowerService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * (FeePower)表服务实现类
 *
 * @author qiin
 * @since 2022-02-23 01:31:05
 */
@Service
public class FeePowerServiceImpl implements FeePowerService {
    @Resource
    private FeePowerDao feePowerDao;

    /**
     * 通过ID查询单条数据
     *
     * @param powerid 主键
     * @return 实例对象
     */
    @Override
    public FeePower queryById(Integer powerid) {
        return this.feePowerDao.queryById(powerid);
    }



    /**
     * 新增数据
     *
     * @param feePower 实例对象
     * @return 实例对象
     */
    @Override
    public int insert(FeePower feePower) {
       return this.feePowerDao.insert(feePower);
    }

    /**
     * 修改数据
     *
     * @param feePower 实例对象
     * @return 实例对象
     */
    @Override
    public int update(FeePower feePower) {
        return this.feePowerDao.update(feePower);
    }

    /**
     * 通过主键删除数据
     *
     * @param powerid 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Integer powerid) {
        return this.feePowerDao.deleteById(powerid) > 0;
    }

    @Override
    public List<FeePower> getAllFeeWater(int ownerid, String payMonth, int pageNum, int pageSize) {
        return this.feePowerDao.queryAllByLimit(ownerid,payMonth, pageNum, pageSize);
    }

    @Override
    public int getFeeCount(int ownerid) {
        FeePower feePower=new FeePower();
        feePower.setOwnerid(ownerid);
        return this.feePowerDao.count(feePower);
    }
}
