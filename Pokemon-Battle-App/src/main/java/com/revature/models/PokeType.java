package com.revature.models;
import javax.persistence.*;

@Entity
@Table (name="pokeType")
public class PokeType {
	@Id
	@Column(name="id")
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	
	@Column(name="type_name")
	private String typeName;
	
	@Column(name="normal")
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

	public PokeType(String typeName, double normal, double fire, double water, double grass, double electric,
			double ice, double fighting, double poison, double ground, double flying, double psychic, double bug,
			double rock, double ghost, double dragon, double dark, double steel, double fairy) {
		super();
		this.typeName = typeName;
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

	public PokeType(int id, String typeName, double normal, double fire, double water, double grass, double electric,
			double ice, double fighting, double poison, double ground, double flying, double psychic, double bug,
			double rock, double ghost, double dragon, double dark, double steel, double fairy) {
		super();
		this.id = id;
		this.typeName = typeName;
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

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTypeName() {
		return typeName;
	}

	public void setTypeName(String typeName) {
		this.typeName = typeName;
	}

	public double getNormal() {
		return normal;
	}

	public void setNormal(double normal) {
		this.normal = normal;
	}

	public double getFire() {
		return fire;
	}

	public void setFire(double fire) {
		this.fire = fire;
	}

	public double getWater() {
		return water;
	}

	public void setWater(double water) {
		this.water = water;
	}

	public double getGrass() {
		return grass;
	}

	public void setGrass(double grass) {
		this.grass = grass;
	}

	public double getElectric() {
		return electric;
	}

	public void setElectric(double electric) {
		this.electric = electric;
	}

	public double getIce() {
		return ice;
	}

	public void setIce(double ice) {
		this.ice = ice;
	}

	public double getFighting() {
		return fighting;
	}

	public void setFighting(double fighting) {
		this.fighting = fighting;
	}

	public double getPoison() {
		return poison;
	}

	public void setPoison(double poison) {
		this.poison = poison;
	}

	public double getGround() {
		return ground;
	}

	public void setGround(double ground) {
		this.ground = ground;
	}

	public double getFlying() {
		return flying;
	}

	public void setFlying(double flying) {
		this.flying = flying;
	}

	public double getPsychic() {
		return psychic;
	}

	public void setPsychic(double psychic) {
		this.psychic = psychic;
	}

	public double getBug() {
		return bug;
	}

	public void setBug(double bug) {
		this.bug = bug;
	}

	public double getRock() {
		return rock;
	}

	public void setRock(double rock) {
		this.rock = rock;
	}

	public double getGhost() {
		return ghost;
	}

	public void setGhost(double ghost) {
		this.ghost = ghost;
	}

	public double getDragon() {
		return dragon;
	}

	public void setDragon(double dragon) {
		this.dragon = dragon;
	}

	public double getDark() {
		return dark;
	}

	public void setDark(double dark) {
		this.dark = dark;
	}

	public double getSteel() {
		return steel;
	}

	public void setSteel(double steel) {
		this.steel = steel;
	}

	public double getFairy() {
		return fairy;
	}

	public void setFairy(double fairy) {
		this.fairy = fairy;
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
		result = prime * result + ((typeName == null) ? 0 : typeName.hashCode());
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
		if (typeName == null) {
			if (other.typeName != null)
				return false;
		} else if (!typeName.equals(other.typeName))
			return false;
		if (Double.doubleToLongBits(water) != Double.doubleToLongBits(other.water))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "PokeType [id=" + id + ", typeName=" + typeName + ", normal=" + normal + ", fire=" + fire + ", water="
				+ water + ", grass=" + grass + ", electric=" + electric + ", ice=" + ice + ", fighting=" + fighting
				+ ", poison=" + poison + ", ground=" + ground + ", flying=" + flying + ", psychic=" + psychic + ", bug="
				+ bug + ", rock=" + rock + ", ghost=" + ghost + ", dragon=" + dragon + ", dark=" + dark + ", steel="
				+ steel + ", fairy=" + fairy + "]";
	}
	
	
}
