package it.euris.teslabattery_ag.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import it.euris.teslabattery_ag.data.model.ProductiveCycle;
import it.euris.teslabattery_ag.repository.Projection.CiclesNumberPerMonthProjection;
import it.euris.teslabattery_ag.repository.Projection.NumberCiclesFaildPerStatus;
import it.euris.teslabattery_ag.repository.Projection.PercentageComplectionProjection;


public interface ProductiveCycleRepository extends JpaRepository<ProductiveCycle, Long> {
  
  @Query(value = "select count(*) ad number, Month(p.end_Date) as Month"
      + " from Productive_Cycle p "
      + " group by Month(p.end_Date)", nativeQuery = true)
  public List <CiclesNumberPerMonthProjection> getAllCicles();
  
  @Query(value = "select count(*) ad number, Month(p.end_Date) as Month "
      + " from Productive_Cycle p "
      + " where isDeleted = true "
      + " group by Month(p.end_Date) ", nativeQuery = true)
  public List <CiclesNumberPerMonthProjection> getAllDeletedCicles();
  
  @Query(value = "select count(*) ad number, Month(p.end_Date) as Month "
      + " from Productive_Cycle p "
      + " where isDeleted = false "
      + " group by Month(p.end_Date) ", nativeQuery = true)
  public List <CiclesNumberPerMonthProjection> getAllCompletedCicles();
  
  @Query(value = "select count(*) as completed, completed*100/t.Tot ad completedPercentage"
    + "from ProductiveCycle\r\n"
    + "cross join (select count(*) as Tot from ProductiveCycle t) ", nativeQuery = true)
  public List<PercentageComplectionProjection> getPercentageCompleted();
  
  @Query(value = "select count(*) as Number, status as ProductiveStatus \r\n"
      + "from ProductiveCicle "
      + "where p.deleted = true"
      + "group by ProductiveStatus ")
  public List<NumberCiclesFaildPerStatus> numberCiclesFaildPerStatus();

}
