package fr.inti.myapp.service;

import java.util.List;

import fr.inti.myapp.entities.Reservation;

public interface IReservationService{

	public Reservation add(Reservation r, Long idVoiture, Long idClient, Long idAgence);

	public List<Reservation> getAll();

	public Reservation update(Reservation r);

	public Reservation delete(Reservation r);

	public Reservation getReservationById(Long id);
}
