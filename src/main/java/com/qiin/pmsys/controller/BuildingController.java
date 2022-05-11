package com.qiin.pmsys.controller;

import com.alibaba.fastjson.JSON;
import com.qiin.pmsys.entity.Building;
import com.qiin.pmsys.service.BuildingService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;

/**
 * (Building)表控制层
 *
 * @author qiin
 * @since 2022-02-23 01:31:05
 */
@RestController
@RequestMapping("building")
public class BuildingController {
    /**
     * 服务对象
     */
    @Resource
    private BuildingService buildingService;


    @GetMapping
    public String queryByPage() {
        List<Building> list= this.buildingService.getAllBuilding();
        HashMap<String, Object> map = new HashMap<>();
        map.put("data",list);
        return JSON.toJSONString(map);
    }

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("{id}")
    public ResponseEntity<Building> queryById(@PathVariable("id") Integer id) {
        return ResponseEntity.ok(this.buildingService.queryById(id));
    }

    /**
     * 新增数据
     *
     * @param building 实体
     * @return 新增结果
     */
    @PostMapping
    public ResponseEntity<Building> add(Building building) {
        return ResponseEntity.ok(this.buildingService.insert(building));
    }

    /**
     * 编辑数据
     *
     * @param building 实体
     * @return 编辑结果
     */
    @PutMapping
    public ResponseEntity<Building> edit(Building building) {
        return ResponseEntity.ok(this.buildingService.update(building));
    }

    /**
     * 删除数据
     *
     * @param id 主键
     * @return 删除是否成功
     */
    @DeleteMapping
    public ResponseEntity<Boolean> deleteById(Integer id) {
        return ResponseEntity.ok(this.buildingService.deleteById(id));
    }

}

