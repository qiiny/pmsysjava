package com.qiin.pmsys.service.impl;

import com.qiin.pmsys.entity.Complaint;
import com.qiin.pmsys.dao.ComplaintDao;
import com.qiin.pmsys.service.ComplaintService;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;

import javax.annotation.Resource;
import java.util.List;

/**
 * (Complaint)表服务实现类
 *
 * @author qiin
 * @since 2022-03-25 14:46:58
 */
@Service
public class ComplaintServiceImpl implements ComplaintService {
    @Resource
    private ComplaintDao complaintDao;

    /**
     * 通过ID查询单条数据
     *
     * @param complaintid 主键
     * @return 实例对象
     */
    @Override
    public Complaint queryById(Integer complaintid) {
        return this.complaintDao.queryById(complaintid);
    }



    /**
     * 新增数据
     *
     * @param complaint 实例对象
     * @return 实例对象
     */
    @Override
    public Complaint insert(Complaint complaint) {
        this.complaintDao.insert(complaint);
        return complaint;
    }

    /**
     * 修改数据
     *
     * @param complaint 实例对象
     * @return 实例对象
     */
    @Override
    public Complaint update(Complaint complaint) {
        this.complaintDao.update(complaint);
        return this.queryById(complaint.getComplaintid());
    }

    /**
     * 通过主键删除数据
     *
     * @param complaintid 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Integer complaintid) {
        return this.complaintDao.deleteById(complaintid) > 0;
    }

    @Override
    public int getComplaintsCount() {
        return (int) this.complaintDao.count(new Complaint());
    }

    @Override
    public List<Complaint> getAllComplaints(String Complaints, int pageNum, int pageSize) {
        return this.complaintDao.queryAllByLimit(Complaints,pageNum,pageSize);
    }
}
