package VO;

import java.io.Serializable;
import java.util.Date;

public class leaveRequestVO implements Serializable {

	private int leaveId;
	private String leaveType;
	private String leaveDescription;
	private String startdate;
	private int takenleave;
	private int numberofdays;
	
	
	
	public int getNumberofdays() {
		return numberofdays;
	}
	public void setNumberofdays(int numberofdays) {
		this.numberofdays = numberofdays;
	}
	public String getStartdate() {
		return startdate;
	}
	public void setStartdate(String startdate) {
		this.startdate = startdate;
	}
	
	public int getTakenleave() {
		return takenleave;
	}
	public void setTakenleave(int takenleave) {
		this.takenleave = takenleave;
	}
	
	private String status;
	
	
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public int getLeaveId() {
		return leaveId;
	}
	public void setLeaveId(int leaveId) {
		this.leaveId = leaveId;
	}
	public String getLeaveType() {
		return leaveType;
	}
	public void setLeaveType(String leaveType) {
		this.leaveType = leaveType;
	}
	public String getLeaveDescription() {
		return leaveDescription;
	}
	public void setLeaveDescription(String leaveDescription) {
		this.leaveDescription = leaveDescription;
	}
		
	
	
}
