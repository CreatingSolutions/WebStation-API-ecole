package webstationapi.Controller;

import java.sql.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import webstationapi.Utils;
import webstationapi.Entity.DayMoment;
import webstationapi.Entity.Period;
import webstationapi.Service.PeriodService;

@RestController
@RequestMapping(path = "/period")
@EnableAutoConfiguration
public class PeriodController {

	@Autowired
	private PeriodService periodService;

	@GetMapping("/id/{id}")
	public Period getPeriodById(@PathVariable(value="id") String id) {
		int periodId = Utils.getIdFromString(id);
		return periodService.getPeriodById(periodId).orElseThrow(InternalError::new);
	}
	
	@GetMapping("/")
	public Period getPeriodById(@RequestParam DayMoment moment, @RequestParam Date startDate, 
			@RequestParam Date endDate) {
		return periodService.getPeriodByMomentAndByDates(moment, startDate, endDate).orElseThrow(InternalError::new);
	}

	@PostMapping(path = "/create")
	public void createPeriod(@RequestParam DayMoment moment, @RequestParam Date startDate, 
			@RequestParam Date endDate, @RequestParam double price) {
		Period period = new Period();
		period.setMoment(moment);
		period.setStartDate(startDate);
		period.setEndDate(endDate);
		period.setPrice(price);
		periodService.createPeriod(period);
	}
	
	@PatchMapping(path = "/update/{id}")
	public void updatePeriod(@PathVariable(value="id") String periodId, @RequestParam DayMoment moment, 
			@RequestParam Date startDate, @RequestParam Date endDate, @RequestParam double price) {
		periodService.updatePeriod(Utils.getIdFromString(periodId), moment, startDate, endDate, price);
	}
	
	@DeleteMapping(path = "/delete/{id}")
	public void deletePeriod(@PathVariable(value="id") String id) {
		int periodId = Utils.getIdFromString(id);
		periodService.deletePeriod(periodId);
	}

}
