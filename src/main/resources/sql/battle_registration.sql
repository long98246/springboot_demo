-- 帮战报名表
CREATE TABLE IF NOT EXISTS battle_registration (
    id BIGINT AUTO_INCREMENT PRIMARY KEY COMMENT '主键ID',
    user_id VARCHAR(100) NOT NULL COMMENT '用户ID（微信openid）',
    user_name VARCHAR(50) NOT NULL COMMENT '用户名称',
    star_coin INT DEFAULT 0 COMMENT '星元',
    profession VARCHAR(50) NOT NULL COMMENT '职业',
    remark TEXT COMMENT '备注',
    registration_time DATETIME DEFAULT CURRENT_TIMESTAMP COMMENT '报名时间',
    created_at DATETIME DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    updated_at DATETIME DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
    INDEX idx_user_id (user_id),
    INDEX idx_registration_time (registration_time)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='帮战报名表';
