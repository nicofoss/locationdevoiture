package fr.inti.myapp.Dao;

import java.util.List;
import java.util.logging.Logger;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import fr.inti.myapp.entities.Agence;
import fr.inti.myapp.entities.Client;

public class ClientDaoImpl implements IClientDao{

	@PersistenceContext
	private EntityManager em;
	
	Logger log = Logger.getLogger("ClientDAOImpl");
	
	@Override
	public Client add(Client t, Long idAgence) {
		
		try {
			Agence a = em.find(Agence.class, idAgence);
			a.getListClient().add(t);
		} catch (Exception e) {
			log.info("impossible dassocier le client ac lagence");
		}
		
		em.persist(t);
		log.info("le client " + t.getId() + " a bien ete ajoute");
		return t;
	}

	@Override
	@SuppressWarnings("unchecked")
	public List<Client> getAll() {
		Query query = em.createQuery("from Client");
		log.info("l y a " + query.getResultList().size() + " client ds la bdd");
		return query.getResultList();
	}

	@Override
	public Client update(Client t) {
		em.merge(t);
		log.info("le client " + t.getId() + " a bien ete update");
		return t;
	}

	@Override
	public Client delete(Client t) {
		em.remove(t);
		log.info("le client " + t.getId() + " a bien ete supp");
		return t;
	}

	@Override
	public Client getClientById(Long id) {
		Client c = em.find(Client.class, id);
		log.info("le client " + c.getId() + " a bien ete trouve");
		return c;
	}

}
