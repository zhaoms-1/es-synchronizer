package com.megvii.lbg.synchronizer.model.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


import java.io.Serial;
import java.time.LocalDateTime;

/**
 * 这里添加类的注释【强制】
 *
 * @author zhaomaosong@megvii.com
 * @date 2024-05-09 19:22
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Contents {

    private Integer id;

    private String title;

    private String intro;

    private String content;

    private Integer createId;

    private String createName;

    private LocalDateTime createTime;
}
