package com.revature.models;

public class EffectiveTemplate {
	
	private String type1;
	private String type2;
	
	public EffectiveTemplate() {
		super();
	}

	public EffectiveTemplate(String type1, String type2) {
		super();
		this.type1 = type1;
		this.type2 = type2;
	}

	public String getType1() {
		return type1;
	}

	public void setType1(String type1) {
		this.type1 = type1;
	}

	public String getType2() {
		return type2;
	}

	public void setType2(String type2) {
		this.type2 = type2;
	}

	@Override
	public String toString() {
		return "EffectiveTemplate [type1=" + type1 + ", type2=" + type2 + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((type1 == null) ? 0 : type1.hashCode());
		result = prime * result + ((type2 == null) ? 0 : type2.hashCode());
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
		EffectiveTemplate other = (EffectiveTemplate) obj;
		if (type1 == null) {
			if (other.type1 != null)
				return false;
		} else if (!type1.equals(other.type1))
			return false;
		if (type2 == null) {
			if (other.type2 != null)
				return false;
		} else if (!type2.equals(other.type2))
			return false;
		return true;
	}
}
