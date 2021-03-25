package com.revature.service;

import java.util.List;

import com.revature.models.Team;

public interface TeamService {

	public boolean insertTeam(Team team);

	public List<Team> selectAllTeams();
	
	public void updateTeam(Team team);
	
	public void deleteTeam(int id); 
	
}
