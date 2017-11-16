package dev.sgpwepapi.entite;

import javax.persistence.*;

@Entity
@Table(name="COMPTE_BANCAIRE")
public class CompteBancaire {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private Integer id;
	
	@Column(name="NOM_BANQUE")
	private String nomBanque;
	
	@Column(name="BIC")
	private String bic;
	
	@Column(name="IBAN")
	private String iban;
	
	public CompteBancaire() {	}

	public CompteBancaire(String nomBanque, String bic, String iban) {
		super();
		this.nomBanque = nomBanque;
		this.bic = bic;
		this.iban = iban;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNomBanque() {
		return nomBanque;
	}

	public void setNomBanque(String nomBanque) {
		this.nomBanque = nomBanque;
	}

	public String getBic() {
		return this.bic;
	}

	public void setBic(String bic) {
		this.bic = bic;
	}

	public String getIban() {
		return iban;
	}

	public void setIban(String iban) {
		this.iban = iban;
	}
}
