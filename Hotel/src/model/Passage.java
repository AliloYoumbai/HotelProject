package model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "passage")
public class Passage implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	private int idP;
	private int codecl,refre;
	private String type;
	
	public Passage() {
		
	}
	public Passage(int codecl, int refre, String type) {
		super();
		this.codecl = codecl;
		this.refre = refre;
		this.type = type;
	}
	public int getCodecl() {
		return codecl;
	}
	public void setCodecl(int codecl) {
		this.codecl = codecl;
	}
	public int getRefre() {
		return refre;
	}
	public void setRefre(int refre) {
		this.refre = refre;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public int getId() {
		return idP;
	}
	public void setId(int id) {
		this.idP = id;
	}
	

}
