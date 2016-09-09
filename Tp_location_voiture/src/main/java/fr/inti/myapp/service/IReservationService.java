package fr.inti.myapp.service;

import fr.inti.myapp.entities.Reservation;

public interface IReservationService extends IGenericService<Reservation>{

	public Reservation getReservationById(Long id);
}
