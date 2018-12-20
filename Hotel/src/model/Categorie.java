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
@Table(name = "categorie")
public class Categorie implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
    private int codecat;
	private String description;


	public Categorie(int codecat, String description) {
		this.codecat = codecat;
		this.description = description;
	}

	public Categorie(String description) {
		this.description = description;
	}
	public Categorie() {
		
	}
    public int getCodecat() {
		return codecat;
	}

	public void setCodecat(int codecat) {
		this.codecat = codecat;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String toString() {
		return codecat+" -  "+description;

	}




}
