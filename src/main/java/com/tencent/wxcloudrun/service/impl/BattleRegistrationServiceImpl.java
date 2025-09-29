package com.tencent.wxcloudrun.service.impl;

import com.tencent.wxcloudrun.dao.BattleRegistrationMapper;
import com.tencent.wxcloudrun.dto.BattleRegistrationRequest;
import com.tencent.wxcloudrun.model.BattleRegistration;
import com.tencent.wxcloudrun.service.BattleRegistrationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class BattleRegistrationServiceImpl implements BattleRegistrationService {

    @Autowired
    private BattleRegistrationMapper battleRegistrationMapper;

    @Override
    public BattleRegistration register(BattleRegistrationRequest request) {
        // 检查用户是否已经报名
        BattleRegistration existing = battleRegistrationMapper.findByUserId(request.getUserId());
        if (existing != null) {
            // 如果已经报名，更新信息
            existing.setUserName(request.getUserName());
            existing.setStarCoin(request.getStarCoin());
            existing.setProfession(request.getProfession());
            existing.setRemark(request.getRemark());
            existing.setUpdatedAt(LocalDateTime.now());
            battleRegistrationMapper.update(existing);
            return existing;
        }

        // 新用户报名
        BattleRegistration registration = new BattleRegistration();
        registration.setUserId(request.getUserId());
        registration.setUserName(request.getUserName());
        registration.setStarCoin(request.getStarCoin());
        registration.setProfession(request.getProfession());
        registration.setRemark(request.getRemark());
        registration.setRegistrationTime(LocalDateTime.now());
        registration.setCreatedAt(LocalDateTime.now());
        registration.setUpdatedAt(LocalDateTime.now());

        battleRegistrationMapper.insert(registration);
        return registration;
    }

    @Override
    public List<BattleRegistration> getAllRegistrations() {
        return battleRegistrationMapper.findAll();
    }

    @Override
    public BattleRegistration getRegistrationByUserId(String userId) {
        return battleRegistrationMapper.findByUserId(userId);
    }

    @Override
    public boolean cancelRegistration(String userId) {
        return battleRegistrationMapper.deleteByUserId(userId) > 0;
    }

    @Override
    public BattleRegistration updateRegistration(BattleRegistrationRequest request) {
        BattleRegistration existing = battleRegistrationMapper.findByUserId(request.getUserId());
        if (existing == null) {
            return null;
        }

        existing.setUserName(request.getUserName());
        existing.setStarCoin(request.getStarCoin());
        existing.setProfession(request.getProfession());
        existing.setRemark(request.getRemark());
        existing.setUpdatedAt(LocalDateTime.now());

        battleRegistrationMapper.update(existing);
        return existing;
    }
}
