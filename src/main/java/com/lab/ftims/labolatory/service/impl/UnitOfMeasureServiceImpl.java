package com.lab.ftims.labolatory.service.impl;

import com.lab.ftims.labolatory.model.UnitOfMeasure;
import com.lab.ftims.labolatory.repository.UnitOfMeasureRepository;
import com.lab.ftims.labolatory.service.UnitOfMeasureService;
import java.util.List;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class UnitOfMeasureServiceImpl implements UnitOfMeasureService {

  private final UnitOfMeasureRepository unitOfMeasureRepository;

  public UnitOfMeasureServiceImpl(UnitOfMeasureRepository unitOfMeasureRepository) {
    this.unitOfMeasureRepository = unitOfMeasureRepository;
  }

  @Override
  public List<UnitOfMeasure> listAllUoms() {
    return unitOfMeasureRepository.findAll();
  }
}
