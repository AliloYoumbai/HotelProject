/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author mr-ali
 */
@Entity
@Table(name = "chambre")
public class Chambre implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	private int numch;
	

	private String desch, typech;
	private float prixch;
	private int codecat;

	

	public Chambre( String desch, String typech, float prixch,int codecat) {
		this.codecat = codecat;
		this.desch = desch;
		this.typech = typech;
		this.prixch = prixch;
	}

	public Chambre(int numch, String desch, String typech, float prixch, int codecat) {
		this.numch = numch;
		this.codecat = codecat;
		this.desch = desch;
		this.typech = typech;
		this.prixch = prixch;
	}


	public Chambre() {
		
	}
	public int getNumch() {
		return numch;
	}

	public void setNumch(int numch) {
		this.numch = numch;
	}

	public int getCodecat() {
		return codecat;
	}

	public void setCodecat(int codecat) {
		this.codecat = codecat;
	}

	public String getDesch() {
		return desch;
	}

	public void setDesch(String desch) {
		this.desch = desch;
	}

	public String getTypech() {
		return typech;
	}

	public void setTypech(String typech) {
		this.typech = typech;
	}

	public float getPrixch() {
		return prixch;
	}

	public void setPrixch(float prixch) {
		this.prixch = prixch;
	}
	
	public String toString() {
		return desch+" - type :"+typech+" Prix : "+prixch+" (DA)";
	}


}
