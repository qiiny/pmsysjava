package com.qiin.pmsys.controller;

import com.alibaba.fastjson.JSON;
import com.qiin.pmsys.entity.QueryInfo;
import com.qiin.pmsys.entity.Repair;
import com.qiin.pmsys.entity.User;
import com.qiin.pmsys.service.RepairService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;

/**
 * (Repair)表控制层
 *
 * @author qiin
 * @since 2022-02-23 01:31:06
 */
@RestController
@RequestMapping("repair")
public class RepairController {
    /**
     * 服务对象
     */
    @Resource
    private RepairService repairService;

    /**
     * 分页查询
     *
     * @return 查询结果
     */
    @GetMapping
    public String queryByPage(QueryInfo queryInfo) {
        List<Repair> allUser = this.repairService.getAllRepair(queryInfo.getCreateTime(), queryInfo.getRepairtype(), (queryInfo.getPageNum() - 1) * queryInfo.getPageSize(), queryInfo.getPageSize(), queryInfo.getOwnerid());
        int ownerCount = this.repairService.getUserCount(queryInfo.getOwnerid());
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
    public ResponseEntity<Repair> queryById(@PathVariable("id") Integer id) {
        return ResponseEntity.ok(this.repairService.queryById(id));
    }

    /**
     * 新增数据
     *
     * @param repair 实体
     * @return 新增结果
     */
    @PostMapping
    public String add(@RequestBody Repair repair) {
        Repair insert = this.repairService.insert(repair);
        return insert.getRepairid()>0?"success":"error";
    }

    /**
     * 编辑数据
     *
     * @param repair 实体
     * @return 编辑结果
     */
    @PutMapping
    public String edit(@RequestBody Repair repair) {
        System.out.println(repair);
        Repair update = this.repairService.update(repair);
        return update.getRepairid() > 0 ? "success" : "error";
    }

    /**
     * 删除数据
     *
     * @param id 主键
     * @return 删除是否成功
     */
    @DeleteMapping
    public ResponseEntity<Boolean> deleteById(Integer id) {
        return ResponseEntity.ok(this.repairService.deleteById(id));
    }
    @PutMapping("/status")
    public String editStatus(Repair repair) {
        return this.repairService.update(repair).getRepairid() > 0 ? "success" : "error";
    }
}

