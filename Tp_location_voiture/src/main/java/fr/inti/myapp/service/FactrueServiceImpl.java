package fr.inti.myapp.service;

import java.util.List;
import java.util.logging.Logger;

import org.springframework.transaction.annotation.Transactional;

import fr.inti.myapp.Dao.IFactureDao;
import fr.inti.myapp.entities.Facture;

@Transactional
public class FactrueServiceImpl implements IFactureService{

	Logger log = Logger.getLogger("FactureServiceImpl");
	
	private IFactureDao dao;

	public void setDao(IFactureDao dao) {
		this.dao = dao;
		log.info("dao facture injecte");
	}

	@Override
	public Facture add(Facture facture, Long idAgence, Long idResa) {
		
		return dao.add(facture, idAgence, idResa);
	}

	@Override
	public List<Facture> getAll() {
		
		return dao.getAll();
	}

	@Override
	public Facture update(Facture t) {
		
		return dao.update(t);
	}

	@Override
	public Facture delete(Facture t) {
		
		return dao.delete(t);
	}

	@Override
	public Facture getFactureById(Long id) {
	
		return dao.getFactureById(id);
	}

}
