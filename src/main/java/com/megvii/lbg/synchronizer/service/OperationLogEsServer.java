package com.megvii.lbg.synchronizer.service;

import com.megvii.lbg.synchronizer.model.OperationLogIndex;

import java.util.List;


public interface OperationLogEsServer {
    void indexingDocument(OperationLogIndex operationLogIndex);

    void indexingDocuments(List<OperationLogIndex> operationLogIndexList);

    List<OperationLogIndex> queryByContent(String contentLike);

    void deleteAll();
}
