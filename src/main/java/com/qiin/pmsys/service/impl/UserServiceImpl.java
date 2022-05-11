package com.qiin.pmsys.service.impl;

import com.qiin.pmsys.entity.Admin;
import com.qiin.pmsys.entity.User;
import com.qiin.pmsys.dao.UserDao;
import com.qiin.pmsys.service.UserService;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;

import javax.annotation.Resource;
import java.util.List;

/**
 * (User)表服务实现类
 *
 * @author qiin
 * @since 2022-02-23 01:31:06
 */
@Service
public class UserServiceImpl implements UserService {
    @Resource
    private UserDao userDao;

    /**
     * 通过ID查询单条数据
     *
     * @param userid 主键
     * @return 实例对象
     */
    @Override
    public User queryById(Integer userid) {
        return this.userDao.queryById(userid);
    }

    /**
     * 分页查询
     *
     * @param user 筛选条件
     * @param pageRequest      分页对象
     * @return 查询结果
     */
    @Override
    public Page<User> queryByPage(User user, PageRequest pageRequest) {
//        long total = this.userDao.count(user);
//        return new PageImpl<>(this.userDao.queryAllByLimit(user, pageRequest), pageRequest, total);
        return null;
    }

    /**
     * 新增数据
     *
     * @param user 实例对象
     * @return 实例对象
     */
    @Override
    public int insert(User user) {
        return this.userDao.insert(user);
    }

    /**
     * 修改数据
     *
     * @param user 实例对象
     * @return 实例对象
     */
    @Override
    public int update(User user) {
        return this.userDao.update(user);
    }

    /**
     * 通过主键删除数据
     *
     * @param userid 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Integer userid) {
        return this.userDao.deleteById(userid) > 0;
    }

    @Override
    public List<User> getAllOwner(String username, int pageNum, int pageSize) {
        return this.userDao.queryAllByLimit(username,pageNum,pageSize);
    }

    @Override
    public int getUserCount() {
        return this.userDao.count(new User());
    }

    @Override
    public User queryByUser(User user) {
        return this.userDao.queryByUser(user);
    }
}
