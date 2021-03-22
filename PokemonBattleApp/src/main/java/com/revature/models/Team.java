package com.revature.models;

import javax.persistence.*;

@Entity
@Table (name="team")
public class Team {
	@Id
	@Column(name="id")
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	
	@Column(name="trainer_id", nullable = false)
	private int trainerId;
	
	@Column(name="pokemon1_id", nullable = false)
	private int pokemonId1;
	
	@Column(name="pokemon2_id")
	private int pokemonId2;
	
	@Column(name="pokemon3_id")
	private int pokemonId3;
	
	@Column(name="pokemon4_id")
	private int pokemonId4;
	
	@Column(name="pokemon5_id")
	private int pokemonId5;
	
	@Column(name="pokemon6_id")
	private int pokemonId6;
	
	public Team() {
		
	}
	
	public Team(int trainerId, int pokemonId1) {
		super();
		this.trainerId = trainerId;
		this.pokemonId1 = pokemonId1;
	}
	
	

	public Team(int trainerId, int pokemonId1, int pokemonId2) {
		super();
		this.trainerId = trainerId;
		this.pokemonId1 = pokemonId1;
		this.pokemonId2 = pokemonId2;
	}
	

	public Team(int trainerId, int pokemonId1, int pokemonId2, int pokemonId3) {
		super();
		this.trainerId = trainerId;
		this.pokemonId1 = pokemonId1;
		this.pokemonId2 = pokemonId2;
		this.pokemonId3 = pokemonId3;
	}

	public Team(int trainerId, int pokemonId1, int pokemonId2, int pokemonId3, int pokemonId4) {
		super();
		this.trainerId = trainerId;
		this.pokemonId1 = pokemonId1;
		this.pokemonId2 = pokemonId2;
		this.pokemonId3 = pokemonId3;
		this.pokemonId4 = pokemonId4;
	}

	public Team(int trainerId, int pokemonId1, int pokemonId2, int pokemonId3, int pokemonId4, int pokemonId5) {
		super();
		this.trainerId = trainerId;
		this.pokemonId1 = pokemonId1;
		this.pokemonId2 = pokemonId2;
		this.pokemonId3 = pokemonId3;
		this.pokemonId4 = pokemonId4;
		this.pokemonId5 = pokemonId5;
	}

	public Team(int trainerId, int pokemonId1, int pokemonId2, int pokemonId3, int pokemonId4, int pokemonId5, int pokemonId6) {
		super();
		this.trainerId = trainerId;
		this.pokemonId1 = pokemonId1;
		this.pokemonId2 = pokemonId2;
		this.pokemonId3 = pokemonId3;
		this.pokemonId4 = pokemonId4;
		this.pokemonId5 = pokemonId5;
		this.pokemonId6 = pokemonId6;
	}
	

	public Team(int id, int trainerId, int pokemonId1, int pokemonId2, int pokemonId3, int pokemonId4, int pokemonId5,
			int pokemonId6) {
		super();
		this.id = id;
		this.trainerId = trainerId;
		this.pokemonId1 = pokemonId1;
		this.pokemonId2 = pokemonId2;
		this.pokemonId3 = pokemonId3;
		this.pokemonId4 = pokemonId4;
		this.pokemonId5 = pokemonId5;
		this.pokemonId6 = pokemonId6;
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

	public int getPokemonId1() {
		return pokemonId1;
	}

	public void setPokemonId1(int pokemonId1) {
		this.pokemonId1 = pokemonId1;
	}

	public int getPokemonId2() {
		return pokemonId2;
	}

	public void setPokemonId2(int pokemonId2) {
		this.pokemonId2 = pokemonId2;
	}

	public int getPokemonId3() {
		return pokemonId3;
	}

	public void setPokemonId3(int pokemonId3) {
		this.pokemonId3 = pokemonId3;
	}

	public int getPokemonId4() {
		return pokemonId4;
	}

	public void setPokemonId4(int pokemonId4) {
		this.pokemonId4 = pokemonId4;
	}

	public int getPokemonId5() {
		return pokemonId5;
	}

	public void setPokemonId5(int pokemonId5) {
		this.pokemonId5 = pokemonId5;
	}

	public int getPokemonId6() {
		return pokemonId6;
	}

	public void setPokemonId6(int pokemonId6) {
		this.pokemonId6 = pokemonId6;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		result = prime * result + pokemonId1;
		result = prime * result + pokemonId2;
		result = prime * result + pokemonId3;
		result = prime * result + pokemonId4;
		result = prime * result + pokemonId5;
		result = prime * result + pokemonId6;
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
		Team other = (Team) obj;
		if (id != other.id)
			return false;
		if (pokemonId1 != other.pokemonId1)
			return false;
		if (pokemonId2 != other.pokemonId2)
			return false;
		if (pokemonId3 != other.pokemonId3)
			return false;
		if (pokemonId4 != other.pokemonId4)
			return false;
		if (pokemonId5 != other.pokemonId5)
			return false;
		if (pokemonId6 != other.pokemonId6)
			return false;
		if (trainerId != other.trainerId)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Team [id=" + id + ", trainerId=" + trainerId + ", pokemonId1=" + pokemonId1 + ", pokemonId2="
				+ pokemonId2 + ", pokemonId3=" + pokemonId3 + ", pokemonId4=" + pokemonId4 + ", pokemonId5="
				+ pokemonId5 + ", pokemonId6=" + pokemonId6 + "]";
	}
	
	
}