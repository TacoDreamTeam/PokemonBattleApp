package com.revature.service;

import java.util.List;

import com.revature.models.Trades;

public interface TradesService {

	public void insertTrades(Trades trade);
	
	public void updateTrades(Trades trade);
	
	public List<Trades> selectAllTrades();
	
	public Trades FindTradesById(int id);
	
	public void deleteTrades(int id);
}
