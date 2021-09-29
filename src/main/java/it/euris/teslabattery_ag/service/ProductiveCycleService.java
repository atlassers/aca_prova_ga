package it.euris.teslabattery_ag.service;

import java.util.List;
import it.euris.teslabattery_ag.data.dto.ProductiveCycleDto;

public interface ProductiveCycleService {
  public ProductiveCycleDto getById(Long id);

  public List<ProductiveCycleDto> getAll();

  public ProductiveCycleDto add(ProductiveCycleDto dto);

  public ProductiveCycleDto update(ProductiveCycleDto dto);

  public Boolean delete(Long id);
}
