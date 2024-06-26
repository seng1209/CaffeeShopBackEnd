package com.example.coffeeshop.api.service;

import com.example.coffeeshop.api.entities.Import;
import com.example.coffeeshop.api.entities.Staff;
import com.example.coffeeshop.api.entities.Supplier;
import com.example.coffeeshop.api.mapper.ImportMapper;
import com.example.coffeeshop.api.repository.ImportRepository;
import com.example.coffeeshop.api.web.imports.CreateImportDto;
import com.example.coffeeshop.api.web.imports.ImportDto;
import com.example.coffeeshop.api.web.imports.UpdateImportDto;
import com.example.coffeeshop.api.web.imports.UpdateTotalAmountImportDto;
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
public class ImportServiceImplement implements ImportService{

    private final ImportMapper importMapper;
    private final ImportRepository importRepository;


    @Override
    public void createNewImport(CreateImportDto createImportDto) {
        Import imports = importMapper.fromImportDto(createImportDto);
        imports.setUuid(UUID.randomUUID().toString());
        imports.setImportDate(LocalDate.now());
        imports.setTotalAmount(BigDecimal.valueOf(0));
        imports.setIsDelete(false);
        importRepository.save(imports);
    }

    @Override
    public void updateImportByUuid(String uuid, UpdateImportDto updateImportDto) {
        if (importRepository.existsByUuid(uuid)){
            Import imports = importRepository.findByUuid(uuid).orElseThrow();
            importMapper.fromUpdateImportDto(imports, updateImportDto);

            if (updateImportDto.staffId() != null){
                Staff newStaff = new Staff();
                newStaff.setId(updateImportDto.staffId());
                imports.setStaff(newStaff);
            }

            if (updateImportDto.supplierId() != null){
                Supplier newSupplier = new Supplier();
                newSupplier.setId(updateImportDto.supplierId());
                imports.setSupplier(newSupplier);
            }

            importRepository.save(imports);
            return;
        }

        throw new ResponseStatusException(HttpStatus.NOT_FOUND,
                String.format("Import at UUID : %s is not found...!", uuid));
    }

    @Transactional
    @Override
    public void updateImportById(Long id, UpdateTotalAmountImportDto updateTotalAmountImportDto) {
        if (importRepository.existsById(id)){
            importRepository.editTotalAmount(id, updateTotalAmountImportDto.totalAmount());
            return;
        }

        throw new ResponseStatusException(HttpStatus.NOT_FOUND,
                String.format("Import at ID : %s is not found...!", id));
    }

    @Transactional
    @Override
    public void updateImportIsDeleteByUuid(String uuid) {
        if (importRepository.existsByUuid(uuid)){
            importRepository.editImportIsDeleteByUuid(uuid);
            return;
        }

        throw new ResponseStatusException(HttpStatus.NOT_FOUND,
                String.format("Import at UUID : %s is not found...!", uuid));
    }

    @Override
    public void updateAllImportIsDeleteByImportDate(LocalDate date) {
        if (importRepository.existsByImportDate(date)){
            importRepository.editAllImportIsDeleteByImportDate(date);
            return;
        }

        throw new ResponseStatusException(HttpStatus.NOT_FOUND,
                String.format("Import at Date : %s is not found...!", date));
    }

    @Override
    public void deleteImportByUuid(String uuid) {
        if (importRepository.existsByUuid(uuid)){
            Import imports = importRepository.findByUuid(uuid).orElseThrow();
            importRepository.delete(imports);
            return;
        }

        throw new ResponseStatusException(HttpStatus.NOT_FOUND,
                String.format("Import at UUID : %s is not found...!", uuid));
    }

    @Transactional
    @Override
    public void deleteAllImportByImportDate(LocalDate date) {
        if (importRepository.existsByImportDate(date)){
            importRepository.editAllImportIsDeleteByImportDate(date);
            return;
        }

        throw new ResponseStatusException(HttpStatus.NOT_FOUND,
                String.format("Import at Date : %s is not found...!", date));
    }

    @Override
    public ImportDto findByUuid(String uuid) {
        Import imports = importRepository.findByUuid(uuid).orElseThrow(
                () -> new ResponseStatusException(HttpStatus.NOT_FOUND,
                String.format("Import at Date : %s is not found...!", uuid))
        );
        return importMapper.toImportDto(imports);
    }

    @Override
    public List<ImportDto> findAll() {
//        List<Import> imports = importRepository.selectAll(false);
        List<Import> imports = importRepository.findAllByIsDeleteIsFalse();
        return importMapper.toImportDtoList(imports);
    }

    @Transactional
    @Override
    public List<ImportDto> findAllByImportDate(LocalDate date) {
//        List<Import> imports = importRepository.selectAllByImportDateAndIsDeleteIsFalse(date, false);
        List<Import> imports = importRepository.findAllByImportDateAndIsDeleteIsFalse(date);
        return importMapper.toImportDtoList(imports);
    }

    @Override
    public List<ImportDto> findAllByIsDeleteIsTrue() {
        List<Import> imports = importRepository.findAllByIsDeleteIsTrue();
        return importMapper.toImportDtoList(imports);
    }

    @Override
    public Long findLastImportId() {
        return importRepository.findLastImportId();
    }
}
