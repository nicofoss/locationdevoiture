package fr.inti.myapp.service;

import java.util.Date;
import java.util.List;
import java.util.logging.Logger;

import org.springframework.transaction.annotation.Transactional;

import fr.inti.myapp.Dao.IVoitureDao;
import fr.inti.myapp.entities.Voiture;

@Transactional
public class VoitureServiceImpl implements IVoitureService{

	Logger log = Logger.getLogger("AgenceServiceImpl");
	
	private IVoitureDao dao;
	
	public void setDao(IVoitureDao dao) {
		this.dao = dao;
	}

	@Override
	public Voiture add(Voiture t, Long idAgence) {
		
		return dao.add(t, idAgence);
	}

	@Override
	public List<Voiture> getAll() {
	
		return dao.getAll();
	}

	@Override
	public Voiture update(Voiture t) {
		
		return dao.update(t);
	}

	@Override
	public Voiture delete(Voiture t) {
		
		return dao.delete(t);
	}

	@Override
	public Voiture getVoitureById(Long id) {
		
		return dao.getVoitureById(id);
	}

	
	
	
}


















