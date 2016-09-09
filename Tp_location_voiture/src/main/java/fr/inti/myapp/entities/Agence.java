package fr.inti.myapp.entities;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;

@Entity
public class Agence {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String nom;
	private String adresse;
	private String mail;
	
	@OneToMany(mappedBy = "agence")
	private List<Voiture> listVoiture;
	@OneToMany(mappedBy = "agence")
	private List<Facture> listFacture;
	@OneToMany
	@JoinTable(name = "liste_client")
	private List<Client> listClient;
	@OneToMany
	@JoinTable(name = "liste_reservation")
	private List<Reservation> listReservation;
	
	//ctor
	public Agence() {
		super();
	}

	public Agence(String nom, String adresse, String mail) {
		super();
		this.nom = nom;
		this.adresse = adresse;
		this.mail = mail;
	}

	
	
	
	
	
	//getter setter
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getAdresse() {
		return adresse;
	}

	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	public List<Voiture> getListVoiture() {
		return listVoiture;
	}

	public void setListVoiture(List<Voiture> listVoiture) {
		this.listVoiture = listVoiture;
	}

	public List<Facture> getListFacture() {
		return listFacture;
	}

	public void setListFacture(List<Facture> listFacture) {
		this.listFacture = listFacture;
	}

	public List<Client> getListClient() {
		return listClient;
	}

	public void setListClient(List<Client> listClient) {
		this.listClient = listClient;
	}

	public List<Reservation> getListReservation() {
		return listReservation;
	}

	public void setListReservation(List<Reservation> listReservation) {
		this.listReservation = listReservation;
	}
	
	
	
	
}
