package VO;

import java.io.Serializable;

public class payrollVO implements Serializable{

	private String username;
	private String salary;
	private String year;
	private String comments;
	private String bonus;
	private int salarypermonth;
	private String month;
	private int totalsalary;
	
	
	
	public int getTotalsalary() {
		return totalsalary;
	}
	public void setTotalsalary(int totalsalary) {
		this.totalsalary = totalsalary;
	}
	public String getMonth() {
		return month;
	}
	public void setMonth(String month) {
		this.month = month;
	}
	public int getSalarypermonth() {
		return salarypermonth;
	}
	public void setSalarypermonth(int salarypermonth) {
		this.salarypermonth = salarypermonth;
	}
	public String getSalary() {
		return salary;
	}
	public void setSalary(String salary) {
		this.salary = salary;
	}
	public String getYear() {
		return year;
	}
	public void setYear(String year) {
		this.year = year;
	}
	public String getBonus() {
		return bonus;
	}
	public void setBonus(String bonus) {
		this.bonus = bonus;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	
	public String getComments() {
		return comments;
	}
	public void setComments(String comments) {
		this.comments = comments;
	}
	
	
	
	
}
