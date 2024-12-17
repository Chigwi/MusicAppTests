package org.openjfx.test9.model;

import java.io.Serializable;
import java.util.HashSet;

public class Usuario implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String Username,Password;
	
	private HashSet <String> ListenedGenres,MyFavorites;
	
	
	
	
	public Usuario(String username, String password) {
		super();
		Username = username;
		Password = password;
		ListenedGenres = new HashSet <String>();
		MyFavorites = new HashSet <String>();
	}


	public String getUsername() {
		return Username;
	}


	public void setUsername(String username) {
		Username = username;
	}


	public String getPassword() {
		return Password;
	}


	public void setPassword(String password) {
		Password = password;
	}


	public HashSet<String> getListenedGenres() {
		return ListenedGenres;
	}


	public void setListenedGenres(HashSet<String> listenedGenres) {
		ListenedGenres = listenedGenres;
	}


	public HashSet<String> getMyfavorites() {
		return MyFavorites;
	}


	public void setMyfavorites(HashSet<String> myfavorites) {
		MyFavorites = myfavorites;
	}


	@Override
	public String toString() {
		return "User [Username=" + Username + ", ListenedGenres=" + ListenedGenres.size()+ ", MyFavorites=" + MyFavorites
				+ "]";
	}



	
	
}

