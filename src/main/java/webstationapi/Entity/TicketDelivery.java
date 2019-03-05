package webstationapi.Entity;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class TicketDelivery {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "TICKET_DELIVERY_ID")
	private int ticketDeliveryId;
	
	@Column(name = "USER_ID")
	private int userId;
	
	@Column(name = "DAY_MOMENT_ID")
	private DayMoment moment;
	
	@Column(name = "DATE")
	private Date date;
	
	public int getTicketDeliveryId() { return ticketDeliveryId; }
	public void setTicketDeliveryId(int ticketDeliveryId) { this.ticketDeliveryId = ticketDeliveryId; }
	public int getUserId() { return userId; }
	public void setUserId(int userId) { this.userId = userId; }
	public DayMoment getMoment() { return moment; }
	public void setMoment(DayMoment moment) { this.moment = moment; }
	public Date getDate() { return date; }
	public void setDate(Date date) { this.date = date; }
	
}
