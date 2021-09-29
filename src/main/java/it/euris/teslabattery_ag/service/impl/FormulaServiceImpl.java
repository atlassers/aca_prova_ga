package it.euris.teslabattery_ag.service.impl;

import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import it.euris.teslabattery_ag.data.dto.FormulaDto;
import it.euris.teslabattery_ag.data.model.Formula;
import it.euris.teslabattery_ag.exception.IdMustBeNullException;
import it.euris.teslabattery_ag.exception.IdMustNotBeNullException;
import it.euris.teslabattery_ag.repository.FormulaRepository;
import it.euris.teslabattery_ag.service.FormulaService;

@Service
public class FormulaServiceImpl implements FormulaService{
  
  @Autowired
  private FormulaRepository formulaRepository;
  
  @Override
  public FormulaDto getById(Long id) {
    return formulaRepository.findById(id).orElse(new Formula()).toDto();
  }

  @Override
  public List<FormulaDto> getAll() {
    return formulaRepository.findAll()
        .stream().map(curFormula -> curFormula.toDto())
        .collect(Collectors.toList());
  }

  @Override
  public FormulaDto add(FormulaDto formulaDto) {
    if (formulaDto.getId() != null) {
      throw new IdMustBeNullException();
    }
    return formulaRepository.save(formulaDto.toModel()).toDto();
  }

  @Override
  public FormulaDto update(FormulaDto formulaDto) {
    if (formulaDto.getId() != null) {
      throw new IdMustNotBeNullException();
    }
    return formulaRepository.save(formulaDto.toModel()).toDto();
  }

  @Override
  public Boolean delete(Long id) {
    formulaRepository.deleteById(id);
    return formulaRepository.findById(id).isEmpty();
  }


}
