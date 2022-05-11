package com.qiin.pmsys.controller;

import com.alibaba.fastjson.JSON;
import com.qiin.pmsys.entity.House;
import com.qiin.pmsys.entity.Notice;
import com.qiin.pmsys.entity.Owner;
import com.qiin.pmsys.service.NoticeService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.List;

/**
 * (Notice)表控制层
 *
 * @author qiin
 * @since 2022-03-21 15:59:28
 */
@RestController
@RequestMapping("notice")
public class NoticeController {
    /**
     * 服务对象
     */
    @Resource
    private NoticeService noticeService;

    /**
     * 分页查询
     *
     * @param
     * @param
     * @return 查询结果
     */
    @GetMapping
    public String queryByPage(String noticeTitle,int pageNum,int pageSize) {

        List<Notice> allUser = this.noticeService.getAllNotice("%"+noticeTitle+"%", (pageNum-1)*pageSize, pageSize);
        int ownerCount =this.noticeService.getNoticeCount();
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
    public ResponseEntity<Notice> queryById(@PathVariable("id") Integer id) {
        return ResponseEntity.ok(this.noticeService.queryById(id));
    }

    /**
     * 新增数据
     *
     * @param notice 实体
     * @return 新增结果
     */
    @PostMapping
    public String add(@RequestBody Notice notice) {
        Notice insert = this.noticeService.insert(notice);
        House house = new House();
        return insert.getNoticeid()!=null?"success":"error";
    }

    /**
     * 编辑数据
     *
     * @param notice 实体
     * @return 编辑结果
     */
    @PutMapping
    public String edit(@RequestBody Notice notice) {
        return this.noticeService.update(notice).getNoticeid()>0?"success":"error";
    }

    /**
     * 删除数据
     *
     * @param id 主键
     * @return 删除是否成功
     */
    @DeleteMapping
    public String deleteById(Integer id) {
        return this.noticeService.deleteById(id)?"success":"error";
    }

}

