package com.qiin.pmsys.service;

import com.qiin.pmsys.entity.Owner;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import java.util.List;

/**
 * (Owner)表服务接口
 *
 * @author qiin
 * @since 2022-02-23 01:31:05
 */
public interface OwnerService {

    /**
     * 通过ID查询单条数据
     *
     * @param ownerid 主键
     * @return 实例对象
     */
    Owner queryById(Integer ownerid);



    /**
     * 新增数据
     *
     * @param owner 实例对象
     * @return 实例对象
     */
    Owner insert(Owner owner);

    /**
     * 修改数据
     *
     * @param owner 实例对象
     * @return 实例对象
     */
    int update(Owner owner);

    /**
     * 通过主键删除数据
     *
     * @param ownerid 主键
     * @return 是否成功
     */
    boolean deleteById(Integer ownerid);

    /**
     * 获取数量
     * @return
     */
    int getUserCount();

    /**
     * 分页获取全部业主
     * @param ownerName
     * @param page
     * @param size
     * @return
     */
    List<Owner> getAllOwner(String ownerName, int page, int size);

    /**
     * 不分页获取
     * @return
     */
    List<Owner> getAllOwner();

    int getOwnerId(Owner owner);
}
