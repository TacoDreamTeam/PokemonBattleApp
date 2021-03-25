package com.revature.service;

import org.apache.log4j.Logger;

import com.revature.models.Trainer;

public class Service {
	
	private static Logger log = Logger.getLogger(Service.class);
	private static TrainerService trainerService = new TrainerServiceImpl();

	public static Trainer login(String trainerUsername, String password) {
		
		Trainer t = trainerService.login(trainerUsername, password);
		log.info("Logining in Trainer username: " + t.getUsername());
		return t;
	}
	
	public static boolean registerTrainer(Trainer t) {
		trainerService.insertTrainer(t);
		return t.getTrainerId() != 0;
	}
	
}
