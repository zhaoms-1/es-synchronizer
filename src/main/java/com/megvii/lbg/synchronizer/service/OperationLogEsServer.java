package com.megvii.lbg.synchronizer.service;

import com.megvii.lbg.synchronizer.model.OperationLogIndex;

import java.util.List;

/**
 * 这里添加类的注释【强制】
 *
 * @author zhaomaosong@megvii.com
 * @date 2024-05-11 10:07
 */
public interface OperationLogEsServer {
    void indexingDocument(OperationLogIndex operationLogIndex);

    void indexingDocuments(List<OperationLogIndex> operationLogIndexList);

    List<OperationLogIndex> queryByContent(String contentLike);

    void deleteAll();
}
