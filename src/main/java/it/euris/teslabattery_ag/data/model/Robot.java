package it.euris.teslabattery_ag.data.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import it.euris.teslabattery_ag.data.archetype.Model;
import it.euris.teslabattery_ag.data.dto.RobotDto;
import it.euris.teslabattery_ag.data.enums.RobotTask;
import it.euris.teslabattery_ag.utils.UT;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "robot")
@Entity
public class Robot implements Model {

  @Id
  @Column(name = "id")
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  private Integer order;
  private RobotTask task;

  @ManyToOne
  @JoinColumn(name = "assemblyLine_id", nullable = false)
  private AssemblyLine assemblyLine;

  @Override
  public RobotDto toDto() {

    return RobotDto.builder().id(id == null ? null : id.toString()).order(order.toString())
        .task(UT.getRobotTask(task)).build();
  }
}
