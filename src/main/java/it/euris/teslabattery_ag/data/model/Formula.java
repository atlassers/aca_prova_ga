package it.euris.teslabattery_ag.data.model;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import it.euris.teslabattery_ag.data.archetype.Model;
import it.euris.teslabattery_ag.data.dto.FormulaDto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "formula")
@Entity
public class Formula implements Model {

  @Id
  @Column(name = "id")
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  private AssemblyLine assemblyLine;

  @OneToMany(mappedBy = "formula")
  @Builder.Default
  private List<ComponentFormula> componentFormulas = new ArrayList<ComponentFormula>();

  @JoinColumn(name = "productiveCycle_id", nullable = false)
  private ProductiveCycle productiveCycle;


  public Formula(String formulaId) {
    if (formulaId != null) {
      this.id = Long.parseLong(formulaId);
    }
  }

  @Override
  public FormulaDto toDto() {
    return FormulaDto.builder().id(id == null ? null : id.toString())
        .productiveCycle(productiveCycle.getId().toString()).build();
  }


}
