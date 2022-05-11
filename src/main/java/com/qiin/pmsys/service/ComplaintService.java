package com.qiin.pmsys.service;

import com.qiin.pmsys.entity.Complaint;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import java.util.List;

/**
 * (Complaint)表服务接口
 *
 * @author qiin
 * @since 2022-03-25 14:46:58
 */
public interface ComplaintService {

    /**
     * 通过ID查询单条数据
     *
     * @param complaintid 主键
     * @return 实例对象
     */
    Complaint queryById(Integer complaintid);



    /**
     * 新增数据
     *
     * @param complaint 实例对象
     * @return 实例对象
     */
    Complaint insert(Complaint complaint);

    /**
     * 修改数据
     *
     * @param complaint 实例对象
     * @return 实例对象
     */
    Complaint update(Complaint complaint);

    /**
     * 通过主键删除数据
     *
     * @param complaintid 主键
     * @return 是否成功
     */
    boolean deleteById(Integer complaintid);

    int getComplaintsCount();

    List<Complaint> getAllComplaints(String Complaints, int pageNum, int pageSize);
}
