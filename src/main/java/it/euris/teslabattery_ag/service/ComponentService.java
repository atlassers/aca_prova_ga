package it.euris.teslabattery_ag.service;

import java.util.List;
import it.euris.teslabattery_ag.data.dto.ComponentDto;

public interface ComponentService {
  public ComponentDto getById(Long id);

  public List<ComponentDto> getAll();

  public ComponentDto add(ComponentDto dto);

  public ComponentDto update(ComponentDto dto);

  public Boolean delete(Long id);
}
