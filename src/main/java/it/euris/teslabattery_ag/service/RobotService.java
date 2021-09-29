package it.euris.teslabattery_ag.service;

import java.util.List;
import it.euris.teslabattery_ag.data.dto.RobotDto;

public interface RobotService {
  public RobotDto getById(Long id);

  public List<RobotDto> getAll();

  public RobotDto add(RobotDto dto);

  public RobotDto update(RobotDto dto);

  public Boolean delete(Long id);
}
