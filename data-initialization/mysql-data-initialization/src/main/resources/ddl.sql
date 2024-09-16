-- 新增数据
CREATE DATABASE IF NOT EXISTS `datax_learn`
    CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci;

-- 创建表
CREATE TABLE IF NOT EXISTS `person`
(
    `id`             BIGINT UNSIGNED  NOT NULL AUTO_INCREMENT COMMENT '主键',
    `real_name`      VARCHAR(255) COMMENT '人员姓名',
    `birthday`       DATETIME COMMENT '出生日期',
    `sex`            TINYINT UNSIGNED COMMENT '性别0表示女，1表示男',
    `marital_status` TINYINT UNSIGNED COMMENT '婚姻状况，0表示未婚，2表示已婚，3表示离婚，4表示丧偶',
    `remark_text`    VARCHAR(512) COMMENT '备注',
    `bl_enable`      TINYINT UNSIGNED NOT NULL DEFAULT 1 COMMENT '是否启用，0表示否，1表示是',
    `bl_deleted`     TINYINT UNSIGNED NOT NULL DEFAULT 0 COMMENT '是否删除，0表示否，1表示是',
    `version_number` BIGINT UNSIGNED  NOT NULL DEFAULT 0 COMMENT '版本号',
    `gmt_create`     DATETIME         NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    `creator`        VARCHAR(64)      NOT NULL DEFAULT '' COMMENT '创建人真实姓名',
    `creator_id`     BIGINT UNSIGNED  NOT NULL DEFAULT 0 COMMENT '创建人ID',
    `creator_code`   VARCHAR(32)      NOT NULL DEFAULT 0 COMMENT '创建人code',
    `gmt_modify`     DATETIME         NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间',
    `modifier`       VARCHAR(64)      NOT NULL DEFAULT '' COMMENT '修改人真实姓名',
    `modifier_id`    BIGINT UNSIGNED  NOT NULL DEFAULT 0 COMMENT '修改人ID',
    `modifier_code`  VARCHAR(32)      NOT NULL DEFAULT 0 COMMENT '修改人code',
    PRIMARY KEY (`id`)
) COMMENT '人员信息';
