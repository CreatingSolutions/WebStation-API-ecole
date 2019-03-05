package webstationapi.Service;

import java.sql.Date;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import webstationapi.Entity.DayMoment;
import webstationapi.Entity.Period;
import webstationapi.Repository.PeriodRepository;

@Service
public class PeriodService {
	
	@Autowired
	private PeriodRepository periodRepository;

	public Optional<Period> getPeriodById(int periodId) {
		return periodRepository.findById(periodId);
	}
	
	public Optional<Period> getPeriodByMomentAndByDates(DayMoment moment, Date startDate, Date endDate) {
		return periodRepository.findByMomentAndStartDateBeforeAndEndDateAfter(moment, startDate, endDate);
	}
	
	public void createPeriod(Period period) {
		periodRepository.save(period);
	}
	
	public void updatePeriod(int periodId, DayMoment moment, Date startDate, Date endDate, double price) {
		Period period = periodRepository.findById(periodId).orElseThrow(InternalError::new);
		period.setMoment(moment);
		period.setStartDate(startDate);
		period.setEndDate(endDate);
		period.setPrice(price);
		periodRepository.save(period);
	}
	
	public void deletePeriod(int periodId) {
		periodRepository.deleteById(periodId);
	}
	
}
