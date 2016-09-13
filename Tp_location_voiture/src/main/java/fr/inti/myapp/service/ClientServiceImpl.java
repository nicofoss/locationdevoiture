package fr.inti.myapp.service;

import java.util.List;
import java.util.logging.Logger;

import org.springframework.transaction.annotation.Transactional;

import fr.inti.myapp.Dao.IClientDao;
import fr.inti.myapp.entities.Client;

@Transactional
public class ClientServiceImpl implements IClientService{

	Logger log = Logger.getLogger("ClientServiceImpl");
	
	private IClientDao dao;

	public void setDao(IClientDao dao) {
		this.dao = dao;
		log.info("dao client injecte");
	}

	@Override
	public Client add(Client t, Long idAgence) {
		
		return dao.add(t, idAgence);
	}

	@Override
	public List<Client> getAll() {
		
		return dao.getAll();
	}

	@Override
	public Client update(Client t) {
		
		return dao.update(t);
	}

	@Override
	public Client delete(Client t) {
		
		return dao.delete(t);
	}

	@Override
	public Client getClientById(Long id) {
		
		return dao.getClientById(id);
	}

}
