package it.euris.teslabattery_ag.data.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import it.euris.teslabattery_ag.data.archetype.Dto;
import it.euris.teslabattery_ag.data.model.AssemblyLine;
import it.euris.teslabattery_ag.data.model.ProductiveCycle;
import it.euris.teslabattery_ag.utils.UT;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class ProductiveCycleDto implements Dto {

  private String id;
  private String assemblyLineId;
  private String startDate;
  private String endDate;
  private String statusDate;
  private String status;
  private Boolean isDeleted;

  @JsonIgnore
  private String supervisor;

  @Override
  public ProductiveCycle toModel() {
    return ProductiveCycle.builder().id(UT.toLong(id))
        .assemblyLineId(new AssemblyLine(assemblyLineId)).startDate(UT.toInstant(startDate))
        .endDate(UT.toInstant(endDate)).statusDate(UT.toInstant(endDate))
        .status(UT.getProductionStatus(status)).isDeleted(isDeleted).build();
  }

}
