/**
 * @author Allyson
 * @since 15/12/24
 */
package org.openjfx.test9.model;

import java.io.Serializable;
import java.util.Arrays;
import java.util.HashSet;

public class Usuario implements Serializable {
	
	private int [] Dives,Wikis;
	
	private static final long serialVersionUID = 1L;
	
	private String Username,Password;
	
	private HashSet <String> ListenedGenres,MyFavorites,Avoided;
	
	
	private boolean loggedIn,last;
	
	
	
	
	
	public boolean isLast() {
		return last;
	}


	public void setLast(boolean last) {
		this.last = last;
	}


	public Usuario(String username, String password) {
		super();
		Username = username;
		Password = password;
		Dives = new int[1];
		Wikis = new int[1];
		ListenedGenres = new HashSet <String>();
		MyFavorites = new HashSet <String>();
		Avoided = new HashSet<String>();
	}


	public boolean isLoggedIn() {
		return loggedIn;
	}


	public void setLoggedIn(boolean loggedIn) {
		this.loggedIn = loggedIn;
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


	public HashSet <String> getAvoided() {
		return Avoided;
	}


	public void setAvoided(HashSet <String> avoided) {
		Avoided = avoided;
	}


	public int[] getDives() {
		return Dives;
	}


	public void setDives(int[] dives) {
		Dives = dives;
	}


	public int[] getWikis() {
		return Wikis;
	}


	public void setWikis(int[] wikis) {
		Wikis = wikis;
	}


	@Override
	public String toString() {
		return "Usuario [Dives=" + Arrays.toString(Dives) + ", Wikis=" + Arrays.toString(Wikis) + ", Username="
				+ Username + ", Password=" + Password + ", ListenedGenres=" + ListenedGenres + ", MyFavorites="
				+ MyFavorites + ", Avoided=" + Avoided + ", loggedIn=" + loggedIn + ", last=" + last + "]";
	}

	

	
	
}

