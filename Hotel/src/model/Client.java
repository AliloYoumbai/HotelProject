package model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "client")
public class Client implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	private int codecl	;
	private String nomcl, prenomcl;

	public Client(String nomcl, String prenomcl) {
		super();
		this.nomcl = nomcl;
		this.prenomcl = prenomcl;
	}

	public Client() {

	}

	public int getCodecl() {
		return codecl;
	}

	public void setCodecl(int codecl) {
		this.codecl = codecl;
	}

	public String getNomcl() {
		return nomcl;
	}

	public void setNomcl(String nomcl) {
		this.nomcl = nomcl;
	}

	public String getPrenomcl() {
		return prenomcl;
	}

	public void setPrenomcl(String prenomcl) {
		this.prenomcl = prenomcl;
	}
	
	
}
