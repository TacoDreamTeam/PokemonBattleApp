package com.revature.controller;

import static com.revature.util.ClientMessageUtil.REGISTRATION_SUCCESSFUL;
import static com.revature.util.ClientMessageUtil.SOMETHING_WRONG;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import com.revature.ajax.ClientMessage;
import com.revature.models.Trainer;
import com.revature.service.TrainerService;

@Controller("trainerController")
@CrossOrigin(origins = "http://localhost:4200")
public class TrainerControllerImpl implements TrainerController{

	private static Logger logger = Logger.getLogger(TrainerControllerImpl.class);
	
	@Autowired
	private TrainerService trainerService;
	
//	public TrainerControllerImpl() {
//		logger.trace("Injection session factory bean, TrainerControllerImpl");
//	}
	
	
	@PostMapping("/TrainerInsert")
	public @ResponseBody ClientMessage insertTrainer(@RequestBody Trainer trainer) {
		return(trainerService.insertTrainer(trainer)) ? REGISTRATION_SUCCESSFUL : SOMETHING_WRONG;
	}

	@GetMapping("/TrainerGetAll")
	public @ResponseBody List<Trainer> selectAllTrainers() {
		return trainerService.selectAllTrainers();
	}

	@PostMapping("/TrainerGetById")
	public @ResponseBody Trainer trainerFindById(@RequestBody Trainer trainer) {
		return trainerService.trainerFindById(trainer.getTrainerId());
	}

	@PostMapping("/TrainerGetByUsername")
	//public @ResponseBody Trainer selectTrainerByUsername(@RequestBody String username) {
	public @ResponseBody Trainer selectTrainerByUsername(@RequestBody Trainer trainer) {
		return trainerService.selectTrainerByUsername(trainer.getUsername());
	}

	@PostMapping("/TrainerDelete")
	public @ResponseBody ClientMessage deleteTrainer(@RequestBody Trainer trainer) {
		return trainerService.deleteTrainer(trainer.getTrainerId())? REGISTRATION_SUCCESSFUL : SOMETHING_WRONG;
	}

	@PostMapping("/TrainerUpdate")
	public @ResponseBody ClientMessage updateTrainer(@RequestBody Trainer trainer) {
		return trainerService.updateTrainer(trainer)? REGISTRATION_SUCCESSFUL : SOMETHING_WRONG;
	}

	@PostMapping("/Login")
	public @ResponseBody Trainer login(@RequestBody Trainer trainer) {
		return trainerService.login(trainer.getUsername(), trainer.getPassword());
	}

}
