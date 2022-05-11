package com.qiin.pmsys.dao;

import com.qiin.pmsys.entity.Complaint;
import org.apache.ibatis.annotations.Param;
import org.springframework.data.domain.Pageable;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

/**
 * (Complaint)表数据库访问层
 *
 * @author qiin
 * @since 2022-03-25 14:46:58
 */
@Mapper
public interface ComplaintDao {

    /**
     * 通过ID查询单条数据
     *
     * @param complaintid 主键
     * @return 实例对象
     */
    Complaint queryById(Integer complaintid);

    /**
     * 查询指定行数据
     * @return 对象列表
     */
    List<Complaint> queryAllByLimit(String Complaints,int pageNum,int pageSize);

    /**
     * 统计总行数
     *
     * @param complaint 查询条件
     * @return 总行数
     */
    long count(Complaint complaint);

    /**
     * 新增数据
     *
     * @param complaint 实例对象
     * @return 影响行数
     */
    int insert(Complaint complaint);

    /**
     * 批量新增数据（MyBatis原生foreach方法）
     *
     * @param entities List<Complaint> 实例对象列表
     * @return 影响行数
     */
    int insertBatch(@Param("entities") List<Complaint> entities);

    /**
     * 批量新增或按主键更新数据（MyBatis原生foreach方法）
     *
     * @param entities List<Complaint> 实例对象列表
     * @return 影响行数
     * @throws org.springframework.jdbc.BadSqlGrammarException 入参是空List的时候会抛SQL语句错误的异常，请自行校验入参
     */
    int insertOrUpdateBatch(@Param("entities") List<Complaint> entities);

    /**
     * 修改数据
     *
     * @param complaint 实例对象
     * @return 影响行数
     */
    int update(Complaint complaint);

    /**
     * 通过主键删除数据
     *
     * @param complaintid 主键
     * @return 影响行数
     */
    int deleteById(Integer complaintid);

}

