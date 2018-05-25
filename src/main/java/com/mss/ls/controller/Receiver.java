package com.mss.ls.controller;

import java.util.Map;

import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import com.mss.ls.service.LocationService;


@Component
public class Receiver {

	LocationService locService;

	@Autowired
	public Receiver(LocationService locService) {
		this.locService = locService;
	}

	@Bean
	Queue queue() {
		return new Queue("LocMgmtQ", false);
	}

	@RabbitListener(queues = "LocMgmtQ")
	public void processMessage(Map<String, Object> loc) {
		System.out.println("Message received to update "+loc.get("LOCATION_NUMBER"));
		locService.updateEmployee((int) loc.get("LOCATION_NUMBER"),	(int) loc.get("EMPLOYEEID"));
	}
}