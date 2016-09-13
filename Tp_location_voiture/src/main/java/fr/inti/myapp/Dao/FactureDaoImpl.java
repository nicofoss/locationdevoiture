package fr.inti.myapp.Dao;

import java.util.List;
import java.util.logging.Logger;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import fr.inti.myapp.entities.Agence;
import fr.inti.myapp.entities.Facture;
import fr.inti.myapp.entities.Reservation;

public class FactureDaoImpl implements IFactureDao{

	@PersistenceContext
	private EntityManager em;
	
	Logger log = Logger.getLogger("FactureDAOImpl");
	
	@Override
	public Facture add(Facture facture, Long idAgence, Long idResa) {
		
		try {
			Agence a = em.find(Agence.class, idAgence);
			facture.setAgence(a);
		} catch (Exception e) {
			log.info("la facture n a pas pu etre associer a lagence demandee");
		}
		
		try {
			Reservation r = em.find(Reservation.class, idResa);
			facture.setReservation(r);
		} catch (Exception e) {
			log.info("la facture na pas pu etre associee a la resa demandee");
		}
		
		em.persist(facture);
		log.info("la facture " + facture.getId() + " a bien ete ajoute");
		return facture;
	}

	@Override
	@SuppressWarnings("unchecked")
	public List<Facture> getAll() {
		Query query = em.createQuery("from Facture");
		log.info("il y a " + query.getResultList().size() + " facture ds la bdd");
		return query.getResultList();
	}

	@Override
	public Facture update(Facture t) {
		em.merge(t);
		log.info("la facture " + t.getId() + " a bien ete update");
		return t;
	}

	@Override
	public Facture delete(Facture t) {
		em.remove(t);
		log.info("la facture " + t.getId() + " a bien ete supp");
		return t;
	}

	@Override
	public Facture getFactureById(Long id) {
		Facture f = em.find(Facture.class, id);
		log.info("la facture " + f.getId() + " a bien ete trouve");
		return f;
	}

}
