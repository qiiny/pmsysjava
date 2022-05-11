package com.qiin.pmsys.service;

import com.qiin.pmsys.entity.FeeWater;
import com.qiin.pmsys.entity.Staff;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import java.util.List;

/**
 * (Staff)表服务接口
 *
 * @author qiin
 * @since 2022-02-23 01:31:06
 */
public interface StaffService {

    /**
     * 通过ID查询单条数据
     *
     * @param staffid 主键
     * @return 实例对象
     */
    Staff queryById(Integer staffid);



    /**
     * 新增数据
     *
     * @param staff 实例对象
     * @return 实例对象
     */
    Staff insert(Staff staff);

    /**
     * 修改数据
     *
     * @param staff 实例对象
     * @return 实例对象
     */
    Staff update(Staff staff);

    /**
     * 通过主键删除数据
     *
     * @param staffid 主键
     * @return 是否成功
     */
    boolean deleteById(Integer staffid);

    int getStaffCount();

    List<Staff> getAllStaff(String staff, int pageNum, int pageSize);

    List<Staff> getAll(String staffPost);
}
