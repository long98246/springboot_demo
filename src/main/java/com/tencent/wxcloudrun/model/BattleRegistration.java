package com.tencent.wxcloudrun.model;

import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;

@Data
public class BattleRegistration implements Serializable {

    private Long id;

    private String userId;

    private String userName;

    private Integer starCoin;

    private String profession;

    private String remark;

    private LocalDateTime registrationTime;

    private LocalDateTime createdAt;

    private LocalDateTime updatedAt;
}
