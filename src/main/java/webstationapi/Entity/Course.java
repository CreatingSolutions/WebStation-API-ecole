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

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "ECOLE_COURSE")
@Getter
@Setter
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
	
	@Column(name = "MAX_NB_OF_CUSTOMERS")
	private int nbCustomersMax;
	
	@Column(name = "DATE")
	private Date date;
	
	@Column(name = "STARTING_HOUR")
	private int startingHour;
	
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
	public int getNbCustomersMax() { return nbCustomersMax; }
	public void setNbCustomersMax(int nbCustomersMax) { this.nbCustomersMax = nbCustomersMax; }
	public Date getDate() { return date; }
	public void setDate(Date date) { this.date = date; }
	public int getStartingHour() { return startingHour; }
	public void setStartingHour(int startingHour) { this.startingHour = startingHour; }
	public Teacher getTeacher() { return teacher; }
	public void setTeacher(Teacher teacher) { this.teacher = teacher; }

}
