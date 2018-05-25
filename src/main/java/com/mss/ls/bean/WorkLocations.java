package com.mss.ls.bean;

import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "WorkLocation")
@XmlAccessorType(XmlAccessType.FIELD)
public class WorkLocations {

	@XmlElement(name = "WorkLocation")
	private List<WorkLocation> locations;
	
	public WorkLocations() {
	}

	public List<WorkLocation> getLocations() {
		return locations;
	}

	public void setLocations(List<WorkLocation> locations) {
		this.locations = locations;
	}

	public WorkLocations(List<WorkLocation> locations) {
		super();
		this.locations = locations;
	}
}
