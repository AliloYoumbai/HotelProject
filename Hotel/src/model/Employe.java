package model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "employe")
public class Employe {
	@Id
	private int codeemp;
	private String nomemp,prenomemp,adremp;
	private float salaireemp;
	private int codh;
	
	public Employe(String nomemp, String prenomemp, String adremp, float salaireemp, int codh) {
		super();
		this.nomemp = nomemp;
		this.prenomemp = prenomemp;
		this.adremp = adremp;
		this.salaireemp = salaireemp;
		this.codh = codh;
	}
	public Employe() {
		
	}
	public int getCodeemp() {
		return codeemp;
	}
	public void setCodeemp(int codeemp) {
		this.codeemp = codeemp;
	}
	public String getNomemp() {
		return nomemp;
	}
	public void setNomemp(String nomemp) {
		this.nomemp = nomemp;
	}
	public String getPrenomemp() {
		return prenomemp;
	}
	public void setPrenomemp(String prenomemp) {
		this.prenomemp = prenomemp;
	}
	public String getAdremp() {
		return adremp;
	}
	public void setAdremp(String adremp) {
		this.adremp = adremp;
	}
	public float getSalaireemp() {
		return salaireemp;
	}
	public void setSalaireemp(float salaireemp) {
		this.salaireemp = salaireemp;
	}
	public int getCodh() {
		return codh;
	}
	public void setCodh(int codh) {
		this.codh = codh;
	}
	

	

}
