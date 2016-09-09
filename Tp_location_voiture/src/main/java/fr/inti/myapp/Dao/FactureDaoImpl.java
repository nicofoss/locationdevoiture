package fr.inti.myapp.Dao;

import java.util.List;
import java.util.logging.Logger;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import fr.inti.myapp.entities.Facture;

public class FactureDaoImpl implements IFactureDao{

	@PersistenceContext
	private EntityManager em;
	
	Logger log = Logger.getLogger("FactureDAOImpl");
	
	@Override
	public Facture add(Facture t) {
		em.persist(t);
		log.info("la facture " + t.getId() + " a bien ete ajoute");
		return t;
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
