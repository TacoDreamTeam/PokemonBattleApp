package com.revature.controller;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;

import com.revature.models.Trainer;
import com.revature.service.TrainerService;

public class TrainerControllerImpl implements TrainerController {

	private static Logger logger = Logger.getLogger(TrainerControllerImpl.class);
	
	@Autowired
	private TrainerService trainerService;
	
	public TrainerControllerImpl() {
		logger.trace("Injection session factory bean, TrainerControllerImpl");
	}
	
	@Override
	public void insertTrainer(Trainer trainer) {
		// TODO Auto-generated method stub

	}

	@Override
	public List<Trainer> selectAllTrainers() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Trainer trainerFindById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Trainer selectTrainerByUsername(String username) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Trainer login(String trainerUsername, String password) {
		// TODO Auto-generated method stub
		return null;
	}

}
