package com.qiin.pmsys.controller;

import com.alibaba.fastjson.JSON;
import com.qiin.pmsys.entity.House;
import com.qiin.pmsys.entity.Owner;
import com.qiin.pmsys.service.HouseService;
import com.qiin.pmsys.service.OwnerService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.*;

/**
 * (Owner)表控制层
 *
 * @author qiin
 * @since 2022-02-23 01:31:05
 */
@RestController
@RequestMapping("owner")
public class OwnerController {
    /**
     * 服务对象
     */
    @Resource
    private OwnerService ownerService;
    @Resource
    private HouseService hoseService;
    /**
     * 分页查询
     *
     * @param
     * @param
     * @return 查询结果
     */
    @GetMapping
    public String queryByPage(String ownerName,int pageNum,int pageSize) {

        List<Owner> allUser = this.ownerService.getAllOwner("%"+ownerName+"%", (pageNum-1)*pageSize, pageSize);
        int ownerCount =this.ownerService.getUserCount();
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
    public ResponseEntity<Owner> queryById(@PathVariable("id") Integer id) {
        return ResponseEntity.ok(this.ownerService.queryById(id));
    }

    /**
     * 新增数据
     *
     * @param owner 实体
     * @return 新增结果
     */
    @PostMapping
    public String add(@RequestBody Owner owner) {
        Owner insert = this.ownerService.insert(owner);
        House house = new House();
        house.setOwnerid(owner.getOwnerid());
        house.setHouseid(owner.getHouseid());
        this.hoseService.update(house);
        return insert.getOwnerid()!=null?"success":"error";
    }

    /**
     * 编辑数据
     *
     * @param owner 实体
     * @return 编辑结果
     */
    @PutMapping
    public String edit(@RequestBody Owner owner) {
        Calendar calendar   =   new GregorianCalendar();
        calendar.setTime(owner.getCreatetime());
        calendar.add(Calendar.HOUR,8);
        owner.setCreatetime(calendar.getTime());
        return this.ownerService.update(owner)>0?"success":"error";
    }

    /**
     * 删除数据
     *
     * @param id 主键
     * @return 删除是否成功
     */
    @DeleteMapping
    public String deleteById(Integer id) {
        return this.ownerService.deleteById(id)?"success":"error";
    }
    @GetMapping("/list")
    public String list() {
        List<Owner> allOwner = this.ownerService.getAllOwner();
        HashMap<String, Object> map = new HashMap<>();
        map.put("data",allOwner);
        return JSON.toJSONString(map);
    }

    @PostMapping("/search")
    public int search(@RequestBody Owner owner){
        return this.ownerService.getOwnerId(owner);
    }

}

