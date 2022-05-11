package com.qiin.pmsys.controller;

import com.alibaba.fastjson.JSON;
import com.qiin.pmsys.entity.Building;
import com.qiin.pmsys.entity.House;
import com.qiin.pmsys.entity.User;
import com.qiin.pmsys.service.HouseService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;

/**
 * (House)表控制层
 *
 * @author Qin
 * @since 2022-03-10 15:28:33
 */
@RestController
@RequestMapping("house")
public class HouseController {
    /**
     * 服务对象
     */
    @Resource
    private HouseService houseService;

    /**
     * 分页查询
     *
     * @param
     * @param
     * @return 查询结果
     */
    @GetMapping
    public String queryByPage(String housename,int pageNum,int pageSize) {
        System.out.println(housename);
        List<House> allUser = this.houseService.getAllOwner("%"+housename+"%", (pageNum-1)*pageSize, pageSize);
        System.out.println(allUser);
        int ownerCount =this.houseService.getUserCount();
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
    public ResponseEntity<House> queryById(@PathVariable("id") Integer id) {
        return ResponseEntity.ok(this.houseService.queryById(id));
    }

    /**
     * 新增数据
     *
     * @param house 实体
     * @return 新增结果
     */
    @PostMapping
    public String add(@RequestBody House house) {

        return this.houseService.insert(house)>0?"success":"error";
    }

    /**
     * 编辑数据
     *
     * @param house 实体
     * @return 编辑结果
     */
    @PutMapping
    public String edit(@RequestBody House house) {
        return this.houseService.update(house)>0?"success":"error";
    }

    /**
     * 删除数据
     *
     * @param id 主键
     * @return 删除是否成功
     */
    @DeleteMapping
    public String deleteById(Integer id) {
        return this.houseService.deleteById(id)?"success":"error";
    }

    @GetMapping("/building")
    public String getHouseByBuildingId(Integer buildingid){
        System.out.println(buildingid);
        List<House> houses = this.houseService.queryByBuildingId(buildingid);
        HashMap<String, Object> map = new HashMap<>();
        map.put("data",houses);
        return JSON.toJSONString(map);
    }

}

