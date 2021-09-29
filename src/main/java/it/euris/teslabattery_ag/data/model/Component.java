package it.euris.teslabattery_ag.data.model;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import it.euris.teslabattery_ag.data.archetype.Model;
import it.euris.teslabattery_ag.data.dto.ComponentDto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "component")
@Entity
public class Component implements Model {

  @Id
  @Column(name = "id")
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @OneToMany(mappedBy = "component")
  @Builder.Default
  private List<ComponentFormula> componentFormulas = new ArrayList<ComponentFormula>();

  private String name;
  private Boolean isDangerous;


  public Component(String componentId) {
    if (componentId != null) {
      this.id = Long.parseLong(componentId);
    }
  }

  @Override
  public ComponentDto toDto() {
    return ComponentDto.builder().id(id == null ? null : id.toString()).name(name)
        .isDangerous(isDangerous.toString()).build();
  }



}
