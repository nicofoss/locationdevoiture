package fr.inti.myapp.Dao;

import java.util.List;
import java.util.logging.Logger;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import fr.inti.myapp.entities.Agence;
import fr.inti.myapp.entities.Client;
import fr.inti.myapp.entities.Reservation;
import fr.inti.myapp.entities.Voiture;
import fr.inti.myapp.tools.FonctionUtil;

public class ReservationDaoImpl implements IReservationDao{

	@PersistenceContext
	private EntityManager em;
	
	Logger log = Logger.getLogger("ReservationDAOImpl");
	
	@Override
	public Reservation add(Reservation t, Long idVoiture, Long idClient, Long idAgence) {
		
		Double prixVoiture = new Double(0D);
		
		try {
			Voiture v = em.find(Voiture.class, idVoiture);
			t.setVoiture(v);
			prixVoiture = v.getPrix();
		} catch (Exception e) {
			log.info("impossible dassocier la resa avec la voiture");
		}
		
		try {
			Client c = em.find(Client.class, idClient);
			t.setClient(c);
		} catch (Exception e) {
			log.info("impossible dassocier la resa ac le client");
		}
		
		try {
			Agence a = em.find(Agence.class, idAgence);
			a.getListReservation().add(t);
		} catch (Exception e) {
			log.info("impossible d associer la resa a une agence");
		}
		
		//ajout du prix 
		FonctionUtil fu = new FonctionUtil();
		t.setPrixTotal(fu.calculPrix(t.getDateDebut(), t.getDateFin(), prixVoiture));
		
		//sauvegarde ds la bdd
		em.persist(t);
		log.info("la resa " + t.getId() + " a bien ete ajoute");
		return t;
	}

	@Override
	@SuppressWarnings("unchecked")
	public List<Reservation> getAll() {
		Query query = em.createQuery("from Reservation");
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
