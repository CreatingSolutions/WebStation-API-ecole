package ecole.model;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity
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

	public int getBookingId() {
		return bookingId;
	}

	public void setBookingId(int bookingId) { this.bookingId = bookingId; }
	public int getUserId() { return userId; }
	public void setUserId(int userId) { this.userId = userId; }
	public Teacher getTeacher() { return teacher; }
	public void setTeacher(Teacher teacher) { this.teacher = teacher; }
	public Course getCourse() { return course; }
	public void setCourse(Course course) { this.course = course; }
	public int getPrice() { return price; }
	public void setPrice(int price) { this.price = price; }
	public Date getDate() { return date; }
	public void setDate(Date date) { this.date = date; }
	public int getStartingHour() { return startingHour; }
	public void setStartingHour(int startingHour) { this.startingHour = startingHour; }
	public int getLevel() { return level; }
	public void setLevel(int level) { this.level = level; }

}
