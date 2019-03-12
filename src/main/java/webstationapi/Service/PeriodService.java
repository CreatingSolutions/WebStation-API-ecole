package webstationapi.Service;

import java.sql.Date;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import webstationapi.Entity.Period;
import webstationapi.Repository.PeriodRepository;

@Service
public class PeriodService {
	
	@Autowired
	private PeriodRepository periodRepository;

	public Optional<Period> getPeriodById(int periodId) {
		return periodRepository.findById(periodId);
	}
	
	public void createPeriod(Period period) {
		periodRepository.save(period);
	}
	
	public void updatePeriod(int periodId, Date startDate, Date endDate) {
		Period period = periodRepository.findById(periodId).orElseThrow(InternalError::new);
		period.setStartDate(startDate);
		period.setEndDate(endDate);
		periodRepository.save(period);
	}
	
	public void deletePeriod(int periodId) {
		periodRepository.deleteById(periodId);
	}
	
}
