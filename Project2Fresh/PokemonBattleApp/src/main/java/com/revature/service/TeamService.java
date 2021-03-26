package com.revature.service;

import java.util.List;

import com.revature.models.Team;

public interface TeamService {

	public boolean insertTeam(Team team);

	public List<Team> selectAllTeams();
	
	public Team FindTeamById(int id);
	
	public boolean updateTeam(Team team);
	
	public boolean deleteTeam(int id); 
	
}
