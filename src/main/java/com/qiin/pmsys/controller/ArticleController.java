package com.qiin.pmsys.controller;

import com.alibaba.fastjson.JSON;
import com.qiin.pmsys.entity.Article;
import com.qiin.pmsys.entity.User;
import com.qiin.pmsys.service.ArticleService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;

/**
 * (Article)表控制层
 *
 * @author qiin
 * @since 2022-03-28 00:53:38
 */
@RestController
@RequestMapping("article")
public class ArticleController {
    /**
     * 服务对象
     */
    @Resource
    private ArticleService articleService;

    @GetMapping
    public String queryByPage(String title, int pageNum, int pageSize) {

        List<Article> allUser = this.articleService.getAllArticle("%" + title + "%", (pageNum - 1) * pageSize, pageSize);
        int ownerCount = this.articleService.count();
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
    public ResponseEntity<Article> queryById(@PathVariable("id") Integer id) {
        return ResponseEntity.ok(this.articleService.queryById(id));
    }

    /**
     * 新增数据
     *
     * @param article 实体
     * @return 新增结果
     */
    @PostMapping
    public ResponseEntity<Article> add(Article article) {
        return ResponseEntity.ok(this.articleService.insert(article));
    }

    /**
     * 编辑数据
     *
     * @param article 实体
     * @return 编辑结果
     */
    @PutMapping
    public ResponseEntity<Article> edit(Article article) {
        return ResponseEntity.ok(this.articleService.update(article));
    }

    /**
     * 删除数据
     *
     * @param id 主键
     * @return 删除是否成功
     */
    @DeleteMapping
    public ResponseEntity<Boolean> deleteById(Integer id) {
        return ResponseEntity.ok(this.articleService.deleteById(id));
    }

}

