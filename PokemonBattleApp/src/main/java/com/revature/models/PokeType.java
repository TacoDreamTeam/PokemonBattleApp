package com.revature.models;
import java.util.List;

import javax.persistence.*;

import org.hibernate.annotations.ColumnDefault;

@Cacheable
@Entity
@Table (name="poke_type")
public class PokeType {
	@Id
	@Column(name="id")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="PokeTypeSequence")
	@SequenceGenerator(name="PokeTypeSequence", sequenceName="HERO_SEQ", allocationSize=1)
	private int id;
	
	@Column(name="pokemon_type")
	private String pokemonType;
	
	@Column(name="normal")
	//@ColumnDefault("29")
	private double normal;
	
	@Column(name="fire")
	private double fire;
	
	@Column(name="water")
	private double water;
	
	@Column(name="grass")
	private double grass;
	
	@Column(name="electric")
	private double electric;
	
	@Column(name="ice")
	private double ice;
	
	@Column(name="fighting")
	private double fighting;
	
	@Column(name="poison")
	private double poison;
	
	@Column(name="ground")
	private double ground;
	
	@Column(name="flying")
	private double flying;
	
	@Column(name="psychic")
	private double psychic;
	
	@Column(name="bug")
	private double bug;
	
	@Column(name="rock")
	private double rock;
	
	@Column(name="ghost")
	private double ghost;
	
	@Column(name="dragon")
	private double dragon;
	
	@Column(name="dark")
	private double dark;
	
	@Column(name="steel")
	private double steel;
	
	@Column(name="fairy")
	private double fairy;
	

	
	public PokeType() {
		
	}



	public PokeType(int id, double normal, double fire, double water, double grass, double electric, double ice,
			double fighting, double poison, double ground, double flying, double psychic, double bug, double rock,
			double ghost, double dragon, double dark, double steel, double fairy) {
		super();
		this.id=id;
		this.normal = normal;
		this.fire = fire;
		this.water = water;
		this.grass = grass;
		this.electric = electric;
		this.ice = ice;
		this.fighting = fighting;
		this.poison = poison;
		this.ground = ground;
		this.flying = flying;
		this.psychic = psychic;
		this.bug = bug;
		this.rock = rock;
		this.ghost = ghost;
		this.dragon = dragon;
		this.dark = dark;
		this.steel = steel;
		this.fairy = fairy;
	}

	public PokeType(int id, String type, double normal, double fire, double water, double grass, double electric, double ice,
			double fighting, double poison, double ground, double flying, double psychic, double bug, double rock,
			double ghost, double dragon, double dark, double steel, double fairy) {
		super();
		this.id=id;
		this.pokemonType=type;
		this.normal = normal;
		this.fire = fire;
		this.water = water;
		this.grass = grass;
		this.electric = electric;
		this.ice = ice;
		this.fighting = fighting;
		this.poison = poison;
		this.ground = ground;
		this.flying = flying;
		this.psychic = psychic;
		this.bug = bug;
		this.rock = rock;
		this.ghost = ghost;
		this.dragon = dragon;
		this.dark = dark;
		this.steel = steel;
		this.fairy = fairy;
	}

	
	public PokeType(double normal, double fire, double water, double grass, double electric, double ice,
			double fighting, double poison, double ground, double flying, double psychic, double bug, double rock,
			double ghost, double dragon, double dark, double steel, double fairy) {
		super();
		this.normal = normal;
		this.fire = fire;
		this.water = water;
		this.grass = grass;
		this.electric = electric;
		this.ice = ice;
		this.fighting = fighting;
		this.poison = poison;
		this.ground = ground;
		this.flying = flying;
		this.psychic = psychic;
		this.bug = bug;
		this.rock = rock;
		this.ghost = ghost;
		this.dragon = dragon;
		this.dark = dark;
		this.steel = steel;
		this.fairy = fairy;
	}

	public PokeType(String type, double normal, double fire, double water, double grass, double electric, double ice,
			double fighting, double poison, double ground, double flying, double psychic, double bug, double rock,
			double ghost, double dragon, double dark, double steel, double fairy) {
		super();
		this.pokemonType=type;
		this.normal = normal;
		this.fire = fire;
		this.water = water;
		this.grass = grass;
		this.electric = electric;
		this.ice = ice;
		this.fighting = fighting;
		this.poison = poison;
		this.ground = ground;
		this.flying = flying;
		this.psychic = psychic;
		this.bug = bug;
		this.rock = rock;
		this.ghost = ghost;
		this.dragon = dragon;
		this.dark = dark;
		this.steel = steel;
		this.fairy = fairy;
	}


	public String getType() {
		return pokemonType;
	}



	public void setType(String pokemonType) {
		this.pokemonType = pokemonType;
	}



	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}



	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}



	/**
	 * @return the normal
	 */
	public double getNormal() {
		return normal;
	}



	/**
	 * @param normal the normal to set
	 */
	public void setNormal(double normal) {
		this.normal = normal;
	}



	/**
	 * @return the fire
	 */
	public double getFire() {
		return fire;
	}



	/**
	 * @param fire the fire to set
	 */
	public void setFire(double fire) {
		this.fire = fire;
	}



	/**
	 * @return the water
	 */
	public double getWater() {
		return water;
	}



	/**
	 * @param water the water to set
	 */
	public void setWater(double water) {
		this.water = water;
	}



	/**
	 * @return the grass
	 */
	public double getGrass() {
		return grass;
	}



	/**
	 * @param grass the grass to set
	 */
	public void setGrass(double grass) {
		this.grass = grass;
	}



	/**
	 * @return the electric
	 */
	public double getElectric() {
		return electric;
	}



	/**
	 * @param electric the electric to set
	 */
	public void setElectric(double electric) {
		this.electric = electric;
	}



	/**
	 * @return the ice
	 */
	public double getIce() {
		return ice;
	}



	/**
	 * @param ice the ice to set
	 */
	public void setIce(double ice) {
		this.ice = ice;
	}



	/**
	 * @return the fighting
	 */
	public double getFighting() {
		return fighting;
	}



	/**
	 * @param fighting the fighting to set
	 */
	public void setFighting(double fighting) {
		this.fighting = fighting;
	}



	/**
	 * @return the poison
	 */
	public double getPoison() {
		return poison;
	}



	/**
	 * @param poison the poison to set
	 */
	public void setPoison(double poison) {
		this.poison = poison;
	}



	/**
	 * @return the ground
	 */
	public double getGround() {
		return ground;
	}



	/**
	 * @param ground the ground to set
	 */
	public void setGround(double ground) {
		this.ground = ground;
	}



	/**
	 * @return the flying
	 */
	public double getFlying() {
		return flying;
	}



	/**
	 * @param flying the flying to set
	 */
	public void setFlying(double flying) {
		this.flying = flying;
	}



	/**
	 * @return the psychic
	 */
	public double getPsychic() {
		return psychic;
	}



	/**
	 * @param psychic the psychic to set
	 */
	public void setPsychic(double psychic) {
		this.psychic = psychic;
	}



	/**
	 * @return the bug
	 */
	public double getBug() {
		return bug;
	}



	/**
	 * @param bug the bug to set
	 */
	public void setBug(double bug) {
		this.bug = bug;
	}



	/**
	 * @return the rock
	 */
	public double getRock() {
		return rock;
	}



	/**
	 * @param rock the rock to set
	 */
	public void setRock(double rock) {
		this.rock = rock;
	}



	/**
	 * @return the ghost
	 */
	public double getGhost() {
		return ghost;
	}



	/**
	 * @param ghost the ghost to set
	 */
	public void setGhost(double ghost) {
		this.ghost = ghost;
	}



	/**
	 * @return the dragon
	 */
	public double getDragon() {
		return dragon;
	}



	/**
	 * @param dragon the dragon to set
	 */
	public void setDragon(double dragon) {
		this.dragon = dragon;
	}



	/**
	 * @return the dark
	 */
	public double getDark() {
		return dark;
	}



	/**
	 * @param dark the dark to set
	 */
	public void setDark(double dark) {
		this.dark = dark;
	}



	/**
	 * @return the steel
	 */
	public double getSteel() {
		return steel;
	}



	/**
	 * @param steel the steel to set
	 */
	public void setSteel(double steel) {
		this.steel = steel;
	}



	/**
	 * @return the fairy
	 */
	public double getFairy() {
		return fairy;
	}



	/**
	 * @param fairy the fairy to set
	 */
	public void setFairy(double fairy) {
		this.fairy = fairy;
	}



	@Override
	public String toString() {
		return "PokeType [id=" + id + ", pokemonType=" + pokemonType + ", normal=" + normal + ", fire=" + fire + ", water=" + water
				+ ", grass=" + grass + ", electric=" + electric + ", ice=" + ice + ", fighting=" + fighting
				+ ", poison=" + poison + ", ground=" + ground + ", flying=" + flying + ", psychic=" + psychic + ", bug="
				+ bug + ", rock=" + rock + ", ghost=" + ghost + ", dragon=" + dragon + ", dark=" + dark + ", steel="
				+ steel + ", fairy=" + fairy + "]";
	}



	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		long temp;
		temp = Double.doubleToLongBits(bug);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(dark);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(dragon);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(electric);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(fairy);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(fighting);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(fire);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(flying);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(ghost);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(grass);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(ground);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(ice);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + id;
		temp = Double.doubleToLongBits(normal);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(poison);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(psychic);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(rock);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(steel);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + ((pokemonType == null) ? 0 : pokemonType.hashCode());
		temp = Double.doubleToLongBits(water);
		result = prime * result + (int) (temp ^ (temp >>> 32));
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
		PokeType other = (PokeType) obj;
		if (Double.doubleToLongBits(bug) != Double.doubleToLongBits(other.bug))
			return false;
		if (Double.doubleToLongBits(dark) != Double.doubleToLongBits(other.dark))
			return false;
		if (Double.doubleToLongBits(dragon) != Double.doubleToLongBits(other.dragon))
			return false;
		if (Double.doubleToLongBits(electric) != Double.doubleToLongBits(other.electric))
			return false;
		if (Double.doubleToLongBits(fairy) != Double.doubleToLongBits(other.fairy))
			return false;
		if (Double.doubleToLongBits(fighting) != Double.doubleToLongBits(other.fighting))
			return false;
		if (Double.doubleToLongBits(fire) != Double.doubleToLongBits(other.fire))
			return false;
		if (Double.doubleToLongBits(flying) != Double.doubleToLongBits(other.flying))
			return false;
		if (Double.doubleToLongBits(ghost) != Double.doubleToLongBits(other.ghost))
			return false;
		if (Double.doubleToLongBits(grass) != Double.doubleToLongBits(other.grass))
			return false;
		if (Double.doubleToLongBits(ground) != Double.doubleToLongBits(other.ground))
			return false;
		if (Double.doubleToLongBits(ice) != Double.doubleToLongBits(other.ice))
			return false;
		if (id != other.id)
			return false;
		if (Double.doubleToLongBits(normal) != Double.doubleToLongBits(other.normal))
			return false;
		if (Double.doubleToLongBits(poison) != Double.doubleToLongBits(other.poison))
			return false;
		if (Double.doubleToLongBits(psychic) != Double.doubleToLongBits(other.psychic))
			return false;
		if (Double.doubleToLongBits(rock) != Double.doubleToLongBits(other.rock))
			return false;
		if (Double.doubleToLongBits(steel) != Double.doubleToLongBits(other.steel))
			return false;
		if (pokemonType == null) {
			if (other.pokemonType != null)
				return false;
		} else if (!pokemonType.equals(other.pokemonType))
			return false;
		if (Double.doubleToLongBits(water) != Double.doubleToLongBits(other.water))
			return false;
		return true;
	}



	

	
	
	
}