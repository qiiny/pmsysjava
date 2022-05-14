package com.qiin.pmsys.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.qiin.pmsys.entity.Admin;
import com.qiin.pmsys.entity.Owner;
import com.qiin.pmsys.entity.User;
import com.qiin.pmsys.service.OwnerService;
import com.qiin.pmsys.service.UserService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.io.File;
import java.io.IOException;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.List;

/**
 * (User)表控制层
 *
 * @author qiin
 * @since 2022-02-23 01:31:06
 */
@RestController
@RequestMapping("user")
public class UserController {
    /**
     * 服务对象
     */
    @Resource
    private UserService userService;


    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String login(@RequestBody User user) {
        String flag = "error";
        User u = this.userService.queryByUser(user);
        HashMap<String, Object> res = new HashMap<>();
        if (u != null) {
            flag = "ok";
        }
        res.put("flag", flag);
        res.put("user", u);
        return JSON.toJSONString(res);
    }


    /**
     * 分页查询
     *
     * @param
     * @param
     * @return 查询结果
     */
    @GetMapping
    public String queryByPage(String username, int pageNum, int pageSize) {

        List<User> allUser = this.userService.getAllOwner("%" + username + "%", (pageNum - 1) * pageSize, pageSize);
        int ownerCount = this.userService.getUserCount();
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
    public ResponseEntity<User> queryById(@PathVariable("id") Integer id) {
        return ResponseEntity.ok(this.userService.queryById(id));
    }

    /**
     * 新增数据
     *
     * @param user 实体
     * @return 新增结果
     */
    @PostMapping
    public String add(@RequestBody User user) {

        return this.userService.insert(user) > 0 ? "success" : "error";
    }

    /**
     * 编辑数据
     *
     * @param user 实体
     * @return 编辑结果
     */
    @PutMapping
    public String edit(@RequestBody User user) {
        System.out.println(user);
        return this.userService.update(user) > 0 ? "success" : "error";
    }

    @PutMapping("/status")
    public String editStatus(User user) {
        System.out.println(user);
        return this.userService.update(user) > 0 ? "success" : "error";
    }

    /**
     * 删除数据
     *
     * @param id 主键
     * @return 删除是否成功
     */
    @DeleteMapping
    public String deleteById(Integer id) {
        return this.userService.deleteById(id) ? "success" : "error";
    }

    @RequestMapping(value = "uploadImg", method = RequestMethod.POST)
    public Object uploadAva(@RequestParam("file") MultipartFile file, @RequestParam("id") int id) throws IOException {
        JSONObject jsonObject = new JSONObject();
        if (file.isEmpty()) {
            jsonObject.put("code", "200");
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
        User user = new User();
        user.setUserid(id);
        user.setAvatar("http://localhost:9000" + storeAvatorPath);
        int update = this.userService.update(user);
        if (update > 0) {
            User user1 = this.userService.queryById(id);
            jsonObject.put("code", 200);
            jsonObject.put("msg", "修改成功");
            jsonObject.put("user", user1);
        } else {
            jsonObject.put("code", 201);
            jsonObject.put("msg", "修改失败");
        }
        return jsonObject;
    }
}

