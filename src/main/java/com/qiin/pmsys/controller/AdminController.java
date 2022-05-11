package com.qiin.pmsys.controller;

import com.alibaba.fastjson.JSON;
import com.qiin.pmsys.entity.Admin;
import com.qiin.pmsys.service.AdminService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;

/**
 * (Admin)表控制层
 *
 * @author qiin
 * @since 2022-02-23 01:31:05
 */
@RestController
@RequestMapping("admin")
public class AdminController {
    /**
     * 服务对象
     */
    @Resource
    private AdminService adminService;



    @RequestMapping(value = "/login",method = RequestMethod.POST)
    public String login(@RequestBody Admin admin){
        String flag="error";
        Admin admins = this.adminService.queryByAdmin(admin);
        HashMap<String, Object> res = new HashMap<>();
        if (admins != null) {
            flag = "ok";
        }
        res.put("flag", flag);
        res.put("admin", admins);
        return JSON.toJSONString(res);
    }

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("{id}")
    public ResponseEntity<Admin> queryById(@PathVariable("id") Integer id) {
        return ResponseEntity.ok(this.adminService.queryById(id));
    }

    /**
     * 新增数据
     *
     * @param admin 实体
     * @return 新增结果
     */
    @PostMapping
    public ResponseEntity<Admin> add(Admin admin) {
        return ResponseEntity.ok(this.adminService.insert(admin));
    }

    /**
     * 编辑数据
     *
     * @param admin 实体
     * @return 编辑结果
     */
    @PutMapping
    public ResponseEntity<Admin> edit(Admin admin) {
        return ResponseEntity.ok(this.adminService.update(admin));
    }

    /**
     * 删除数据
     *
     * @param id 主键
     * @return 删除是否成功
     */
    @DeleteMapping
    public ResponseEntity<Boolean> deleteById(Integer id) {
        return ResponseEntity.ok(this.adminService.deleteById(id));
    }


}

