package it.euris.teslabattery_ag.repository.Projection;

import it.euris.teslabattery_ag.data.enums.ProductionStatus;

public interface NumberCiclesFaildPerStatus {
    
  Long getNumber();
  ProductionStatus getStatus();
  
}
