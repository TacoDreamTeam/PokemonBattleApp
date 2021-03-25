package com.revature.controller;

import java.util.List;

import com.revature.ajax.ClientMessage;
import com.revature.models.Trainer;

public interface TrainerController {

	public ClientMessage insertTrainer(Trainer trainer);
	
	public List<Trainer> selectAllTrainers();
	
	public Trainer trainerFindById(int id);
	
	public Trainer selectTrainerByUsername(String username);

	public void deleteTrainer(int id);
	
	public void updateTrainer(Trainer trainer);
	
	public Trainer login(String trainerUsername, String password);

	
}
