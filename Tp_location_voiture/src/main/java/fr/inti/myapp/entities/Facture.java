package fr.inti.myapp.entities;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

@Entity
public class Facture {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private Date dateFacturation;
	
	@ManyToOne
	@JoinColumn(name = "ref_agence")
	private Agence agence;
	@OneToOne
	@JoinColumn(name = "ref_reservation")
	private Reservation reservation;
	
	
	//ctor
	public Facture() {
		super();
	}


	public Facture(Long id, Date dateFacturation) {
		super();
		this.id = id;
		this.dateFacturation = dateFacturation;
	}


	
	
	
	
	//setter getter
	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public Date getDateFacturation() {
		return dateFacturation;
	}


	public void setDateFacturation(Date dateFacturation) {
		this.dateFacturation = dateFacturation;
	}


	public Agence getAgence() {
		return agence;
	}


	public void setAgence(Agence agence) {
		this.agence = agence;
	}


	public Reservation getReservation() {
		return reservation;
	}


	public void setReservation(Reservation reservation) {
		this.reservation = reservation;
	}
	
	
	
	
	
}
