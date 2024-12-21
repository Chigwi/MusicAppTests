/**
 * @author Allyson
 * @since 15/12/24
 */
package org.openjfx.test9.services;


import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.HashMap;

import org.openjfx.test9.model.Usuario;





public class SeralizationControler {
	

		public void serializarUser(Usuario user, String path, String name) {
	    	try {
	    		System.out.println(path);
				FileOutputStream fos = new FileOutputStream(path + name);
				ObjectOutputStream oos = new ObjectOutputStream (fos);
				oos.writeObject(user);
				oos.close();
				fos.close();
				
			} catch (IOException e) {
				e.printStackTrace();
			}
			
	    }
		public void serializarUser(HashMap <String,Usuario> user, String path, String name) {
	    	try {
	    		System.out.println(path);
				FileOutputStream fos = new FileOutputStream(path + name);
				ObjectOutputStream oos = new ObjectOutputStream (fos);
				oos.writeObject(user);
				oos.close();
				fos.close();
				
			} catch (IOException e) {
				e.printStackTrace();
			}
			
	    }
	 public Usuario deserializarUser(String path, String name) {
		 	Usuario a = null;
			try {	
			FileInputStream fis = new FileInputStream (path + name);
			ObjectInputStream ois = new ObjectInputStream (fis);
			a = (Usuario) ois.readObject();
			
			ois.close();
			fis.close();
			
			} catch (IOException | ClassNotFoundException e) {
				//e.printStackTrace();
				return null;
			}
		return a;
		}
	 public Usuario deserializarUser(String name) {
		 	Usuario a = null;
			try {	
			FileInputStream fis = new FileInputStream (name);
			ObjectInputStream ois = new ObjectInputStream (fis);
			a = (Usuario) ois.readObject();
			
			ois.close();
			fis.close();
			
			} catch (IOException | ClassNotFoundException e) {
				//e.printStackTrace();
				return null;
			}
		return a;
	 }
		
	 
	 public void serializarString(String user, String path, String name) {
	    	try {
	    		System.out.println(path);
				FileOutputStream fos = new FileOutputStream(path + name);
				ObjectOutputStream oos = new ObjectOutputStream (fos);
				oos.writeObject(user);
				oos.close();
				fos.close();
				
			} catch (IOException e) {
				e.printStackTrace();
			}
			
	    }
	 
	 public String deserializarList(String path, String name) {
		 	String a = null;
			try {	
			FileInputStream fis = new FileInputStream (path + name);
			ObjectInputStream ois = new ObjectInputStream (fis);
			a = (String) ois.readObject();
			
			ois.close();
			fis.close();
			
			} catch (IOException | ClassNotFoundException e) {
				//e.printStackTrace();
				return null;
			}
		return a;
	 	}
	 
	 public void serializarStringA(String [] user, String path, String name) {
	    	try {
	    		System.out.println(path);
				FileOutputStream fos = new FileOutputStream(path + name);
				ObjectOutputStream oos = new ObjectOutputStream (fos);
				oos.writeObject(user);
				oos.close();
				fos.close();
				
			} catch (IOException e) {
				e.printStackTrace();
			}
			
	    }
	 
	 public String [] deserializarListA (String path, String name) {
		 	String [] a = null;
			try {	
			FileInputStream fis = new FileInputStream (path + name);
			ObjectInputStream ois = new ObjectInputStream (fis);
			a = (String []) ois.readObject();
			
			ois.close();
			fis.close();
			
			} catch (IOException | ClassNotFoundException e) {
				//e.printStackTrace();
				return null;
			}
		return a;
	 	}
	 

	}

