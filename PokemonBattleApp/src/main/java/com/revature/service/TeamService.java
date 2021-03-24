package com.revature.service;

import java.util.List;

import com.revature.models.Team;

public interface TeamService {

	public void insertTeam(Team team);
	
	public void updateTeam(Team team);
	
	public void deleteTeam(int id);
	
	public List<Team> selectAllTeam();
}
