package webstationapi.DTO;

import java.sql.Date;

import webstationapi.Entity.Period;
import webstationapi.Entity.Teacher;

public class CourseDTO {

	private int courseId;
	private String description;
	private String type;
	private int level;
	private int nbCustomersMax;
	private Date date;
	private int startingHour;
	private int endingHour;
	private Period period;
	private Teacher teacher;
	
	public int getCourseId() { return courseId; }
	public void setCourseId(int courseId) { this.courseId = courseId; }
	public String getDescription() { return description; }
	public void setDescription(String description) { this.description = description; }
	public String getType() { return type; }
	public void setType(String type) { this.type = type; }
	public int getLevel() { return level; }
	public void setLevel(int level) { this.level = level; }
	public int getNbCustomersMax() { return nbCustomersMax; }
	public void setNbCustomersMax(int nbCustomersMax) { this.nbCustomersMax = nbCustomersMax; }
	public Date getDate() { return date; }
	public void setDate(Date date) { this.date = date; }
	public int getStartingHour() { return startingHour; }
	public void setStartingHour(int startingHour) { this.startingHour = startingHour; }
	public int getEndingHour() { return endingHour; }
	public void setEndingHour(int endingHour) { this.endingHour = endingHour; }
	public Period getPeriod() { return period; }
	public void setPeriod(Period period) { this.period = period; }
	public Teacher getTeacher() { return teacher; }
	public void setTeacher(Teacher teacher) { this.teacher = teacher; }
	
}
