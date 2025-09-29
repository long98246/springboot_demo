package com.tencent.wxcloudrun.dto;

import lombok.Data;

@Data
public class BattleRegistrationRequest {

    private String userId;

    private String userName;

    private Integer starCoin;

    private String profession;

    private String remark;
}
