package webstationapi.Entity;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "ECOLE_BOOKING")
@Getter
@Setter
public class Booking {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "BOOKING_ID")
	private int bookingId;
	
	@Column(name = "USER_ID")
	private int userId;
	
	@OneToOne
	@JoinColumn(name = "TEACHER_ID")
	private Teacher teacher;
	
	@OneToOne
	@JoinColumn(name = "COURSE_ID")
	private Course course;
	
	@Column(name = "PRICE")
	private int price;
	
	@Column(name = "DATE")
	private Date date;
	
	@Column(name = "STARTING_HOUR")
	private int startingHour;
	
	@Column(name = "LEVEL")
	private int level;
	
	public int getBookingId() { return bookingId; }
	public Course getCourse() { return course; }

}
