package com.tencent.wxcloudrun.dao;

import com.tencent.wxcloudrun.model.BattleRegistration;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface BattleRegistrationMapper {

    /**
     * 插入帮战报名记录
     */
    int insert(BattleRegistration battleRegistration);

    /**
     * 根据用户ID查询报名记录
     */
    BattleRegistration findByUserId(@Param("userId") String userId);

    /**
     * 查询所有报名记录
     */
    List<BattleRegistration> findAll();

    /**
     * 根据用户ID删除报名记录
     */
    int deleteByUserId(@Param("userId") String userId);

    /**
     * 更新报名记录
     */
    int update(BattleRegistration battleRegistration);
}
