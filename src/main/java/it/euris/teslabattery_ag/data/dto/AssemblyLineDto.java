package it.euris.teslabattery_ag.data.dto;

import java.util.List;
import java.util.stream.Collectors;
import com.fasterxml.jackson.annotation.JsonIgnore;
import it.euris.teslabattery_ag.data.archetype.Dto;
import it.euris.teslabattery_ag.data.model.AssemblyLine;
import it.euris.teslabattery_ag.utils.UT;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class AssemblyLineDto implements Dto {
  private String id;
  private String name;
  private String maxLength;
  @JsonIgnore
  private List<RobotDto> robots;

  @Override
  public AssemblyLine toModel() {

    AssemblyLine al = AssemblyLine.builder().id(UT.toLong(id)).name(name)
        .maxLength(UT.toDouble(maxLength)).build();
    if (this.getRobots() != null) {
      al.getRobots()
          .addAll(this.getRobots().stream().map(RobotDto::toModel).collect(Collectors.toList()));
    }
    return al;
  }

}
