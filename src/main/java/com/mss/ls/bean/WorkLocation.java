package com.mss.ls.bean;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "WorkLocation")
@XmlAccessorType(XmlAccessType.FIELD)
public class WorkLocation {

	@XmlElement
	int locationNumber;

	@XmlElement
	int employeeId;

	@XmlElement
	int floor;

	@XmlElement
	String branch;

	@XmlElement
	String city;

	@XmlElement
	int occupied;

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return super.toString();
	}

	public int getLocationNumber() {
		return locationNumber;
	}

	public int getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(int employeeId) {
		this.employeeId = employeeId;
	}

	public void setLocationNumber(int locationNumber) {
		this.locationNumber = locationNumber;
	}

	public int getFloor() {
		return floor;
	}

	public void setFloor(int floor) {
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

	public int getOccupied() {
		return occupied;
	}

	public void setOccupied(int occupied) {
		this.occupied = occupied;
	}

	public WorkLocation(int locationNumber, int employeeId, int floor, String branch, String city, int occupied) {
		super();
		this.locationNumber = locationNumber;
		this.employeeId = employeeId;
		this.floor = floor;
		this.branch = branch;
		this.city = city;
		this.occupied = occupied;
	}

	public WorkLocation() {
		super();
	}
}