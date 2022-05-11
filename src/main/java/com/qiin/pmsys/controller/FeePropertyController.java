package com.qiin.pmsys.controller;

import com.alibaba.fastjson.JSON;
import com.qiin.pmsys.entity.FeePower;
import com.qiin.pmsys.entity.FeeProperty;
import com.qiin.pmsys.entity.QueryInfo;
import com.qiin.pmsys.service.FeePropertyService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.text.ParseException;
import java.util.HashMap;
import java.util.List;

/**
 * (FeeProperty)表控制层
 *
 * @author qiin
 * @since 2022-02-23 01:31:05
 */
@RestController
@RequestMapping("feeProperty")
public class FeePropertyController {
    /**
     * 服务对象
     */
    @Resource
    private FeePropertyService feePropertyService;

    /**
     * 分页查询
     *
     * @param
     * @param
     * @return 查询结果
     */
    @GetMapping
    public String queryByPage(QueryInfo queryInfo) throws ParseException {
        List<FeeProperty> allUser = this.feePropertyService.getAllFeeWater(queryInfo.getOwnerid(),queryInfo.getPayMonth(), (queryInfo.getPageNum()-1)* queryInfo.getPageSize(), queryInfo.getPageSize());
        int ownerCount =this.feePropertyService.getFeeCount(queryInfo.getOwnerid());
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
    public ResponseEntity<FeeProperty> queryById(@PathVariable("id") Integer id) {
        return ResponseEntity.ok(this.feePropertyService.queryById(id));
    }

    /**
     * 新增数据
     *
     * @param feeProperty 实体
     * @return 新增结果
     */
    @PostMapping
    public String add(@RequestBody FeeProperty feeProperty) {
        return this.feePropertyService.insert(feeProperty)>0?"success":"error";
    }

    /**
     * 编辑数据
     *
     * @param feeProperty 实体
     * @return 编辑结果
     */
    @PutMapping
    public String edit(@RequestBody FeeProperty feeProperty) {
        return this.feePropertyService.update(feeProperty)>0?"success":"error";
    }

    /**
     * 删除数据
     *
     * @param id 主键
     * @return 删除是否成功
     */
    @DeleteMapping
    public String deleteById(Integer id) {
        return this.feePropertyService.deleteById(id)?"success":"error";
    }

}

