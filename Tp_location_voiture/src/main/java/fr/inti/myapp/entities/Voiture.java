package fr.inti.myapp.entities;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;


@Entity
public class Voiture {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private Double kilometrage;
	private String model;
	private String annee;
	private Double prix;
	private String immatriculation;
	private int nbLocation;
	
	@ManyToOne()
	@JoinColumn(name = "ref_agence")
	private Agence agence;
	@OneToMany(mappedBy = "voiture")
	private List<Reservation> listReservation;
	
	
	
	//ctor
	public Voiture() {
		super();
	}

	public Voiture(Double kilometrage, String model, String annee, Double prix,
			String immatriculation) {
		super();
		this.kilometrage = kilometrage;
		this.model = model;
		this.annee = annee;
		this.prix = prix;
		this.immatriculation = immatriculation;
	}
	
	
	//getter setter

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Double getKilometrage() {
		return kilometrage;
	}

	public void setKilometrage(Double kilometrage) {
		this.kilometrage = kilometrage;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public String getAnnee() {
		return annee;
	}

	public void setAnnee(String annee) {
		this.annee = annee;
	}

	public Double getPrix() {
		return prix;
	}

	public void setPrix(Double prix) {
		this.prix = prix;
	}

	public String getImmatriculation() {
		return immatriculation;
	}

	public void setImmatriculation(String immatriculation) {
		this.immatriculation = immatriculation;
	}

	public Agence getAgence() {
		return agence;
	}

	public void setAgence(Agence agence) {
		this.agence = agence;
	}

	public List<Reservation> getListReservation() {
		return listReservation;
	}

	public void setListReservation(List<Reservation> listReservation) {
		this.listReservation = listReservation;
	}

	public int getNbLocation() {
		return nbLocation;
	}

	public void setNbLocation(int nbLocation) {
		this.nbLocation = nbLocation;
	}
	
	
	
	
	
}
