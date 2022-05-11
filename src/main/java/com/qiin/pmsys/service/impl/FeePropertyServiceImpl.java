package com.qiin.pmsys.service.impl;

import com.qiin.pmsys.dao.FeePropertyDao;
import com.qiin.pmsys.entity.FeeProperty;
import com.qiin.pmsys.service.FeePropertyService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * (FeeProperty)表服务实现类
 *
 * @author qiin
 * @since 2022-02-23 01:31:05
 */
@Service
public class FeePropertyServiceImpl implements FeePropertyService {
    @Resource
    private FeePropertyDao feePropertyDao;

    /**
     * 通过ID查询单条数据
     *
     * @param propertyid 主键
     * @return 实例对象
     */
    @Override
    public FeeProperty queryById(Integer propertyid) {
        return this.feePropertyDao.queryById(propertyid);
    }



    /**
     * 新增数据
     *
     * @param feeProperty 实例对象
     * @return 实例对象
     */
    @Override
    public int insert(FeeProperty feeProperty) {
        return this.feePropertyDao.insert(feeProperty);
    }

    /**
     * 修改数据
     *
     * @param feeProperty 实例对象
     * @return 实例对象
     */
    @Override
    public int update(FeeProperty feeProperty) {
        return this.feePropertyDao.update(feeProperty);
    }

    /**
     * 通过主键删除数据
     *
     * @param propertyid 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Integer propertyid) {
        return this.feePropertyDao.deleteById(propertyid) > 0;
    }

    @Override
    public List<FeeProperty> getAllFeeWater(int ownerid, String payMonth, int pageNum, int pageSize) {
        return this.feePropertyDao.queryAllByLimit(ownerid,payMonth,pageNum,pageSize);
    }

    @Override
    public int getFeeCount(int ownerid) {
        FeeProperty feeProperty=new FeeProperty();
        feeProperty.setOwnerid(ownerid);
        return this.feePropertyDao.count(feeProperty);
    }
}
