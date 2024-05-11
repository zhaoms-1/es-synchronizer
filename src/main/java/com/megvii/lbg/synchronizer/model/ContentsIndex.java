//package com.megvii.lbg.synchronizer.model;
//
//import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
//import lombok.Data;
//import org.springframework.data.elasticsearch.annotations.DateFormat;
//import org.springframework.data.elasticsearch.annotations.Document;
//import org.springframework.data.elasticsearch.annotations.Field;
//import org.springframework.data.elasticsearch.annotations.FieldType;
//
//import java.io.Serial;
//import java.io.Serializable;
//import java.time.LocalDateTime;
//
///**
// * 这里添加类的注释【强制】
// *
// * @author zhaomaosong@megvii.com
// * @date 2024-05-09 19:17
// */
//@JsonIgnoreProperties(ignoreUnknown = true)
//@Document(indexName = "contents_index", createIndex = false)
//@Data
//public class ContentsIndex implements Serializable {
//    @Serial
//    private static final long serialVersionUID = 1L;
//
//    @Field(type = FieldType.Integer)
//    private Integer id;
//
//    @Field(type = FieldType.Keyword)
//    private String title;
//
//    @Field(type = FieldType.Keyword)
//    private String intro;
//
//    @Field(type = FieldType.Text)
//    private String content;
//
//    @Field(type = FieldType.Integer)
//    private Integer createId;
//
//    @Field(type = FieldType.Keyword)
//    private String createName;
//
//    @Field(type = FieldType.Date, format = DateFormat.date_hour_minute_second)
//    private LocalDateTime createTime;
//}
