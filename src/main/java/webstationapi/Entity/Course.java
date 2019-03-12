package webstationapi.Entity;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "ECOLE_COURSE")
public class Course {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID")
	private int courseId;
	
	@Column(name = "DESCRIPTION")
	private String description;

	@Column(name = "TYPE")
	private String type;
	
	@Column(name = "LEVEL")
	private int level;
	
	@Column(name = "MAX_SLOTS")
	private int maxSlots;
	
	@Column(name = "DATE")
	private Date date;
	
	@Column(name = "STARTING_HOUR")
	private int startingHour;
	
	@Column(name = "ENDING_HOUR")
	private int endingHour;
	
	@ManyToOne
	@JoinColumn(name = "PERIOD_ID")
	private Period period;
	
	@ManyToOne
	@JoinColumn(name = "TEACHER_ID")
	private Teacher teacher;

	public int getCourseId() { return courseId; }
	public void setCourseId(int courseId) { this.courseId = courseId; }
	public String getDescription() { return description; }
	public void setDescription(String description) { this.description = description; }
	public String getType() { return type; }
	public void setType(String type) { this.type = type; }
	public int getLevel() { return level; }
	public void setLevel(int level) { this.level = level; }
	public int getMaxSlots() { return maxSlots; }
	public void setMaxSlots(int maxSlots) { this.maxSlots = maxSlots; }
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
