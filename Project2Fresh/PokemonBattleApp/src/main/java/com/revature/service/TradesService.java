package com.revature.service;

import java.util.List;

import com.revature.models.Trades;

public interface TradesService {

	public boolean insertTrades(Trades trade);
	
	public boolean updateTrades(Trades trade);
	
	public List<Trades> selectAllTrades();
	
	public Trades FindTradesById(int id);
	
	public boolean deleteTrades(int id);
}
