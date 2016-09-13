package fr.inti.myapp.Dao;

import java.util.List;

import fr.inti.myapp.entities.Reservation;

public interface IReservationDao{

	public Reservation add(Reservation r, Long idVoiture, Long idClient, Long idAgence);
	
	public List<Reservation> getAll();
	
	public Reservation update(Reservation r);

	public Reservation delete(Reservation r);
	
	public Reservation getReservationById(Long id);
}
