package it.euris.teslabattery_ag.service;

import java.util.List;
import it.euris.teslabattery_ag.data.dto.FormulaDto;

public interface FormulaService {
  public FormulaDto getById(Long id);

  public List<FormulaDto> getAll();

  public FormulaDto add(FormulaDto dto);

  public FormulaDto update(FormulaDto dto);

  public Boolean delete(Long id);
}
