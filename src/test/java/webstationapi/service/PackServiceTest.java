package webstationapi.service;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Test;

import webstationapi.DTO.PackDTO;
import webstationapi.Entity.Course;
import webstationapi.Entity.DayMoment;
import webstationapi.Entity.Pack;
import webstationapi.Entity.Period;
import webstationapi.Repository.BookingRepository;
import webstationapi.Repository.CourseRepository;
import webstationapi.Repository.PackRepository;
import webstationapi.Service.PackService;

public class PackServiceTest {

	@Test
	public void testPackGetAll() {
		PackRepository packRepository = mock(PackRepository.class);
		CourseRepository courseRepository = mock(CourseRepository.class);
		BookingRepository bookingRepository = mock(BookingRepository.class);
		PackService service = new PackService();
		service.setPackRepository(packRepository);
		service.setCourseRepository(courseRepository);
		service.setBookingRepository(bookingRepository);

		Period period = new Period();
		Pack pack1 = new Pack();
		pack1.setPackId(1);
		Map<DayMoment, Integer> tickets1 = new HashMap<DayMoment, Integer>();
		tickets1.put(DayMoment.MORNING, 1);
		pack1.setTickets(tickets1);
		pack1.setMoment(DayMoment.MORNING);
		pack1.setPeriod(period);
		Pack pack2 = new Pack();
		pack2.setPackId(2);
		Map<DayMoment, Integer> tickets2 = new HashMap<DayMoment, Integer>();
		tickets2.put(DayMoment.NOON, 1);
		pack2.setTickets(tickets2);
		pack2.setMoment(DayMoment.NOON);
		pack2.setPeriod(period);
		List<Pack> packs = new ArrayList<Pack>();
		packs.add(pack1);
		packs.add(pack2);
		Course course1 = new Course();
		course1.setMaxSlots(1);
		Course course2 = new Course();
		course2.setMaxSlots(2);
		List<Course> courses = new ArrayList<Course>();
		courses.add(course1);
		courses.add(course2);

		when(packRepository.findAll()).thenReturn(packs);
		when(bookingRepository.countByCourse(course1)).thenReturn(new Long(1));
		when(bookingRepository.countByCourse(course2)).thenReturn(new Long(1));
		when(courseRepository.findByPeriodAndMoment(period, DayMoment.MORNING)).thenReturn(courses);

		List<PackDTO> result = service.getAllPacks();
		assertTrue(result.stream().filter(dto -> dto.getPackId() == 1).findAny().get().getAvailable());
		assertFalse(result.stream().filter(dto -> dto.getPackId() == 2).findAny().get().getAvailable());
	}

}
