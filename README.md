# Elasticsearch 同步器

## 简介

截至2024-05-11，这是一个es最新版本的crud指南。

内置docker-compose，可以直接在docker环境上启动该程序。

版本信息：\
Elasticsearch 8.13.3\
Kibana 8.13.3\
Springboot 3.15\

## 环境初始化
Mysql

数据库初始化脚本:src/main/resources/sql/init.sql

docker-compost可以直接在docker上初始化环境：es-kibana-compose.yml

## 代码

核心代码模板在 OperationLogEsServerImpl.java

### 该代码内部集成了两种springboot操作es的两种方式，

#### 1、通过spring-boot-starter-data-elasticsearch操作，是springboot封装好的一套crud框架

#### 2、通过elasticsearch-java操作，是es8.0+推出的一套Java Api。参考官网 Java Api Client：https://www.elastic.co/guide/en/elasticsearch/client/java-api-client/current/introduction.html

