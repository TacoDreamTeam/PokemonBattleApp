package com.revature.models;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

// Spring ORM is a module(library) that wraps around the JPA and works with Hibernate
@Entity
@Table(name="pokeDeck")
public class PokeDeck {
	@Id
	@Column(name="id")
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	
	@Column(name="trainer_id")
	private int trainerId;
	
	@Column(name="pokemon_id")
	private int pokemonId;
	
	@OneToMany(mappedBy="trainerDeck", fetch = FetchType.LAZY)
	private List<Trainer> trainList = new ArrayList<Trainer>();

	
	public PokeDeck() {
		
	}

	public PokeDeck(int trainerId, int pokemonId) {
		super();
		this.trainerId = trainerId;
		this.pokemonId = pokemonId;
	}

	public PokeDeck(int id, int trainerId, int pokemonId) {
		super();
		this.id = id;
		this.trainerId = trainerId;
		this.pokemonId = pokemonId;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getTrainerId() {
		return trainerId;
	}

	public void setTrainerId(int trainerId) {
		this.trainerId = trainerId;
	}

	public int getPokemonId() {
		return pokemonId;
	}

	public void setPokemonId(int pokemonId) {
		this.pokemonId = pokemonId;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		result = prime * result + pokemonId;
		result = prime * result + trainerId;
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
		PokeDeck other = (PokeDeck) obj;
		if (id != other.id)
			return false;
		if (pokemonId != other.pokemonId)
			return false;
		if (trainerId != other.trainerId)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "PokeDeck [id=" + id + ", trainerId=" + trainerId + ", pokemonId=" + pokemonId + "]";
	}
		
}