package com.example.coffeeshop.api.service;

import com.example.coffeeshop.api.entities.Import;
import com.example.coffeeshop.api.entities.ImportDetail;
import com.example.coffeeshop.api.entities.Item;
import com.example.coffeeshop.api.mapper.ImportDetailMapper;
import com.example.coffeeshop.api.repository.ImportDetailRepository;
import com.example.coffeeshop.api.repository.ImportRepository;
import com.example.coffeeshop.api.web.import_detail.CreateImportDetail;
import com.example.coffeeshop.api.web.import_detail.ImportDetailDto;
import com.example.coffeeshop.api.web.import_detail.UpdateImportDetail;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;

import java.math.BigDecimal;
import java.util.List;
import java.util.UUID;

@Service
@AllArgsConstructor
public class ImportDetailServiceImplement implements ImportDetailService{

    private final ImportDetailMapper importDetailMapper;
    private final ImportDetailRepository importDetailRepository;

//    @Transactional
    @Override
    public void createNewImportDetail(CreateImportDetail createImportDetail) {
        ImportDetail importDetail = importDetailMapper.fromImportDetailDto(createImportDetail);
        importDetail.setUuid(UUID.randomUUID().toString());
        /*******************************/
//        Integer importQty = createImportDetail.importQty();
//        BigDecimal unitPrice = createImportDetail.unitPrice();
//        BigDecimal amount = unitPrice.multiply(BigDecimal.valueOf(importQty));
        /*******************************/
        importDetail.setAmount(createImportDetail.unitPrice().multiply(BigDecimal.valueOf(createImportDetail.importQty())));
//        System.out.println(importDetail.getAmount());
//        importRepository.editTotalAmount(createImportDetail.importId(), importDetail.getAmount());
        importDetailRepository.save(importDetail);
    }

    @Override
    public void updateByUuid(String uuid, UpdateImportDetail updateImportDetail) {
        if (importDetailRepository.existsByUuid(uuid)){
            ImportDetail importDetail = importDetailRepository.findByUuid(uuid).orElseThrow();
            importDetailMapper.fromUpdateImportDetailDto(importDetail, updateImportDetail);

            if (updateImportDetail.importId() != null){
                Import newImport = new Import();
                newImport.setId(updateImportDetail.importId());
                importDetail.setImports(newImport);
            }

            if (updateImportDetail.itemId() != null){
                Item newItem = new Item();
                newItem.setId(updateImportDetail.itemId());
                importDetail.setItems(newItem);
            }

            importDetail.setAmount(updateImportDetail.unitPrice().multiply(BigDecimal.valueOf(updateImportDetail.importQty())));

            importDetailRepository.save(importDetail);
            return;
        }

        throw new ResponseStatusException(HttpStatus.NOT_FOUND,
                String.format("Import Detail at UUID : %s is not found...!", uuid));
    }

    @Override
    public void deleteByUuid(String uuid) {
        ImportDetail importDetail  = importDetailRepository.findByUuid(uuid).orElseThrow(
                () -> new ResponseStatusException(HttpStatus.NOT_FOUND,
                String.format("Import Detail at UUID : %s is not found...!", uuid))
        );
        importDetailRepository.delete(importDetail);
    }

    @Override
    public ImportDetailDto findByUuid(String uuid) {
        ImportDetail importDetail = importDetailRepository.findByUuid(uuid).orElseThrow(
                () -> new ResponseStatusException(HttpStatus.NOT_FOUND,
                String.format("Import Detail at UUID : %s is not found...!", uuid))
        );
        return importDetailMapper.toImportDetailDto(importDetail);
    }

    @Override
    public List<ImportDetailDto> findAll() {
        List<ImportDetail> importDetails = importDetailRepository.findAll();
        return importDetailMapper.toImportDetailDtoList(importDetails);
    }

    @Override
    public BigDecimal getTotalAmount(Long importsId) {
        return importDetailRepository.totalAmount(importsId);
    }

    @Override
    public List<ImportDetailDto> findAllImportDetailByImportId(Long importId) {
        List<ImportDetail> importDetails = importDetailRepository.selectAllImportDetailByImportId(importId);
        return importDetailMapper.toImportDetailDtoList(importDetails);
    }

    @Override
    public List<ImportDetailDto> findAllImportDetailByImportUuid(String uuid) {
        List<ImportDetail> importDetails = importDetailRepository.selectAllImportDetailByImportUuid(uuid);
        return importDetailMapper.toImportDetailDtoList(importDetails);
    }
}
