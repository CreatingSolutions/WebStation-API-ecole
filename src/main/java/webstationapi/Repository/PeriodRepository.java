package webstationapi.Repository;

import org.springframework.data.repository.CrudRepository;

import webstationapi.Entity.Period;

public interface PeriodRepository extends CrudRepository<Period, Integer> {
		
}
