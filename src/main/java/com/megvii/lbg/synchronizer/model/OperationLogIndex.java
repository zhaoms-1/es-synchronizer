package com.megvii.lbg.synchronizer.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.megvii.lbg.synchronizer.util.ISOStringToLocalDateTime;
import com.megvii.lbg.synchronizer.util.LocalDateTimeToISOString;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;


@JsonIgnoreProperties(ignoreUnknown = true)
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class OperationLogIndex {
    //    @Field(type = FieldType.Integer)
    private Long id;

    //    @Field(type = FieldType.Keyword)
    private String appCode;

    //    @Field(type = FieldType.Keyword)
    private String appName;

    //    @Field(type = FieldType.Keyword)
    private String lang;

    //    @Field(type = FieldType.Keyword)
    private String identityProviderName;

    //    @Field(type = FieldType.Keyword)
    private String username;

    //    @Field(type = FieldType.Keyword)
    private String realName;

    //    @Field(type = FieldType.Keyword)
    private String pageName;

    //    @Field(type = FieldType.Keyword)
    private String btnName;

    //    @Field(type = FieldType.Keyword)
    private String terminal;

    //    @Field(type = FieldType.Text)
    private String content;

    @JsonSerialize(using = LocalDateTimeToISOString.class)
    @JsonDeserialize(using = ISOStringToLocalDateTime.class)
    private LocalDateTime createTime;


    @JsonSerialize(using = LocalDateTimeToISOString.class)
    @JsonDeserialize(using = ISOStringToLocalDateTime.class)
    private LocalDateTime archiveTime;
}
