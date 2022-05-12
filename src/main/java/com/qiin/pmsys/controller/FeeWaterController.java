package com.qiin.pmsys.controller;

import com.alibaba.fastjson.JSON;
import com.qiin.pmsys.entity.FeeProperty;
import com.qiin.pmsys.entity.FeeWater;
import com.qiin.pmsys.entity.Owner;
import com.qiin.pmsys.entity.QueryInfo;
import com.qiin.pmsys.service.FeeWaterService;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.WebRequest;

import javax.annotation.Resource;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * (FeeWater)表控制层
 *
 * @author qiin
 * @since 2022-02-23 01:31:05
 */
@RestController
@RequestMapping("feeWater")
public class FeeWaterController {
    /**
     * 服务对象
     */
    @Resource
    private FeeWaterService feeWaterService;
    /**
     * 分页查询
     *
     * @param
     * @param
     * @return 查询结果
     */
    @GetMapping
    public String queryByPage(QueryInfo queryInfo) throws ParseException {
        List<FeeWater> allUser = this.feeWaterService.getAllFeeWater(queryInfo.getOwnerid(),queryInfo.getPayMonth(), (queryInfo.getPageNum()-1)* queryInfo.getPageSize(), queryInfo.getPageSize());
        int ownerCount =this.feeWaterService.getFeeCount(queryInfo.getOwnerid());
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
    public ResponseEntity<FeeWater> queryById(@PathVariable("id") Integer id) {
        return ResponseEntity.ok(this.feeWaterService.queryById(id));
    }

    /**
     * 新增数据
     *
     * @param feeWater 实体
     * @return 新增结果
     */
    @PostMapping
    public String add(@RequestBody FeeWater feeWater) {
        return this.feeWaterService.insert(feeWater)>0?"success":"error";
    }

    /**
     * 编辑数据
     *
     * @param feeWater 实体
     * @return 编辑结果
     */
    @PutMapping
    public String edit(@RequestBody FeeWater feeWater) {
        return this.feeWaterService.update(feeWater)>0?"success":"error";
    }

    /**
     * 删除数据
     *
     * @param id 主键
     * @return 删除是否成功
     */
    @DeleteMapping
    public String deleteById(Integer id) {
        return this.feeWaterService.deleteById(id)?"success":"error";
    }
    @GetMapping("/status")
    public String editStatus(Integer id) {
        System.out.println(id);
        FeeWater feeWater=new FeeWater();
        feeWater.setWaterid(id);
        feeWater.setIspay(1);
        return this.feeWaterService.update(feeWater) > 0 ? "success" : "error";
    }
}

