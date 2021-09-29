package it.euris.teslabattery_ag.service.impl;

import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import it.euris.teslabattery_ag.data.dto.ProductiveCycleDto;
import it.euris.teslabattery_ag.data.model.ProductiveCycle;
import it.euris.teslabattery_ag.exception.IdMustBeNullException;
import it.euris.teslabattery_ag.exception.IdMustNotBeNullException;
import it.euris.teslabattery_ag.repository.ProductiveCycleRepository;
import it.euris.teslabattery_ag.service.ProductiveCycleService;

@Service
public class ProductiveCycleServiceImpl implements ProductiveCycleService{
  
  @Autowired
  private ProductiveCycleRepository productiveCycleRepository;
  
  @Override
  public ProductiveCycleDto getById(Long id) {
    return productiveCycleRepository.findById(id).orElse(new ProductiveCycle()).toDto();
  }

  @Override
  public List<ProductiveCycleDto> getAll() {
    return productiveCycleRepository.findAll()
        .stream().map(curProductiveCycle -> curProductiveCycle.toDto())
        .collect(Collectors.toList());
  }

  @Override
  public ProductiveCycleDto add(ProductiveCycleDto productiveCycleDto) {
    if (productiveCycleDto.getId() != null) {
      throw new IdMustBeNullException();
    }
    return productiveCycleRepository.save(productiveCycleDto.toModel()).toDto();
  }

  @Override
  public ProductiveCycleDto update(ProductiveCycleDto productiveCycleDto) {
    if (productiveCycleDto.getId() != null) {
      throw new IdMustNotBeNullException();
    }
    return productiveCycleRepository.save(productiveCycleDto.toModel()).toDto();
  }

  @Override
  public Boolean delete(Long id) {
    productiveCycleRepository.deleteById(id);
    return productiveCycleRepository.findById(id).isEmpty();
  }


}
