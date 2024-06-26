package com.example.coffeeshop.api.service;

import com.example.coffeeshop.api.web.import_detail.CreateImportDetail;
import com.example.coffeeshop.api.web.import_detail.ImportDetailDto;
import com.example.coffeeshop.api.web.import_detail.UpdateImportDetail;

import java.math.BigDecimal;
import java.util.List;

public interface ImportDetailService {

    // create import_detail
    void createNewImportDetail(CreateImportDetail createImportDetail);

    // update import_detail by uuid
    void updateByUuid(String uuid, UpdateImportDetail updateImportDetail);

    // delete import_detail by uuid
    void deleteByUuid(String uuid);

    // select import_detail by uuid
    ImportDetailDto findByUuid(String uuid);

    // select all import detail
    List<ImportDetailDto> findAll();

    // get total_amount
    BigDecimal getTotalAmount(Long importsId);

    // get all import_detail by import_id
    List<ImportDetailDto> findAllImportDetailByImportId(Long importId);

    // get all import_detail by import uuid
    List<ImportDetailDto> findAllImportDetailByImportUuid(String uuid);

}