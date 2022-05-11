package com.qiin.pmsys.service.impl;

import com.qiin.pmsys.entity.FeeWater;
import com.qiin.pmsys.entity.Staff;
import com.qiin.pmsys.dao.StaffDao;
import com.qiin.pmsys.service.StaffService;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;

import javax.annotation.Resource;
import java.util.List;

/**
 * (Staff)表服务实现类
 *
 * @author qiin
 * @since 2022-02-23 01:31:06
 */
@Service
public class StaffServiceImpl implements StaffService {
    @Resource
    private StaffDao staffDao;

    /**
     * 通过ID查询单条数据
     *
     * @param staffid 主键
     * @return 实例对象
     */
    @Override
    public Staff queryById(Integer staffid) {
        return this.staffDao.queryById(staffid);
    }


    /**
     * 新增数据
     *
     * @param staff 实例对象
     * @return 实例对象
     */
    @Override
    public Staff insert(Staff staff) {
        this.staffDao.insert(staff);
        return staff;
    }

    /**
     * 修改数据
     *
     * @param staff 实例对象
     * @return 实例对象
     */
    @Override
    public Staff update(Staff staff) {
        this.staffDao.update(staff);
        return this.queryById(staff.getStaffid());
    }

    /**
     * 通过主键删除数据
     *
     * @param staffid 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Integer staffid) {
        return this.staffDao.deleteById(staffid) > 0;
    }

    @Override
    public int getStaffCount() {
        return this.staffDao.count(new Staff());
    }

    @Override
    public List<Staff> getAllStaff(String staff, int pageNum, int pageSize) {
        return this.staffDao.queryAllByLimit(staff,pageNum,pageSize);
    }

    @Override
    public List<Staff> getAll(String staffPost) {
        return this.staffDao.queryAllByStaffPost(staffPost);
    }
}
