package com.revature.service;

import org.apache.log4j.Logger;

import com.revature.models.Trainer;
import com.revature.repo.TrainerDao;

public class Service {

	public static Trainer login(String trainerUsername, String password) {
		TrainerDao tDao=new TrainerDao();
		
		Trainer trainer=tDao.selectTrainerByUsername(trainerUsername);
		if (trainer!=null && trainer.getPassword().equals(password)){
			return trainer;
		}else {
			return null;
		}	
	}
	
}
