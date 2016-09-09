package fr.inti.myapp.service;

import java.util.List;
import java.util.logging.Logger;

import org.springframework.transaction.annotation.Transactional;

import fr.inti.myapp.Dao.IAgenceDao;
import fr.inti.myapp.entities.Agence;

@Transactional
public class AgenceServiceImpl implements IAgenceService{
	
	Logger log = Logger.getLogger("AgenceServiceImpl");
	
	private IAgenceDao dao;

	public void setDao(IAgenceDao dao) {
		this.dao = dao;
		log.info("dao agence injecte");
	}

	@Override
	public Agence add(Agence t) {

		return dao.add(t);
	}

	@Override
	public List<Agence> getAll() {
		
		return dao.getAll();
	}

	@Override
	public Agence update(Agence t) {
		
		return dao.update(t);
	}

	@Override
	public Agence delete(Agence t) {
		
		return dao.delete(t);
	}

	@Override
	public Agence getAgenceById(Long id) {

		return dao.getAgenceById(id);
	}

	@Override
	public Agence getAgenceByName(String nom) {
		
		return dao.getAgenceByName(nom);
	}

}
