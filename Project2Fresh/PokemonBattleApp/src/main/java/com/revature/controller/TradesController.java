package com.revature.controller;

import java.util.List;

import com.revature.ajax.ClientMessage;
import com.revature.models.Trades;

public interface TradesController {

	public ClientMessage insertTrades(Trades trade);
	
	public void updateTrades(Trades trade);
	
	public List<Trades> selectAllTrades();
	
	public Trades FindTradesById(int id);
	
	public void deleteTrades(int id);

}
