package webstationapi.Entity;

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
	@JoinColumn(name = "COURSE_ID")
	private Course course;
	
	public int getBookingId() { return bookingId; }
	public void setBookingId(int bookingId) { this.bookingId = bookingId; }
	public int getUserId() { return userId; }
	public void setUserId(int userId) { this.userId = userId; }
	public Course getCourse() { return course; }
	public void setCourse(Course course) { this.course = course; }
	
}
