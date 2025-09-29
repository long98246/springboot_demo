package com.tencent.wxcloudrun.service;

import com.tencent.wxcloudrun.dto.BattleRegistrationRequest;
import com.tencent.wxcloudrun.model.BattleRegistration;

import java.util.List;

public interface BattleRegistrationService {

    /**
     * 报名帮战
     */
    BattleRegistration register(BattleRegistrationRequest request);

    /**
     * 获取所有报名记录
     */
    List<BattleRegistration> getAllRegistrations();

    /**
     * 根据用户ID获取报名记录
     */
    BattleRegistration getRegistrationByUserId(String userId);

    /**
     * 取消报名
     */
    boolean cancelRegistration(String userId);

    /**
     * 更新报名信息
     */
    BattleRegistration updateRegistration(BattleRegistrationRequest request);
}
