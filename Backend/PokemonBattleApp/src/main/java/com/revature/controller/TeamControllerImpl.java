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
import com.revature.models.Pokemon;
import com.revature.models.Team;
import com.revature.service.PokeDeckService;
import com.revature.service.TeamService;


@Controller("teamController")
@CrossOrigin(origins = "http://localhost:4200")
public class TeamControllerImpl implements TeamController {

	private static Logger logger = Logger.getLogger(TeamControllerImpl.class);
	
	@Autowired
	private TeamService teamService;
	
//	public TeamControllerImpl() {
//		logger.trace("Injection session factory bean, TeamControllerImpl");
//	}
	
	
	@PostMapping("/TeamInsert")
	public  @ResponseBody ClientMessage insertTeam(@RequestBody Team team) {
		System.out.println("adding the Team (control)");
		logger.debug("adding the Team (control)");
		return(teamService.insertTeam(team)) ? REGISTRATION_SUCCESSFUL : SOMETHING_WRONG;
	}

	@GetMapping("/TeamGetAll")
	public @ResponseBody List<Team> selectAllTeams() {
		System.out.println("getting all the Team (control)");
		logger.debug("getting all the Team (control)");
		List<Team> teams=teamService.selectAllTeams();
		System.out.println("teams:");
		System.out.println(teams);
		return teamService.selectAllTeams();
	}
	
	@PostMapping("/TeamGetById")
	public @ResponseBody Team FindTeamById(@RequestBody Team team) {
		System.out.println("finding the Team by id (control)");
		logger.debug("finding the Team by id (control)");
		return teamService.FindTeamById(team.getId());
	}

	@PostMapping("/TeamUpdate")
	public @ResponseBody ClientMessage updateTeam(@RequestBody Team team) {
		System.out.println("updating the Team (control)");
		logger.debug("updating the Team (control)");
		return teamService.updateTeam(team) ? REGISTRATION_SUCCESSFUL : SOMETHING_WRONG;

	}

	@PostMapping("/TeamDelete")
	public @ResponseBody ClientMessage deleteTeam(@RequestBody Team team) {
		System.out.println("deleting the Team (control)");
		logger.debug("deleting the Team (control)");
		return teamService.deleteTeam(team.getId()) ? REGISTRATION_SUCCESSFUL : SOMETHING_WRONG;

	}

}
