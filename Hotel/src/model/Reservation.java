package model;
//reservation

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "reservation")
public class Reservation implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	private int refre;
	private String dated,datef;
	public Reservation() {
		
	}
	
	public Reservation(String dated, String datef) {
		super();
		this.dated = dated;
		this.datef = datef;
	}

	public int getRefre() {
		return refre;
	}
	public void setRefre(int refre) {
		this.refre = refre;
	}
	public String getDated() {
		return dated;
	}
	public void setDated(String dated) {
		this.dated = dated;
	}
	public String getDatef() {
		return datef;
	}
	public void setDatef(String datef) {
		this.datef = datef;
	}
	
}
