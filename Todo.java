package com.myonlinebank.todo;

import java.util.Date;

import javax.validation.constraints.Size;

public class Todo {
	private int id;
	private String user;
	

	private String desc;
	
	private Date targetDate;
	
	@Size(min = 6, message ="Enter atleast 6 characters")
	private String purpose;

	
	public Todo(){
		
	}
	
	
	public Todo(int id, String user, String desc, Date targetDate, String purpose) {
		this.id = id;
		this.user = user;
		this.desc = desc;
		this.targetDate = targetDate;
		this.purpose = purpose;
	}


	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getUser() {
		return user;
	}
	public void setUser(String user) {
		this.user = user;
	}
	public String getDesc() {
		return desc;
	}
	public void setDesc(String desc) {
		this.desc = desc;
	}
	public Date getTargetDate() {
		return targetDate;
	}
	public void setTargetDate(Date targetDate) {
		this.targetDate = targetDate;
	}
	public String getPurpose() {
		return purpose;
	}
	public void setPurpose(String purpose) {
		this.purpose = purpose;
	}
	@Override
	public String toString() {
		return String.format("ToString - Todo [id=%s, user=%s, desc=%s, targetDate=%s, purpose=%s]", id, user, desc, targetDate,
				purpose);
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Todo other = (Todo) obj;
		if (id != other.id)
			return false;
		return true;
	}
	
	
}
