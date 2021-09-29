package it.euris.teslabattery_ag.data.dto;

import java.util.List;
import java.util.stream.Collectors;
import com.fasterxml.jackson.annotation.JsonIgnore;
import it.euris.teslabattery_ag.data.archetype.Dto;
import it.euris.teslabattery_ag.data.model.Formula;
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
public class FormulaDto implements Dto {

  private String id;
  private String assemblyLine;
  private String productiveCycle;

  @JsonIgnore
  private List<ComponentFormulaDto> componentFormulas;

  @Override
  public Formula toModel() {
    Formula formula = Formula.builder().id(UT.toLong(id))
        .productiveCycle(new ProductiveCycle(productiveCycle)).build();
    if (this.getComponentFormulas() != null) {
      formula.getComponentFormulas().addAll(this.getComponentFormulas().stream()
          .map(ComponentFormulaDto::toModel).collect(Collectors.toList()));
    }
    return formula;
  }

}
