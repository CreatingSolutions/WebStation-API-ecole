package webstationapi.Repository;

import java.sql.Date;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import webstationapi.Entity.DayMoment;
import webstationapi.Entity.Period;

public interface PeriodRepository extends CrudRepository<Period, Integer> {
	
	public Optional<Period> findByMomentAndStartDateBeforeAndEndDateAfter(DayMoment moment, Date startDate, Date endDate);
	
}
