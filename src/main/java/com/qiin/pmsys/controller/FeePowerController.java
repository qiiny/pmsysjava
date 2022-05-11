package com.qiin.pmsys.controller;

import com.alibaba.fastjson.JSON;
import com.qiin.pmsys.entity.FeePower;
import com.qiin.pmsys.entity.FeeWater;
import com.qiin.pmsys.entity.QueryInfo;
import com.qiin.pmsys.service.FeePowerService;
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
import java.util.Date;
import java.util.HashMap;
import java.util.List;

/**
 * (FeePower)表控制层
 *
 * @author qiin
 * @since 2022-02-23 01:31:05
 */
@RestController
@RequestMapping("feePower")
public class FeePowerController {
    /**
     * 服务对象
     */
    @Resource
    private FeePowerService feePowerService;

    /**
     * 分页查询
     *
     * @param
     * @param
     * @return 查询结果
     */
    @GetMapping
    public String queryByPage(QueryInfo queryInfo) throws ParseException {
        List<FeePower> allUser = this.feePowerService.getAllFeeWater(queryInfo.getOwnerid(),queryInfo.getPayMonth(), (queryInfo.getPageNum()-1)* queryInfo.getPageSize(), queryInfo.getPageSize());
        int ownerCount =this.feePowerService.getFeeCount(queryInfo.getOwnerid());
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
    public ResponseEntity<FeePower> queryById(@PathVariable("id") Integer id) {
        return ResponseEntity.ok(this.feePowerService.queryById(id));
    }

    /**
     * 新增数据
     *
     * @param feePower 实体
     * @return 新增结果
     */
    @PostMapping
    public String add(@RequestBody FeePower feePower) {
        return this.feePowerService.insert(feePower)>0?"success":"error";
    }

    /**
     * 编辑数据
     *
     * @param feePower 实体
     * @return 编辑结果
     */
    @PutMapping
    public String edit(@RequestBody FeePower feePower) {
        System.out.println(feePower);
        return this.feePowerService.update(feePower)>0?"success":"error";
    }

    /**
     * 删除数据
     *
     * @param id 主键
     * @return 删除是否成功
     */
    @DeleteMapping
    public String deleteById(Integer id) {
        return this.feePowerService.deleteById(id)?"success":"error";
    }

}

