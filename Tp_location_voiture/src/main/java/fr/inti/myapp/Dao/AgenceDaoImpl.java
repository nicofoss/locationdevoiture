package fr.inti.myapp.Dao;

import java.util.List;
import java.util.logging.Logger;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import fr.inti.myapp.entities.Agence;

public class AgenceDaoImpl implements IAgenceDao{

	@PersistenceContext
	private EntityManager em;
	
	Logger log = Logger.getLogger("AgenceDAOImpl");
	
	@Override
	public Agence add(Agence t) {
		em.persist(t);
		log.info("agence " + t.getId() +" bien ajoute");
		return t;
	}

	@Override
	@SuppressWarnings("unchecked")
	public List<Agence> getAll() {
		Query query = em.createQuery("from Agence");
		log.info("l y a " + query.getResultList().size() + " agence ds la bdd");
		return query.getResultList();
	}

	@Override
	public Agence update(Agence t) {
		em.merge(t);
		log.info("agence " + t.getId() +" bien update");
		return t;
	}

	@Override
	public Agence delete(Agence t) {
		em.remove(t);
		log.info("agence " + t.getId() +" bien supp");
		return null;
	}

	@Override
	public Agence getAgenceById(Long id) {
		Agence a = em.find(Agence.class, id);
		log.info("agence " + a.getId() + " bien trouve");
		return a;
	}

	@Override
	public Agence getAgenceByName(String nom) {
		Query query = em.createQuery("from Agence where nom = :x");
		query.setParameter("x", nom);
		log.info("agence : " + query.getResultList().get(0) + " bien trouve");
		return (Agence) query.getResultList().get(0);
	}
	

}
