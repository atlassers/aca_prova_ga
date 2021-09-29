package it.euris.teslabattery_ag.data.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import it.euris.teslabattery_ag.data.archetype.Dto;
import it.euris.teslabattery_ag.data.model.Robot;
import it.euris.teslabattery_ag.utils.UT;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class RobotDto implements Dto  {
  
  private String id;
  private String order;
  private String task;
  
  @JsonIgnore
  private AssemblyLineDto assemblyLine;

  @Override
  public Robot toModel() {
    return Robot.builder().id(UT.toLong(id)).order(UT.toInteger(id)).task(UT.getRobotTask(task)).build();
  }

}
