package fr.inti.myapp.Dao;

import java.util.List;
import java.util.logging.Logger;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import fr.inti.myapp.entities.Reservation;

public class ReservationDaoImpl implements IReservationDao{

	@PersistenceContext
	private EntityManager em;
	
	Logger log = Logger.getLogger("ReservationDAOImpl");
	
	@Override
	public Reservation add(Reservation t) {
		em.persist(t);
		log.info("la resa " + t.getId() + " a bien ete ajoute");
		return t;
	}

	@Override
	@SuppressWarnings("unchecked")
	public List<Reservation> getAll() {
		Query query = em.createQuery("from reservation");
		log.info("il y a " + query.getResultList().size() + " resa ds la bdd");
		return query.getResultList();
	}

	@Override
	public Reservation update(Reservation t) {
		em.merge(t);
		log.info("la resa " + t.getId() + " a bien ete update");
		return t;
	}

	@Override
	public Reservation delete(Reservation t) {
		em.remove(t);
		log.info("la resa " + t.getId() + " a bien ete supp");
		return null;
	}

	@Override
	public Reservation getReservationById(Long id) {
		Reservation r = em.find(Reservation.class, id);
		log.info("la resa " + r.getId() + " a bien ete trouve");
		return r;
	}

}
