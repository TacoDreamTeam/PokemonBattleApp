package com.revature.controller;

import java.util.List;

import com.revature.ajax.ClientMessage;
import com.revature.models.Trades;

public interface TradesController {

	public ClientMessage insertTrades(Trades trade);
	
	public ClientMessage updateTrades(Trades trade);
	
	public List<Trades> selectAllTrades();
	
	public Trades FindTradesById(Trades trade);
	
	public ClientMessage deleteTrades(Trades trade);

}
