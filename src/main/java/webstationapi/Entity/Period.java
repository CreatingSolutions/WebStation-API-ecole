package webstationapi.Entity;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Period {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "PERIOD_ID")
	private int periodId;
	
	@Column(name = "MOMENT")
	private DayMoment moment;
	
	@Column(name = "START_DATE")
	private Date startDate;
	
	@Column(name = "END_DATE")
	private Date endDate;
	
	@Column(name = "PRICE")
	private double price;
	
	public int getPeriodId() { return periodId; }
	public void setPeriodId(int periodId) { this.periodId = periodId; }
	public DayMoment getMoment() { return moment; }
	public void setMoment(DayMoment moment) { this.moment = moment; }
	public Date getStartDate() { return startDate; }
	public void setStartDate(Date startDate) { this.startDate = startDate; }
	public Date getEndDate() { return endDate; }
	public void setEndDate(Date endDate) { this.endDate = endDate; }
	public double getPrice() { return price; }
	public void setPrice(double price) { this.price = price; }
	
}
