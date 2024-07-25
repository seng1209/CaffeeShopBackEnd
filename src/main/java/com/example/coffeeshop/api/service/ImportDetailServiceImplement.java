package com.example.coffeeshop.api.service;

import com.example.coffeeshop.api.entities.Import;
import com.example.coffeeshop.api.entities.ImportDetail;
import com.example.coffeeshop.api.entities.Item;
import com.example.coffeeshop.api.mapper.ImportDetailMapper;
import com.example.coffeeshop.api.repository.ImportDetailRepository;
import com.example.coffeeshop.api.repository.ImportRepository;
import com.example.coffeeshop.api.web.import_detail.CreateImportDetail;
import com.example.coffeeshop.api.web.import_detail.ImportDetailDto;
import com.example.coffeeshop.api.web.import_detail.ImportReportDto;
import com.example.coffeeshop.api.web.import_detail.UpdateImportDetail;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;

import java.math.BigDecimal;
import java.time.LocalDate;
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
        importDetail.setAmount(createImportDetail.unitPrice()
                .multiply(BigDecimal.valueOf(createImportDetail.importQty())));
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
    public BigDecimal getTotalAmountByImportDate(LocalDate date) {
        return importDetailRepository.getTotalAmountByImportDate(date);
    }

    @Override
    public BigDecimal getTotalAmountBetweenImportDate(LocalDate firstDate, LocalDate lastDate) {
        return importDetailRepository.getTotalAmountBetweenImportDate(firstDate, lastDate);
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

    @Override
    public List<ImportDetailDto> findAllImportDetailByImportDate(LocalDate date) {
        List<ImportDetail> importDetails = importDetailRepository.selectAllImportDetailByImportDate(date);
        return importDetailMapper.toImportDetailDtoList(importDetails);
    }

    @Override
    public List<ImportDetailDto> findAllImportDetailByBetweenImportDate(LocalDate firstDate, LocalDate lastDate) {
        List<ImportDetail> importDetails = importDetailRepository.selectAllImportDetailBetweenImportDate(firstDate, lastDate);
        return importDetailMapper.toImportDetailDtoList(importDetails);
    }

}
