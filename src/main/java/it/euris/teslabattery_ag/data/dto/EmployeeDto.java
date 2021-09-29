package it.euris.teslabattery_ag.data.dto;

import java.util.List;
import java.util.stream.Collectors;
import com.fasterxml.jackson.annotation.JsonIgnore;
import it.euris.teslabattery_ag.data.archetype.Dto;
import it.euris.teslabattery_ag.data.model.Employee;
import it.euris.teslabattery_ag.utils.UT;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class EmployeeDto implements Dto {
  private String id;
  private String name;
  private String role;

  @JsonIgnore
  private List<ProductiveCycleDto> productiveCycles;

  @Override
  public Employee toModel() {
    Employee employee = Employee.builder().id(UT.toLong(id)).name(name)
        .role(UT.getEmployeeRole(role)).build();
    if (this.getProductiveCycles() != null) {
      employee.getProductiveCycles().addAll(this.getProductiveCycles().stream()
          .map(ProductiveCycleDto::toModel).collect(Collectors.toList()));
    }
    return employee;
  }

}
