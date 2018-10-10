package webstationapi.Entity;

import java.sql.Date;

public class Booking {

	private int bookingId;
	private int userId;
	private Teacher teacher;
	private Course course;
	private int price;
	private Date date;
	private int startingHour;
	private int level;
	
	public int getBookingId() { return bookingId; }
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
