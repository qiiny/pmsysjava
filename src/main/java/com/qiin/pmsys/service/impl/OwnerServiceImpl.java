package com.qiin.pmsys.service.impl;

import com.qiin.pmsys.entity.Owner;
import com.qiin.pmsys.dao.OwnerDao;
import com.qiin.pmsys.service.OwnerService;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;

import javax.annotation.Resource;
import java.util.List;

/**
 * (Owner)表服务实现类
 *
 * @author qiin
 * @since 2022-02-23 01:31:05
 */
@Service
public class OwnerServiceImpl implements OwnerService {
    @Resource
    private OwnerDao ownerDao;

    /**
     * 通过ID查询单条数据
     *
     * @param ownerid 主键
     * @return 实例对象
     */
    @Override
    public Owner queryById(Integer ownerid) {
        return this.ownerDao.queryById(ownerid);
    }

    /**
     * 分页查询
     *
     * @param owner       筛选条件
     * @param pageRequest 分页对象
     * @return 查询结果
     */

//    /**
//     * 分页查询
//     *
//     * @param owner 筛选条件
//     * @param pageRequest      分页对象
//     * @return 查询结果
//     */
//    @Override
//    public Page<Owner> queryByPage(Owner owner, int page,int size) {
//        long total = this.ownerDao.count(owner);
//        return new PageImpl<>(this.ownerDao.queryAllByLimit(owner.getOwnername(), pageRequest), pageRequest, total);
//    }

    /**
     * 新增数据
     *
     * @param owner 实例对象
     * @return 实例对象
     */
    @Override
    public Owner insert(Owner owner) {
        this.ownerDao.insert(owner);
        return owner;

    }

    /**
     * 修改数据
     *
     * @param owner 实例对象
     * @return 实例对象
     */
    @Override
    public int update(Owner owner) {
        return this.ownerDao.update(owner);

    }

    /**
     * 通过主键删除数据
     *
     * @param ownerid 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Integer ownerid) {
        return this.ownerDao.deleteById(ownerid) > 0;
    }

    @Override
    public int getUserCount() {
        return this.ownerDao.count(new Owner());
    }

    @Override
    public List<Owner> getAllOwner(String ownerName, int page, int size) {
        return this.ownerDao.queryAllByLimit(ownerName, page,size);
    }

    /**
     * 不分页获取
     *
     * @return
     */
    @Override
    public List<Owner> getAllOwner() {
        return this.ownerDao.queryAll();
    }

    @Override
    public int getOwnerId(Owner owner) {
        Owner ownerId = this.ownerDao.getOwnerId(owner);
        if (ownerId == null) {
            return 0;
        }
        return ownerId.getOwnerid();
    }
}
