package com.revature.controller;

import java.util.List;

import com.revature.ajax.ClientMessage;
import com.revature.models.Team;

public interface TeamController {

	public ClientMessage insertTeam(Team team);

	public List<Team> selectAllTeams();
	
	public Team FindTeamById(Team team);
	
	public ClientMessage updateTeam(Team team);
	
	public ClientMessage deleteTeam(Team team); 

}
