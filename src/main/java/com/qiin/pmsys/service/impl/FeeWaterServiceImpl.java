package com.qiin.pmsys.service.impl;

import com.qiin.pmsys.dao.FeeWaterDao;
import com.qiin.pmsys.entity.FeeWater;
import com.qiin.pmsys.service.FeeWaterService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * (FeeWater)表服务实现类
 *
 * @author qiin
 * @since 2022-02-23 01:31:05
 */
@Service
public class FeeWaterServiceImpl implements FeeWaterService {
    @Resource
    private FeeWaterDao feeWaterDao;

    /**
     * 通过ID查询单条数据
     *
     * @param waterid 主键
     * @return 实例对象
     */
    @Override
    public FeeWater queryById(Integer waterid) {
        return this.feeWaterDao.queryById(waterid);
    }

    /**
     * 分页查询
     *
     * @param feeWater    筛选条件
     * @param pageRequest 分页对象
     * @return 查询结果
     */
    @Override
    public Page<FeeWater> queryByPage(FeeWater feeWater, PageRequest pageRequest) {
//        long total = this.feeWaterDao.count(feeWater);
//        return new PageImpl<>(this.feeWaterDao.queryAllByLimit(feeWater, pageRequest), pageRequest, total);
        return null;
    }

    /**
     * 新增数据
     *
     * @param feeWater 实例对象
     * @return 实例对象
     */
    @Override
    public int insert(FeeWater feeWater) {
        return this.feeWaterDao.insert(feeWater);
    }

    /**
     * 修改数据
     *
     * @param feeWater 实例对象
     * @return 实例对象
     */
    @Override
    public int update(FeeWater feeWater) {
       return this.feeWaterDao.update(feeWater);

    }

    /**
     * 通过主键删除数据
     *
     * @param waterid 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Integer waterid) {
        return this.feeWaterDao.deleteById(waterid) > 0;
    }

    @Override
    public List<FeeWater> getAllFeeWater(int ownerId, String payMonth, int pageNum, int pageSize) {
        return this.feeWaterDao.queryAllByLimit(ownerId,payMonth, pageNum, pageSize);
    }

    @Override
    public int getFeeCount(int ownerId) {
        FeeWater feeWater=new FeeWater();
        feeWater.setOwnerid(ownerId);
        return this.feeWaterDao.count(feeWater);
    }
}
