package com.qiin.pmsys.controller;

import com.alibaba.fastjson.JSON;
import com.qiin.pmsys.entity.Comment;
import com.qiin.pmsys.service.CommentService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * 评论(Comment)表控制层
 *
 * @author makejava
 * @since 2022-05-15 00:44:12
 */
@RestController
@RequestMapping("comment")
public class CommentController {
    /**
     * 服务对象
     */
    @Resource
    private CommentService commentService;


    @GetMapping
    public String queryByPage() {
        List<Comment> comments = this.commentService.queryComments();
        for (Comment comment : comments) {
            comment.setReply(this.commentService.queryReply(comment.getId()));
        }
        return JSON.toJSONString(comments);
    }

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("{id}")
    public ResponseEntity<Comment> queryById(@PathVariable("id") Integer id) {
        return ResponseEntity.ok(this.commentService.queryById(id));
    }

    /**
     * 新增数据
     *
     * @param comment 实体
     * @return 新增结果
     */
    @PostMapping
    public ResponseEntity<Comment> add(Comment comment) {
        return ResponseEntity.ok(this.commentService.insert(comment));
    }

    /**
     * 编辑数据
     *
     * @param comment 实体
     * @return 编辑结果
     */
    @PutMapping
    public ResponseEntity<Comment> edit(Comment comment) {
        return ResponseEntity.ok(this.commentService.update(comment));
    }

    /**
     * 删除数据
     *
     * @param id 主键
     * @return 删除是否成功
     */
    @DeleteMapping
    public ResponseEntity<Boolean> deleteById(Integer id) {
        return ResponseEntity.ok(this.commentService.deleteById(id));
    }

}

