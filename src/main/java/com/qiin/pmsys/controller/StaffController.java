package com.qiin.pmsys.controller;

import com.alibaba.fastjson.JSON;
import com.qiin.pmsys.entity.Staff;
import com.qiin.pmsys.service.StaffService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;

/**
 * (Staff)表控制层
 *
 * @author qiin
 * @since 2022-02-23 01:31:06
 */
@RestController
@RequestMapping("staff")
public class StaffController {
    /**
     * 服务对象
     */
    @Resource
    private StaffService staffService;

    /**
     * 分页查询
     *
     * @param staffname   筛选条件
     * @param pageNum 分页对象
     * @return 查询结果
     */
    @GetMapping
    public String queryByPage(String staffname, int pageNum, int pageSize) {
        List<Staff> allUser = this.staffService.getAllStaff(staffname, (pageNum - 1) * pageSize, pageSize);
        int ownerCount = this.staffService.getStaffCount();
        HashMap<String, Object> map = new HashMap<>();
        map.put("numbers", ownerCount);
        map.put("data", allUser);
        return JSON.toJSONString(map);
    }

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("{id}")
    public ResponseEntity<Staff> queryById(@PathVariable("id") Integer id) {
        return ResponseEntity.ok(this.staffService.queryById(id));
    }

    /**
     * 新增数据
     *
     * @param staff 实体
     * @return 新增结果
     */
    @PostMapping
    public String add(@RequestBody Staff staff) {
        System.out.println(staff);
        Staff insert = this.staffService.insert(staff);
        return insert.getStaffid() > 0 ? "success" : "error";
    }

    /**
     * 编辑数据
     *
     * @param staff 实体
     * @return 编辑结果
     */
    @PutMapping
    public String edit(@RequestBody Staff staff) {
        Staff update = this.staffService.update(staff);
        return update.getStaffid() > 0 ? "success" : "error";
    }

    /**
     * 删除数据
     *
     * @param id 主键
     * @return 删除是否成功
     */
    @DeleteMapping
    public String deleteById(Integer id) {
        return this.staffService.deleteById(id) ? "success" : "error";
    }
    @GetMapping("/list")
    public String queryByPage(String staffPost) {
        List<Staff> allUser = this.staffService.getAll(staffPost);
        System.out.println(staffPost);
        HashMap<String, Object> map = new HashMap<>();
        map.put("data", allUser);
        return JSON.toJSONString(map);
    }
}

