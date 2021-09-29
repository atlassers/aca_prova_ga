package it.euris.teslabattery_ag.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import it.euris.teslabattery_ag.data.model.ProductiveCycle;

public interface ProductiveCycleRepository extends JpaRepository<ProductiveCycle, Long> {

}
