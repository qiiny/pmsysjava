package com.qiin.pmsys.service.impl;

import com.qiin.pmsys.entity.Notice;
import com.qiin.pmsys.dao.NoticeDao;
import com.qiin.pmsys.service.NoticeService;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;

import javax.annotation.Resource;
import java.util.List;

/**
 * (Notice)表服务实现类
 *
 * @author qiin
 * @since 2022-03-21 16:04:29
 */
@Service
public class NoticeServiceImpl implements NoticeService {
    @Resource
    private NoticeDao noticeDao;

    /**
     * 通过ID查询单条数据
     *
     * @param noticeid 主键
     * @return 实例对象
     */
    @Override
    public Notice queryById(Integer noticeid) {
        return this.noticeDao.queryById(noticeid);
    }



    /**
     * 新增数据
     *
     * @param notice 实例对象
     * @return 实例对象
     */
    @Override
    public Notice insert(Notice notice) {
        this.noticeDao.insert(notice);
        return notice;
    }

    /**
     * 修改数据
     *
     * @param notice 实例对象
     * @return 实例对象
     */
    @Override
    public Notice update(Notice notice) {
        this.noticeDao.update(notice);
        return this.queryById(notice.getNoticeid());
    }

    /**
     * 通过主键删除数据
     *
     * @param noticeid 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Integer noticeid) {
        return this.noticeDao.deleteById(noticeid) > 0;
    }

    @Override
    public int getNoticeCount() {
        return (int) this.noticeDao.count(new Notice());
    }

    @Override
    public List<Notice> getAllNotice(String noticetitle, int pageNum, int pageSize) {
        return this.noticeDao.queryAllByLimit(noticetitle,pageNum,pageSize);
    }
}
