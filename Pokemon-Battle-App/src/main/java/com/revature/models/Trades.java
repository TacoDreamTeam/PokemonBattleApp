package com.revature.models;

import javax.persistence.*;


@Entity
@Table (name="trades")
public class Trades {
	@Id
	@Column(name="id")
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	//This is the trainer who initiated the trade
	@Column(name="wants_trainer_id", nullable = false)
	private int wantsPokeId;
	//Selected/Potential trainer with said pokemon
	@Column(name="has_trainer_id")
	private int hasPokeId;
	//Initiated Trainer's pokemon to trade with
	@Column(name="pokemon_wanted_id", nullable = false)
	private int pokemonWanted;
	//Requested Pokemon for trade
	@Column(name="pokemon_had_id", nullable = false)
	private int pokemonHas;
	
	@Column(name="trade_status", nullable = false)
	private String status;
	
	
	public Trades() {
		
	}

	public Trades(int wantsPokeId, int pokemonWanter, int pokemonHaser) {
		super();
		this.wantsPokeId = wantsPokeId;
		this.pokemonWanted = pokemonWanter;
		this.pokemonHas = pokemonHaser;
	}

	public Trades(int wantsPokeId, int hasPokeId, int pokemonWanter, int pokemonHaser) {
		super();
		this.wantsPokeId = wantsPokeId;
		this.hasPokeId = hasPokeId;
		this.pokemonWanted = pokemonWanter;
		this.pokemonHas = pokemonHaser;
	}

	public Trades(int id, int wantsPokeId, int hasPokeId, int pokemonWanter, int pokemonHaser) {
		super();
		this.id = id;
		this.wantsPokeId = wantsPokeId;
		this.hasPokeId = hasPokeId;
		this.pokemonWanted = pokemonWanter;
		this.pokemonHas = pokemonHaser;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getWantsPokeId() {
		return wantsPokeId;
	}

	public void setWantsPokeId(int wantsPokeId) {
		this.wantsPokeId = wantsPokeId;
	}

	public int getHasPokeId() {
		return hasPokeId;
	}

	public void setHasPokeId(int hasPokeId) {
		this.hasPokeId = hasPokeId;
	}

	public int getPokemonWanted() {
		return pokemonWanted;
	}

	public void setPokemonWanted(int pokemonWanted) {
		this.pokemonWanted = pokemonWanted;
	}

	public int getPokemonHas() {
		return pokemonHas;
	}

	public void setPokemonHas(int pokemonHas) {
		this.pokemonHas = pokemonHas;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + hasPokeId;
		result = prime * result + id;
		result = prime * result + pokemonHas;
		result = prime * result + pokemonWanted;
		result = prime * result + wantsPokeId;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Trades other = (Trades) obj;
		if (hasPokeId != other.hasPokeId)
			return false;
		if (id != other.id)
			return false;
		if (pokemonHas != other.pokemonHas)
			return false;
		if (pokemonWanted != other.pokemonWanted)
			return false;
		if (wantsPokeId != other.wantsPokeId)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Trades [id=" + id + ", wantsPokeId=" + wantsPokeId + ", hasPokeId=" + hasPokeId + ", pokemonWanted="
				+ pokemonWanted + ", pokemonHas=" + pokemonHas + "]";
	}
	
}
