package fr.inti.myapp.Dao;

import fr.inti.myapp.entities.Client;

public interface IClientDao extends IgenericDao<Client>{

	public Client getClientById(Long id);
	
}
