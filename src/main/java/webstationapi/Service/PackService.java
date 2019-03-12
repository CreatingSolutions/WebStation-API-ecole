package webstationapi.Service;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import webstationapi.DTO.PackDTO;
import webstationapi.Repository.BookingRepository;
import webstationapi.Repository.CourseRepository;
import webstationapi.Repository.PackRepository;

@Service
public class PackService {

	@Autowired
	private PackRepository packRepository;
	
	@Autowired
	private CourseRepository courseRepository;
	
	@Autowired
	private BookingRepository bookingRepository;
	
	public List<PackDTO> getAllPacks() {
		//TODO : Gérer l'appel au CourseRepository le stream pour ne faire qu'un seul appel
		return StreamSupport.stream(packRepository.findAll().spliterator(), false).map(pack -> {
			PackDTO dto = new PackDTO(pack);
			Long availableSlots = courseRepository.findByPeriodAndMoment(pack.getPeriod(), pack.getMoment()).stream().map(course -> {
				return (course.getMaxSlots() - bookingRepository.countByCourse(course));
			}).reduce((s1, s2) -> (s1+s2)).orElse(new Long(0));
			dto.setAvailable(pack.getTickets().values().stream().reduce((v1, v2) -> v1+v2).orElse(0) <= availableSlots);
			return dto;
		}).collect(Collectors.toList());
	}
	
}
