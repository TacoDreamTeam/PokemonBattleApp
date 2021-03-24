package com.revature.models;

import java.util.List;

import javax.persistence.*;

@Entity
@Table (name="pokemon")
public class Pokemon {
	@Id
	@Column(name="id")
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	
	@Column(name="pokeApi", nullable = false)
	private int pokeApi;
	
	@Column(name="name", nullable = false)
	private String pokeName;
	
	@Column(name="type", nullable = false)
	private String typeId;
	
	@OneToMany(cascade=CascadeType.ALL, fetch = FetchType.LAZY)
	private List<PokeType> PokeType;
	
	public Pokemon() {
		
	}

	public Pokemon(int pokeApi, String pokeName, String typeId) {
		super();
		this.pokeApi = pokeApi;
		this.pokeName = pokeName;
		this.typeId = typeId;
	}

	public Pokemon(int id, int pokeApi, String pokeName, String typeId) {
		super();
		this.id = id;
		this.pokeApi = pokeApi;
		this.pokeName = pokeName;
		this.typeId = typeId;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getPokeApi() {
		return pokeApi;
	}

	public void setPokeApi(int pokeApi) {
		this.pokeApi = pokeApi;
	}

	public String getPokeName() {
		return pokeName;
	}

	public void setPokeName(String pokeName) {
		this.pokeName = pokeName;
	}

	public String getTypeId() {
		return typeId;
	}

	public void setTypeId(String typeId) {
		this.typeId = typeId;
	}

	

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((PokeType == null) ? 0 : PokeType.hashCode());
		result = prime * result + id;
		result = prime * result + pokeApi;
		result = prime * result + ((pokeName == null) ? 0 : pokeName.hashCode());
		result = prime * result + ((typeId == null) ? 0 : typeId.hashCode());
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
		Pokemon other = (Pokemon) obj;
		if (PokeType == null) {
			if (other.PokeType != null)
				return false;
		} else if (!PokeType.equals(other.PokeType))
			return false;
		if (id != other.id)
			return false;
		if (pokeApi != other.pokeApi)
			return false;
		if (pokeName == null) {
			if (other.pokeName != null)
				return false;
		} else if (!pokeName.equals(other.pokeName))
			return false;
		if (typeId == null) {
			if (other.typeId != null)
				return false;
		} else if (!typeId.equals(other.typeId))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Pokemon [id=" + id + ", pokeApi=" + pokeApi + ", pokeName=" + pokeName + ", typeId=" + typeId + "]";
	}
	
	
}