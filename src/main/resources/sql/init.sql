CREATE
DATABASE IF NOT EXISTS test DEFAULT CHARSET utf8mb4 COLLATE utf8mb4_unicode_ci;
use
test;

CREATE TABLE `operation_log_history`
(
    `id`                     bigint(20) NOT NULL AUTO_INCREMENT,
    `app_code`               varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '应用编号',
    `app_name`               varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '应用名称',
    `lang`                   varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '语言',
    `identity_provider_id`   varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '用户认证来源',
    `identity_provider_name` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '用户认证来源名称',
    `user_id`                bigint(20) DEFAULT NULL COMMENT '操作用户Id',
    `username`               varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '操作用户名称',
    `real_name`              varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '操作用户姓名',
    `page_code`              varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '页面编号',
    `page_name`              varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '页面对象编号',
    `btn_code`               varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '按钮编号',
    `btn_name`               varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '按钮对象编号',
    `content`                mediumtext COLLATE utf8mb4_unicode_ci COMMENT '备注',
    `terminal`               varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '终端类型',
    `ip`                     varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '操作IP',
    `archive_time`           datetime                                DEFAULT NULL COMMENT '归档时间',
    `create_by`              varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '创建人',
    `create_time`            datetime                                DEFAULT NULL COMMENT '创建时间',
    `update_by`              varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '更新人',
    `update_time`            datetime                                DEFAULT NULL COMMENT '更新时间',
    `is_deleted`             enum('Y','N') COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '是否逻辑删除 （Y：已删除  N：未删除）',
    PRIMARY KEY (`id`)
) ENGINE=MyISAM  DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci COMMENT='用户操作记录历史表';

INSERT INTO auth.operation_log_history (id, app_code, app_name, lang, identity_provider_id, identity_provider_name,
                                        user_id, username, real_name, page_code, page_name, btn_code, btn_name, content,
                                        terminal, ip, archive_time, create_by, create_time, update_by, update_time,
                                        is_deleted)
VALUES (1788807205810630670, 'unity', 'AppConnector', 'en-US', '1', 'HETU', 3, 'admin', 'APP Administrator',
        'PAGE-unity-msgManage-subscribe', 'Message Subscription', 'BUTTON-unity-msgManage-subscribe-edit', 'Edit',
        '[{"topicCode":"UserImport","subscriptionRoles":[],"subscriptionUsers":[],"rule":{"enableAlert":true,"alertTemplate":"用户批量导入完成，请及时查看！","enableEmail":false,"enableGroupNotifications":false,"alertImmediately":true,"emailImmediately":false},"handleWay":{"displayIgnore":true,"displayHandle":true,"appCode":"unity","resourceCode":"MODULE-unity-authManage/PAGE-unity-authManage-user"}}]',
        'pc', '', '2024-05-10 13:44:07', 'admin', '2024-05-08 13:40:10', 'admin', '2024-05-08 13:40:10', 'N');
INSERT INTO auth.operation_log_history (id, app_code, app_name, lang, identity_provider_id, identity_provider_name,
                                        user_id, username, real_name, page_code, page_name, btn_code, btn_name, content,
                                        terminal, ip, archive_time, create_by, create_time, update_by, update_time,
                                        is_deleted)
VALUES (1788807205810630671, 'unity', 'AppConnector', 'ko-KR', '1', 'HETU', 3, 'admin', '응용관리자',
        'PAGE-unity-msgManage-subscribe', '메시지 구독', 'BUTTON-unity-msgManage-subscribe-edit', '편집',
        '[{"topicCode":"UserImport","subscriptionRoles":[],"subscriptionUsers":[],"rule":{"enableAlert":true,"alertTemplate":"用户批量导入完成，请及时查看！","enableEmail":false,"enableGroupNotifications":false,"alertImmediately":true,"emailImmediately":false},"handleWay":{"displayIgnore":true,"displayHandle":true,"appCode":"unity","resourceCode":"MODULE-unity-authManage/PAGE-unity-authManage-user"}}]',
        'pc', '', '2024-05-10 13:44:07', 'admin', '2024-05-08 13:40:10', 'admin', '2024-05-08 13:40:10', 'N');
INSERT INTO auth.operation_log_history (id, app_code, app_name, lang, identity_provider_id, identity_provider_name,
                                        user_id, username, real_name, page_code, page_name, btn_code, btn_name, content,
                                        terminal, ip, archive_time, create_by, create_time, update_by, update_time,
                                        is_deleted)
VALUES (1788807205810630672, 'unity', 'AppConnector', 'zh-CN', '1', '河图', 3, 'admin', '应用管理员',
        'PAGE-unity-msgManage-subscribe', '消息订阅', 'BUTTON-unity-msgManage-subscribe-edit', '编辑',
        '[{"topicCode":"UserImport","subscriptionRoles":[],"subscriptionUsers":[],"rule":{"enableAlert":true,"alertTemplate":"用户批量导入完成，请及时查看！","enableEmail":false,"enableGroupNotifications":false,"alertImmediately":true,"emailImmediately":false},"handleWay":{"displayIgnore":true,"displayHandle":true,"appCode":"unity","resourceCode":"MODULE-unity-authManage/PAGE-unity-authManage-user"}}]',
        'pc', '', '2024-05-10 13:44:07', 'admin', '2024-05-08 13:40:10', 'admin', '2024-05-08 13:40:10', 'N');
