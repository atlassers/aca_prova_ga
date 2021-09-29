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
import it.euris.teslabattery_ag.data.dto.AssemblyLineDto;
import it.euris.teslabattery_ag.service.AssemblyLineService;

@RestController
@RequestMapping("/assembly-lines")
public class AssemblyLineController {
  @Autowired
  AssemblyLineService assemblyLineService;

  @GetMapping("/v1")
  public List<AssemblyLineDto> getAll() {
      return assemblyLineService.getAll();
  }

  @GetMapping("/v1/{id}")
  public AssemblyLineDto getById(@PathVariable("id") Long id) {
      return assemblyLineService.getById(id);
  }

  @PostMapping("/v1")
  public AssemblyLineDto insert(@RequestBody AssemblyLineDto dto) {
      return assemblyLineService.add(dto);
  }

  @PutMapping("/v1")
  public AssemblyLineDto update(@RequestBody AssemblyLineDto dto) {
      return assemblyLineService.update(dto);
  }
  
  @DeleteMapping("/v1/{id}")
  public Boolean delete(@PathVariable("id") Long id) {
      return assemblyLineService.delete(id);
  }

}
