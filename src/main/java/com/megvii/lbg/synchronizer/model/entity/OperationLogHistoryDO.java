package com.megvii.lbg.synchronizer.model.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.megvii.lbg.synchronizer.util.LocalDateTimeToTimestamp;
import com.megvii.lbg.synchronizer.util.TimestampToLocalDateTime;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.time.LocalDateTime;

/**
 * 操作日志历史表
 *
 * @author zhaomaosong@megvii.com
 * @date 2024-03-25 13:39
 */
@Data
@TableName("operation_log_history")
public class OperationLogHistoryDO {

    private Long id;

    private String appCode;

    private String appName;

    private String lang;

    private String identityProviderId;

    private String identityProviderName;

    private Long userId;

    private String username;

    private String realName;

    private String pageCode;

    private String pageName;

    private String btnCode;

    private String btnName;

    private String terminal;

    private String ip;

    private String content;

    private LocalDateTime archiveTime;

    private LocalDateTime createTime;

    private LocalDateTime updateTime;

    private String createBy;

    private String updateBy;

    private String isDeleted;

}
