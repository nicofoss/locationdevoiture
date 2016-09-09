package fr.inti.myapp.service;

import fr.inti.myapp.entities.Client;

public interface IClientService extends IGenericService<Client>{
	
	public Client getClientById(Long id);

}
