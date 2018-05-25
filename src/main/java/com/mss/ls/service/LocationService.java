package com.mss.ls.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.BeanWrapper;
import org.springframework.beans.BeanWrapperImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mss.ls.bean.WorkLocation;
import com.mss.ls.controller.Sender;
import com.mss.ls.dao.LocationDAODataJPA;
import com.mss.ls.entities.WorkLocationMapping;

@Service
public class LocationService {
	
	@Autowired
	private LocationDAODataJPA locationDAO;
	
	// @Autowired
	// private RestTemplate restTemplate;

	Sender sender;

	@Autowired
	public LocationService(Sender sender) {
		//this.restTemplate = new RestTemplate();
		this.sender = sender;
	}


	public List<WorkLocation> getAllLocations() {
		
		List<WorkLocationMapping> locationList = locationDAO.findAll();
		List<WorkLocation> locations = new ArrayList<WorkLocation>();
		
		for(WorkLocationMapping rec : locationList) {
			WorkLocation loc = new WorkLocation();
			locations.add(loc);
			BeanUtils.copyProperties(rec, loc, getNullPropertyNames(rec));
		}
		return locations;
	}

	public WorkLocation getLocation(int id) {
		WorkLocationMapping locationMapping = locationDAO.findOne(id);
		WorkLocation loc = new WorkLocation();
		BeanUtils.copyProperties(locationMapping, loc, getNullPropertyNames(locationMapping));
		return loc;
	}

	public WorkLocation createLocation(WorkLocation loc) {
		WorkLocationMapping locationMapping = new WorkLocationMapping();
		BeanUtils.copyProperties(loc, locationMapping, getNullPropertyNames(loc));
		locationMapping = locationDAO.save(locationMapping);
		BeanUtils.copyProperties(locationMapping, loc, getNullPropertyNames(locationMapping));
		return loc;
	}

	public WorkLocation updateLocation(int oldLoc, int newLoc) {
		
		WorkLocationMapping locMappingOld = locationDAO.findOne(oldLoc);
		WorkLocationMapping locMappingNew = locationDAO.findOne(newLoc);
		locMappingNew.setOccupied(1);
		locMappingNew.setEmployeeId(locMappingOld.getEmployeeId());
		locationDAO.save(locMappingNew);
		
		locMappingOld.setOccupied(0);
		locMappingOld.setEmployeeId(0);
		locationDAO.save(locMappingOld);
		
		WorkLocation loc = new WorkLocation();
		BeanUtils.copyProperties(locMappingNew, loc, getNullPropertyNames(locMappingNew));
		
		/////////////////////////////////////// Sending new location to EmpMgmt QUEUE ////////////////////////////
		Map<String, Object> deskDetails = new HashMap<String, Object>();
		deskDetails.put("LOCATION_NUMBER", locMappingNew.getLocationNumber());
		deskDetails.put("EMPLOYEEID", locMappingNew.getEmployeeId());
		sender.send(deskDetails);

		return loc;
	}
	
	 /**
     * Returns an array of null properties of an object
     * @param source
     * @return
     */
    private String[] getNullPropertyNames (Object source) {
	    final BeanWrapper src = new BeanWrapperImpl(source);
	    java.beans.PropertyDescriptor[] pds = src.getPropertyDescriptors();
 
	    Set emptyNames = new HashSet();
	    for(java.beans.PropertyDescriptor pd : pds) {
		//check if value of this property is null then add it to the collection
	        Object srcValue = src.getPropertyValue(pd.getName());
	        if (srcValue == null) emptyNames.add(pd.getName());
	    }
	    String[] result = new String[emptyNames.size()];
	    return (String[]) emptyNames.toArray(result);
	}

	public WorkLocation deleteLocation(int id) {
		
		WorkLocationMapping locationMapping = locationDAO.findOne(id);
		if(locationMapping!=null) {
			locationDAO.delete(new Integer(id));
		}
		WorkLocation loc = new WorkLocation();
		BeanUtils.copyProperties(locationMapping, loc, getNullPropertyNames(loc));
		return loc;
	}
}