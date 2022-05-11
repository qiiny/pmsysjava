package com.qiin.pmsys.controller;

import com.alibaba.fastjson.JSON;
import com.qiin.pmsys.entity.Menu;
import com.qiin.pmsys.service.MenuService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * (Menu)表控制层
 *
 * @author qiin
 * @since 2022-02-23 21:42:31
 */
@RestController
@RequestMapping("menu")
public class MenuController {
    /**
     * 服务对象
     */
    @Resource
    private MenuService menuService;

    /**
     * 分页查询
     *
     * @param menu 筛选条件
     * @param pageRequest      分页对象
     * @return 查询结果
     */
    @GetMapping
    public ResponseEntity<Page<Menu>> queryByPage(Menu menu, PageRequest pageRequest) {
        return ResponseEntity.ok(this.menuService.queryByPage(menu, pageRequest));
    }

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
//    @GetMapping("{id}")
//    public ResponseEntity<Menu> queryById(@PathVariable("id") Integer id) {
//        return ResponseEntity.ok(this.menuService.queryById(id));
//    }

    /**
     * 新增数据
     *
     * @param menu 实体
     * @return 新增结果
     */
    @PostMapping
    public ResponseEntity<Menu> add(Menu menu) {
        return ResponseEntity.ok(this.menuService.insert(menu));
    }

    /**
     * 编辑数据
     *
     * @param menu 实体
     * @return 编辑结果
     */
    @PutMapping
    public ResponseEntity<Menu> edit(Menu menu) {
        return ResponseEntity.ok(this.menuService.update(menu));
    }

    /**
     * 删除数据
     *
     * @param id 主键
     * @return 删除是否成功
     */
    @DeleteMapping
    public ResponseEntity<Boolean> deleteById(Integer id) {
        return ResponseEntity.ok(this.menuService.deleteById(id));
    }

    @RequestMapping(value = "/menus",method = RequestMethod.GET)
    public String getMenus(){
        List<Menu> l1 = this.menuService.queryByLevel(1);
        List<Menu> l2=new ArrayList<>();
        for (Menu menu:l1) {
            List<Menu> menus = this.menuService.queryByParentid(menu.getId());
            menu.setList(menus);
            l2.add(menu);
        }
        HashMap<String,Object> data=new HashMap<>();
        if (l1!=null){
            data.put("flag",200);
            data.put("data",l1);
        }else {
            data.put("flag",404);
        }
        return JSON.toJSONString(data);
    }
}

