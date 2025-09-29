package com.tencent.wxcloudrun.controller;

import com.tencent.wxcloudrun.config.ApiResponse;
import com.tencent.wxcloudrun.dto.BattleRegistrationRequest;
import com.tencent.wxcloudrun.model.BattleRegistration;
import com.tencent.wxcloudrun.service.BattleRegistrationService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 帮战报名控制器
 */
@RestController
public class BattleRegistrationController {

    private final BattleRegistrationService battleRegistrationService;
    private final Logger logger;

    public BattleRegistrationController(@Autowired BattleRegistrationService battleRegistrationService) {
        this.battleRegistrationService = battleRegistrationService;
        this.logger = LoggerFactory.getLogger(BattleRegistrationController.class);
    }

    /**
     * 报名帮战
     * @param request {@link BattleRegistrationRequest}
     * @return API response json
     */
    @PostMapping(value = "/api/battle/register")
    public ApiResponse register(@RequestBody BattleRegistrationRequest request) {
        logger.info("/api/battle/register post request, userId: {}", request.getUserId());
        
        try {
            BattleRegistration registration = battleRegistrationService.register(request);
            return ApiResponse.ok(registration);
        } catch (Exception e) {
            logger.error("报名失败", e);
            return ApiResponse.error("报名失败: " + e.getMessage());
        }
    }

    /**
     * 获取所有报名记录
     * @return API response json
     */
    @GetMapping(value = "/api/battle/registrations")
    public ApiResponse getAllRegistrations() {
        logger.info("/api/battle/registrations get request");
        
        try {
            List<BattleRegistration> registrations = battleRegistrationService.getAllRegistrations();
            return ApiResponse.ok(registrations);
        } catch (Exception e) {
            logger.error("获取报名记录失败", e);
            return ApiResponse.error("获取报名记录失败: " + e.getMessage());
        }
    }

    /**
     * 根据用户ID获取报名记录
     * @param userId 用户ID
     * @return API response json
     */
    @GetMapping(value = "/api/battle/registration/{userId}")
    public ApiResponse getRegistrationByUserId(@PathVariable String userId) {
        logger.info("/api/battle/registration/{} get request", userId);
        
        try {
            BattleRegistration registration = battleRegistrationService.getRegistrationByUserId(userId);
            return ApiResponse.ok(registration);
        } catch (Exception e) {
            logger.error("获取用户报名记录失败", e);
            return ApiResponse.error("获取用户报名记录失败: " + e.getMessage());
        }
    }

    /**
     * 取消报名
     * @param userId 用户ID
     * @return API response json
     */
    @DeleteMapping(value = "/api/battle/registration/{userId}")
    public ApiResponse cancelRegistration(@PathVariable String userId) {
        logger.info("/api/battle/registration/{} delete request", userId);
        
        try {
            boolean success = battleRegistrationService.cancelRegistration(userId);
            if (success) {
                return ApiResponse.ok("取消报名成功");
            } else {
                return ApiResponse.error("取消报名失败，用户未报名");
            }
        } catch (Exception e) {
            logger.error("取消报名失败", e);
            return ApiResponse.error("取消报名失败: " + e.getMessage());
        }
    }

    /**
     * 更新报名信息
     * @param request {@link BattleRegistrationRequest}
     * @return API response json
     */
    @PutMapping(value = "/api/battle/registration")
    public ApiResponse updateRegistration(@RequestBody BattleRegistrationRequest request) {
        logger.info("/api/battle/registration put request, userId: {}", request.getUserId());
        
        try {
            BattleRegistration registration = battleRegistrationService.updateRegistration(request);
            if (registration != null) {
                return ApiResponse.ok(registration);
            } else {
                return ApiResponse.error("更新失败，用户未报名");
            }
        } catch (Exception e) {
            logger.error("更新报名信息失败", e);
            return ApiResponse.error("更新报名信息失败: " + e.getMessage());
        }
    }
}
