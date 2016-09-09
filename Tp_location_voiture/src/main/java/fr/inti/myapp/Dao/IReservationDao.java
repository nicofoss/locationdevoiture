package fr.inti.myapp.Dao;

import fr.inti.myapp.entities.Reservation;

public interface IReservationDao extends IgenericDao<Reservation>{

	
	public Reservation getReservationById(Long id);
}
