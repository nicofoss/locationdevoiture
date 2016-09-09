package fr.inti.myapp.Dao;

import java.util.List;
import java.util.logging.Logger;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import fr.inti.myapp.entities.Voiture;

public class VoitureDaoImpl implements IVoitureDao{

	@PersistenceContext
	private EntityManager em;
	
	Logger log = Logger.getLogger("VoitureDAOImpl");
	
	@Override
	public Voiture add(Voiture t) {
		em.persist(t);
		log.info("la voiture " + t.getId() + " a bien ete ajoute");
		return t;
	}

	@Override
	@SuppressWarnings("unchecked")
	public List<Voiture> getAll() {
		Query query = em.createQuery("from Voiture");
		log.info("il y a " + query.getResultList().size() + " voiture ds la bdd");
		return query.getResultList();
	}

	@Override
	public Voiture update(Voiture t) {
		em.merge(t);
		log.info("la voiture " + t.getId() + " a bien ete update");
		return t;
	}

	@Override
	public Voiture delete(Voiture t) {
		em.remove(t);
		log.info("la voiture " + t.getId() + " a bien ete supp");
		return t;
	}

	@Override
	public Voiture getVoitureById(Long id) {
		Voiture v = em.find(Voiture.class, id);
		log.info("la voiture " + v.getId() + " a bien ete trouve");
		return v;
	}

}
