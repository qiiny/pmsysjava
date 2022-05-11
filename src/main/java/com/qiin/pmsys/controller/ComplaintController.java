package com.qiin.pmsys.controller;

import com.alibaba.fastjson.JSON;
import com.qiin.pmsys.entity.Complaint;
import com.qiin.pmsys.entity.Notice;
import com.qiin.pmsys.service.ComplaintService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;

/**
 * (Complaint)表控制层
 *
 * @author qiin
 * @since 2022-03-25 14:46:57
 */
@RestController
@RequestMapping("complaint")
public class ComplaintController {
    /**
     * 服务对象
     */
    @Resource
    private ComplaintService complaintService;

    @GetMapping
    public String queryByPage(String Complaints,int pageNum,int pageSize) {
        List<Complaint> allUser = this.complaintService.getAllComplaints("%"+Complaints+"%", (pageNum-1)*pageSize, pageSize);
        int ownerCount =this.complaintService.getComplaintsCount();
        HashMap<String, Object> map = new HashMap<>();
        map.put("numbers",ownerCount);
        map.put("data",allUser);
        return JSON.toJSONString(map);
    }

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("{id}")
    public ResponseEntity<Complaint> queryById(@PathVariable("id") Integer id) {
        return ResponseEntity.ok(this.complaintService.queryById(id));
    }

    /**
     * 新增数据
     *
     * @param complaint 实体
     * @return 新增结果
     */
    @PostMapping
    public String add(Complaint complaint) {
        return this.complaintService.insert(complaint).getOwnerid()>0?"success":"error";
    }

    /**
     * 编辑数据
     *
     * @param complaint 实体
     * @return 编辑结果
     */
    @PutMapping
    public String edit(Complaint complaint) {
      return this.complaintService.update(complaint).getComplaintid()>0?"success":"error";
    }

    /**
     * 删除数据
     *
     * @param id 主键
     * @return 删除是否成功
     */
    @DeleteMapping
    public String deleteById(Integer id) {
        return this.complaintService.deleteById(id)?"success":"error";
    }

}

