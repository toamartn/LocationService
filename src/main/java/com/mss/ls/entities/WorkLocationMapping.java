package com.mss.ls.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="WORKLOCATION")
public class WorkLocationMapping implements Serializable{

	private static final long serialVersionUID = 1L;
	
	// Create table WORKLOCATION WORKLOCATION, EMPLOYEENAME, FLOOR, BRANCH, CITY, OCCUPIED
	
	@Id
	@Column(name="LOCATION_NUMBER")
	private Integer locationNumber=0;
	
	@Column(name="EMPLOYEEID")
	Integer employeeId=0;
	
	@Column(name="FLOOR")
	Integer floor;
	
	@Column(name="BRANCH")
	String branch;
	
	@Column(name="CITY")
	String city;
	
	@Column(name="OCCUPIED")
	Integer occupied;

	public Integer getFloor() {
		return floor;
	}

	public void setFloor(Integer floor) {
		this.floor = floor;
	}

	public String getBranch() {
		return branch;
	}

	public void setBranch(String branch) {
		this.branch = branch;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public Integer getOccupied() {
		return occupied;
	}

	public void setOccupied(Integer occupied) {
		this.occupied = occupied;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public String toString() {
		return "WorkLocationMapping [locationNumber=" + locationNumber + ", employeeID=" + employeeId + ", floor="
				+ floor + ", branch=" + branch + ", city=" + city + ", occupied=" + occupied + "]";
	}

	public WorkLocationMapping(Integer locationNumber, Integer employeeId, Integer floor, String branch, String city,
			Integer occupied) {
		super();
		this.locationNumber = locationNumber;
		this.employeeId = employeeId;
		this.floor = floor;
		this.branch = branch;
		this.city = city;
		this.occupied = occupied;
	}

	public Integer getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(Integer employeeId) {
		this.employeeId = employeeId;
	}

	public Integer getLocationNumber() {
		return locationNumber;
	}

	public void setLocationNumber(Integer locationNumber) {
		this.locationNumber = locationNumber;
	}

	public WorkLocationMapping() {
	}
}