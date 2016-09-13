package fr.inti.myapp.service;

import java.util.List;
import java.util.logging.Logger;

import org.springframework.transaction.annotation.Transactional;

import fr.inti.myapp.Dao.IReservationDao;
import fr.inti.myapp.entities.Reservation;

@Transactional
public class ReservationServiceImpl implements IReservationService{

	Logger log = Logger.getLogger("AgenceServiceImpl");
	
	private IReservationDao dao;

	public void setDao(IReservationDao dao) {
		this.dao = dao;
	}

	@Override
	public Reservation add(Reservation t, Long idVoiture, Long idClient, Long idAgence) {
		
		return dao.add(t, idVoiture, idClient, idAgence);
	}

	@Override
	public List<Reservation> getAll() {
		
		return dao.getAll();
	}

	@Override
	public Reservation update(Reservation t) {
		
		return dao.update(t);
	}

	@Override
	public Reservation delete(Reservation t) {
		
		return dao.delete(t);
	}

	@Override
	public Reservation getReservationById(Long id) {
		
		return dao.getReservationById(id);
	}

}
