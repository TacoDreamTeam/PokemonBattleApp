package com.revature.controller;

import java.util.List;

import com.revature.models.Trainer;

public interface TrainerController {

	public void insertTrainer(Trainer trainer); //registration
	
	public List<Trainer> selectAllTrainers();

	public Trainer trainerFindById(int id); //finding your friend
	
	public Trainer selectTrainerByUsername(String username); //finding your friend
	
	public Trainer login(String trainerUsername, String password); //logging in
	
}
