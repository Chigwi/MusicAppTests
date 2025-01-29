package org.openjfx.test9.model;

import javafx.beans.property.SimpleStringProperty;

public class Gens {
	
	private SimpleStringProperty Fav,Av;
	
	

	public Gens(String fav, String av) {
		super();
		if(fav == null) {
			Fav = new SimpleStringProperty("");
		}
		if(av == null) {
			Av = new SimpleStringProperty("");
		}
		Fav = new SimpleStringProperty(fav);
		Av = new SimpleStringProperty(av);
	}

	public String getFav() {
		return Fav.get();
	}

	public void setFav(String fav) {
		Fav.set(fav);
	}

	public String getAv() {
		return Av.get();
	}

	public void setAv(String av) {
		Av.set(av);
	}

	@Override
	public String toString() {
		return "Gens [Fav=" + Fav + ", Av=" + Av + "]";
	}
	
	

}
