package com.revature.controller;

import java.util.List;

import com.revature.ajax.ClientMessage;
import com.revature.models.Trainer;

public interface TrainerController {

	public ClientMessage insertTrainer(Trainer trainer);
	
	public List<Trainer> selectAllTrainers();
	
	public Trainer trainerFindById(Trainer trainer);
	
	//public Trainer selectTrainerByUsername(String username);
	
	public Trainer selectTrainerByUsername(Trainer trainer);

	public ClientMessage deleteTrainer(Trainer trainer);
	
	public ClientMessage updateTrainer(Trainer trainer);
	
	public Trainer login(Trainer trainer);

	
}
