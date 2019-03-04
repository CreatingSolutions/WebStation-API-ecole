package webstationapi.Entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
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
	
	@Column(name = "MAX_NB_OF_CUSTOMERS")
	private int nbCustomersMax;

	public int getCourseId() { return courseId; }
	public void setCourseId(int courseId) { this.courseId = courseId; }
	public String getDescription() { return description; }
	public void setDescription(String description) { this.description = description; }
	public String getType() { return type; }
	public void setType(String type) { this.type = type; }
	public int getNbCustomersMax() { return nbCustomersMax; }
	public void setNbCustomersMax(int nbCustomersMax) { this.nbCustomersMax = nbCustomersMax; }

}
