package com.mss.ls.controller;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.mss.ls.bean.WorkLocation;
import com.mss.ls.bean.WorkLocations;
import com.mss.ls.service.LocationService;

@Controller
@CrossOrigin
@RequestMapping("/locMgmt")	//	PATH
public class LocationController {
	
	@Autowired(required=true)
	private LocationService locationService;
	
	private static final Log log = LogFactory.getLog(LocationController.class);
	
	@PostMapping(value = "/create")	//	END POINT
	public @ResponseBody WorkLocation createLocation(@RequestBody WorkLocation location) {
		WorkLocation locationResponse = locationService.createLocation(location);
		return locationResponse;
	}

	@GetMapping(value = "/getAll")
	public @ResponseBody WorkLocations getAllLocations() {
		log.info("got request for ");
		List<WorkLocation> locs = locationService.getAllLocations();
		WorkLocations locations = new WorkLocations();
		locations.setLocations(locs);
		return locations;
	}

	@GetMapping(value = "/get/{id}")
	public @ResponseBody WorkLocation getLocations(@PathVariable ("id") int id) {
		log.info("got request for "+ id);
		WorkLocation  location = locationService.getLocation(id);
		return location;
	}

	@PutMapping(value = "/update/{oldId}/{newId}")
	public @ResponseBody WorkLocation updateLocation(@PathVariable ("oldId") int oldLoc, @PathVariable ("newId") int newLoc) {
		WorkLocation locationResponse = locationService.updateLocation(oldLoc, newLoc);
		return locationResponse;
	}

	@DeleteMapping(value = "/delete/{id}")
	public @ResponseBody WorkLocation deleteeLocation(@PathVariable("id") int id) {
		WorkLocation location = locationService.deleteLocation(id);
		return location;
	}
}