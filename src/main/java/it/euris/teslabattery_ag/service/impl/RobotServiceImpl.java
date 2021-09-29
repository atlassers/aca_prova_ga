package it.euris.teslabattery_ag.service.impl;

import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import it.euris.teslabattery_ag.data.dto.RobotDto;
import it.euris.teslabattery_ag.data.model.Robot;
import it.euris.teslabattery_ag.exception.IdMustBeNullException;
import it.euris.teslabattery_ag.exception.IdMustNotBeNullException;
import it.euris.teslabattery_ag.repository.RobotRepository;
import it.euris.teslabattery_ag.service.RobotService;

@Service
public class RobotServiceImpl implements RobotService{
  
  @Autowired
  private RobotRepository robotRepository;
  
  @Override
  public RobotDto getById(Long id) {
    return robotRepository.findById(id).orElse(new Robot()).toDto();
  }

  @Override
  public List<RobotDto> getAll() {
    return robotRepository.findAll()
        .stream().map(curRobot -> curRobot.toDto())
        .collect(Collectors.toList());
  }

  @Override
  public RobotDto add(RobotDto robotDto) {
    if (robotDto.getId() != null) {
      throw new IdMustBeNullException();
    }
    return robotRepository.save(robotDto.toModel()).toDto();
  }

  @Override
  public RobotDto update(RobotDto robotDto) {
    if (robotDto.getId() != null) {
      throw new IdMustNotBeNullException();
    }
    return robotRepository.save(robotDto.toModel()).toDto();
  }

  @Override
  public Boolean delete(Long id) {
    robotRepository.deleteById(id);
    return robotRepository.findById(id).isEmpty();
  }


}
