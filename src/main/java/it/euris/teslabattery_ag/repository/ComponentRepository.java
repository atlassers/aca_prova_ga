package it.euris.teslabattery_ag.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import it.euris.teslabattery_ag.data.model.Component;


public interface ComponentRepository extends JpaRepository<Component, Long> {

}
