package it.euris.teslabattery_ag.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import it.euris.teslabattery_ag.data.dto.FormulaDto;
import it.euris.teslabattery_ag.service.FormulaService;
@RestController
@RequestMapping("/formulas")
public class FormulaController {
  @Autowired
  FormulaService formulaService;

  @GetMapping("/v1")
  public List<FormulaDto> getAll() {
      return formulaService.getAll();
  }

  @GetMapping("/v1/{id}")
  public FormulaDto getById(@PathVariable("id") Long id) {
      return formulaService.getById(id);
  }

  @PostMapping("/v1")
  public FormulaDto insert(@RequestBody FormulaDto dto) {
      return formulaService.add(dto);
  }

  @PutMapping("/v1")
  public FormulaDto update(@RequestBody FormulaDto dto) {
      return formulaService.update(dto);
  }
  
  @DeleteMapping("/v1/{id}")
  public Boolean delete(@PathVariable("id") Long id) {
      return formulaService.delete(id);
  }

}
