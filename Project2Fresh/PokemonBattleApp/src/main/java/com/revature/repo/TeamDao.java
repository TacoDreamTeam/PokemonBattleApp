package com.revature.repo;

import java.util.List;

import com.revature.models.Team;

public interface TeamDao {

	public void insertTeam(Team team);

	public List<Team> selectAllTeams();
	
	public void updateTeam(Team team);
	
	public void deleteTeam(int id); 
	
}
