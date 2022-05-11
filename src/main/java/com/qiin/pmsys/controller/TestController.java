package com.qiin.pmsys.controller;

import com.alibaba.fastjson.JSONObject;
import com.qiin.pmsys.entity.Test;
import com.qiin.pmsys.service.TestService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.io.File;
import java.io.IOException;

/**
 * (Test)表控制层
 *
 * @author qiin
 * @since 2022-03-19 14:47:32
 */
@RestController
@RequestMapping("test")
public class TestController {
    /**
     * 服务对象
     */
    @Resource
    private TestService testService;

    /**
     * 分页查询
     *
     * @param test 筛选条件
     * @param pageRequest      分页对象
     * @return 查询结果
     */
    @GetMapping
    public ResponseEntity<Page<Test>> queryByPage(Test test, PageRequest pageRequest) {
        return ResponseEntity.ok(this.testService.queryByPage(test, pageRequest));
    }

    @RequestMapping("uploadImg")
    public Object uploadAva(@RequestParam("file") MultipartFile file) throws IOException {
        JSONObject jsonObject = new JSONObject();
        if (file.isEmpty()) {
            jsonObject.put("code","200");
            jsonObject.put("msg", "文件上传失败");
            System.out.println("上传失败");
            return jsonObject;
        }
        //文件名
        String fileName = System.currentTimeMillis() + file.getOriginalFilename();
        //文件路径
        String filePath = System.getProperty("user.dir") + System.getProperty("file.separator") + "img"
                + System.getProperty("file.separator") + "test";
        //判断文件路径
        File file1 = new File(filePath);
        if (!file1.exists()) {
            //创建文件夹
            file1.mkdirs();
        }
        File dest = new File(filePath + System.getProperty("file.separator") + fileName);
        file.transferTo(dest);
        String storeAvatorPath = "/img/test/" + fileName;
        System.out.println(storeAvatorPath);
        return "http://localhost:9000"+storeAvatorPath;
        //把相对文件地址存储到数据库

    }

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("{id}")
    public ResponseEntity<Test> queryById(@PathVariable("id") Integer id) {
        return ResponseEntity.ok(this.testService.queryById(id));
    }

    /**
     * 新增数据
     *
     * @param test 实体
     * @return 新增结果
     */
    @PostMapping
    public ResponseEntity<Test> add(Test test) {
        return ResponseEntity.ok(this.testService.insert(test));
    }

    /**
     * 编辑数据
     *
     * @param test 实体
     * @return 编辑结果
     */
    @PutMapping
    public ResponseEntity<Test> edit(Test test) {
        return ResponseEntity.ok(this.testService.update(test));
    }

    /**
     * 删除数据
     *
     * @param id 主键
     * @return 删除是否成功
     */
    @DeleteMapping
    public ResponseEntity<Boolean> deleteById(Integer id) {
        return ResponseEntity.ok(this.testService.deleteById(id));
    }

}

